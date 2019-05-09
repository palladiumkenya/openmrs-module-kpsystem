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
import org.openmrs.Patient;
import org.openmrs.Visit;
import org.openmrs.api.ConceptService;
import org.openmrs.api.ObsService;
import org.openmrs.api.context.Context;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.fragment.FragmentModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

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
        int counter = 0;
        for (Visit v : visitList) {
            counter++;
            //Return latest 5 visits
            if (counter > 5)
                break;
            boolean active = false;
            List<String> formList = new ArrayList<String>();
            if (v.getStopDatetime() == null)
                active = true;

          // loop through visit encounters
            for (Encounter encounter : v.getEncounters()) {
                if (encounter.isVoided()) {
                    continue;
                }
                formList.add(encounter.getForm().getName());
            }

            StringBuilder visitDetails = new StringBuilder().append(DATE_FORMAT.format(v.getStartDatetime()));
            if (v.getStopDatetime() != null)
                visitDetails.append(" - ").append(DATE_FORMAT.format(v.getStopDatetime()));

            visits.add(SimpleObject.create(
                    "visitDate", visitDetails.toString(),
                    "service", formList,
                    "active", active
            ));
        }

        return visits;

    }

}