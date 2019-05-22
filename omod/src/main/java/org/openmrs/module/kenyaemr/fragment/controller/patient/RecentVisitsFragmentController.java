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

import javax.xml.ws.Service;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.openmrs.module.kenyaemr.metadata.CommonMetadata._EncounterType.HTS;

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
            //List<String> formList = new ArrayList<String>();
            Set<String> serviceSet = new HashSet<String>();
            if (v.getStopDatetime() == null)
                active = true;

          // loop through visit encounters
            for (Encounter encounter : v.getEncounters()) {
                if (encounter.isVoided()) {
                    continue;
                }

                if (getFormService(encounter.getForm().getName())==""){
                    continue;
                }
                else {
                    serviceSet.add(getFormService(encounter.getForm().getName()));
                }
            }

            StringBuilder visitDetails = new StringBuilder().append(DATE_FORMAT.format(v.getStartDatetime()));
            if (v.getStopDatetime() != null)
                visitDetails.append(" - ").append(DATE_FORMAT.format(v.getStopDatetime()));

            visits.add(SimpleObject.create(
                    "visitDate", visitDetails.toString(),
                    "service", serviceSet,
                    "active", active
            ));
        }

        return visits;

    }

    private String getFormService (String form) {
        String key="";
        Map<String, List<String>> service = new HashMap<String, List<String>>();
        List<String> hts = new ArrayList<String>();
        List<String> tracing = new ArrayList<String>();
        List<String> triage = new ArrayList<String>();
        List<String> lab = new ArrayList<String>();
        List<String> consultation = new ArrayList<String>();
        List<String> contactListing = new ArrayList<String>();
        List<String> registration = new ArrayList<String>();
        List<String> screening = new ArrayList<String>();
        List<String> pharmacy = new ArrayList<String>();
        List<String> counselling = new ArrayList<String>();

        hts.add("HTS Initial Form");
        hts.add("HTS Retest Form");
        hts.add("Hiv status");
        triage.add("Triage");
        tracing.add("Client tracing");
        lab.add("Lab");
        consultation.add("Clinical Encounter");
        consultation.add("Clinical Notes Form");
        consultation.add("Complaints Form");
        consultation.add("Diagnosis and Treatment Plan");
        consultation.add("Adverse Drug Reactions Form");
        consultation.add("Review of Body Systems Form");
        consultation.add("Referral and Linkage Form");
        consultation.add("Progress Note");
        consultation.add("Chronic Illness Form");
        consultation.add("Exam and observation");
        consultation.add("STI Treatment");
        contactListing.add("Contact Listing Form");
        registration.add("Registration Form");
        registration.add("Social Status");
        registration.add("Enrollment");
        registration.add("Discontinuation");
        screening.add("Abscess Screening Form");
        screening.add("Alcohol Screening Form");
        screening.add("Cervical Cancer Screening Form");
        screening.add("Hepatitis B Screening Form");
        screening.add("Hepatitis C Screening Form");
        screening.add("Immunization Screening Form");
        screening.add("Allergies Screening Form");
        screening.add("Drug Overdose Screening Form");
        screening.add("Pep Screening Form");
        screening.add("Prep Screening Form");
        screening.add("Pregnancy and FP Screening Form");
        screening.add("Risk Reduction Screening form");
        screening.add("STI Screening Form");
        screening.add("Violence Screening Form");
        pharmacy.add("Current Medication Form");
        pharmacy.add("Counselling Services Form");

        service.put("HTS",hts);
        service.put("Triage",triage);
        service.put("Tracing",tracing);
        service.put("Consultation",consultation);
        service.put("Lab",lab);
        service.put("Contact Listing",contactListing);
        service.put("Registration",registration);
        service.put("Screening",screening);
        service.put("Pharmacy",pharmacy);
        service.put("Counselling",counselling);

        for (Map.Entry<String, List<String>> entry : service.entrySet()) {

            List<String> values = entry.getValue();
            for(int i = 0; i < values.size();i++){
                if (values.get(i).equals(form)) {
                    key = entry.getKey();
                    break;
                }
            }
        }
        return key;
    }
}