/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.fragment.controller.patient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.Form;
import org.openmrs.Patient;
import org.openmrs.Visit;
import org.openmrs.api.ConceptService;
import org.openmrs.api.ObsService;
import org.openmrs.api.context.Context;
import org.openmrs.module.appframework.domain.AppDescriptor;
import org.openmrs.module.kenyacore.form.FormDescriptor;
import org.openmrs.module.kenyacore.form.FormManager;
import org.openmrs.module.kenyaemr.fragment.controller.VisitCompletedFormsFragmentController;
import org.openmrs.module.kenyaui.KenyaUiUtils;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.openmrs.ui.framework.page.PageRequest;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Visit summary fragment
 */
public class RecentVisitsFragmentController {

    protected static final Log log = LogFactory.getLog(RecentVisitsFragmentController.class);

    ObsService obsService = Context.getObsService();
    ConceptService conceptService = Context.getConceptService();
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

    public void controller(@FragmentParam(value = "visit",
            required = false) Visit visit,
                           @FragmentParam("patient") Patient patient,
                           FragmentModel model) {

        // date last seen (last 3 visits)

        /**
         * Get list of recent visits - 6 months ago
         */
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, -6);
        List<Visit> recentVisits = Context.getVisitService().getVisits(null,
                Collections.singleton(patient),
                null,
                null,
                now.getTime(),
                null,
                null,
                null,
                null,
                true,
                false
        );

        if (recentVisits != null) {
            model.put("recentVisits", getVisits(recentVisits));
        } else {
            model.put("recentVisits", null);
        }

    }

    private List<SimpleObject> getVisits(List<Visit> visitList) {

        List<SimpleObject> visits = new ArrayList<SimpleObject>();
        for (Visit v : visitList) {
            List<Encounter> allEncounters = new ArrayList<Encounter>(v.getEncounters());

            for (Encounter encounter : allEncounters) {
                String form = encounter.getForm().getName();

                if (encounter.isVoided()) {
                    continue;
                }

            if (v.getStopDatetime() == null) {

                visits.add(SimpleObject.create(
                        "visitDate", new StringBuilder().append(DATE_FORMAT.format(v.getStartDatetime())),
                        "service", new StringBuilder(form),
                        "active", true
                ));
            } else {

                visits.add(SimpleObject.create(
                        "visitDate", new StringBuilder().append(DATE_FORMAT.format(v.getStartDatetime()))
                                .append(" - ").append(DATE_FORMAT.format(v.getStopDatetime())),
                        "service", new StringBuilder(form),
                        "active", false
                ));
            }
        }
        }
        //Return latest 5 visits within the last 6 months
        if (visits.size() < 5) {
            return visits;
        } else {
            return visits.subList(0, 5);
        }

    }

}