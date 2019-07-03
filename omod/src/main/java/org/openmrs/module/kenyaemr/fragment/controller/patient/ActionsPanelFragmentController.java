/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * <p>
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.fragment.controller.patient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.*;
import org.openmrs.api.context.Context;
import org.openmrs.module.appframework.domain.AppDescriptor;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.kenyacore.form.FormDescriptor;
import org.openmrs.module.kenyacore.form.FormManager;
import org.openmrs.module.kenyaemr.EmrConstants;
import org.openmrs.module.kenyaemr.fragment.controller.VisitAvailableFormsFragmentController;
import org.openmrs.module.kenyaui.KenyaUiConstants;
import org.openmrs.module.kenyaui.KenyaUiUtils;
import org.openmrs.module.kenyaui.annotation.AppPage;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.openmrs.ui.framework.page.PageContext;
import org.openmrs.ui.framework.page.PageRequest;

import java.util.*;

import static org.openmrs.module.kenyaemr.metadata.CommonMetadata._Form.*;
import static org.openmrs.module.kenyaemr.metadata.TbMetadata._Form.TB_SCREENING;

/**
 * Patient forms
 */
@AppPage(EmrConstants.APP_CLINICIAN)
public class ActionsPanelFragmentController {

    protected static final Log log = LogFactory.getLog(VisitAvailableFormsFragmentController.class);
    //define user apps
    static final String APP_CLINICIAN = "kenyaemr.medicalEncounter";
    static final String APP_REGISTRATION = "kenyaemr.registration";
    static final String APP_TRIAGE = "kenyaemr.intake";
    static final String APP_DATA_CLERK = "kenyaemr.medicalChart";
    static final String APP_MANAGER = "kenyaemr.medicalChart";
    static final String APP_DIRECTORY = "kenyaemr.directory";
    static final String APP_ADMIN = "kenyaemr.admin";
    static final String APP_FACILITIES = "kenyaemr.facilities";


    //define user roles
    static final String ROLE_CLINICIAN = "Clinician";
    static final String ROLE_REGISTRATION = "Registration";
    static final String ROLE_TRIAGE = "Intake";
    static final String ROLE_DATA_CLERK = "Data Clerk";
    static final String ROLE_MANAGER = "Manager";
    static final String ROLE_DIRECTORY = "kenyaemr.directory";
    static final String ROLE_ADMIN = "kenyaemr.admin";
    static final String ROLE_FACILITIES = "kenyaemr.facilities";
    static final String ROLE_SYSTEM_DEVELOPER = "Manager";


    public void controller(FragmentModel model,
                           @FragmentParam(value = "visit", required = false) Visit visit,
                           UiUtils ui,
                           PageRequest request,
                           PageContext pageContext,
                           @SpringBean FormManager formManager,
                           @SpringBean KenyaUiUtils kenyaUi) {


        User loggedInUser = Context.getUserContext().getAuthenticatedUser();
        Set<Role> userRoles = loggedInUser.getAllRoles();
        String userApp = null;
        Set<String> userRolesStr = new HashSet<String>();
        for (Role userRole : userRoles) {
            userRolesStr.add(userRole.getName());
        }

        if (userRolesStr.contains(ROLE_SYSTEM_DEVELOPER)) {
            userApp = APP_CLINICIAN;
        } else if (userRolesStr.contains(ROLE_CLINICIAN)) {
            userApp = APP_CLINICIAN;
        } else if (userRolesStr.contains(ROLE_REGISTRATION)) {
            userApp = APP_REGISTRATION;
        } else if (userRolesStr.contains(ROLE_TRIAGE)) {
            userApp = APP_TRIAGE;
        } else if (userRolesStr.contains(ROLE_DATA_CLERK)) {
            userApp = APP_DATA_CLERK;
        } else if (userRolesStr.contains(ROLE_DIRECTORY)) {
            userApp = APP_DIRECTORY;
        } else if (userRolesStr.contains(ROLE_ADMIN)) {
            userApp = APP_ADMIN;
        } else if (userRolesStr.contains(ROLE_FACILITIES)) {
            userApp = APP_FACILITIES;
        }
        //Mapping forms to kp tools
        List<SimpleObject> communityOutreachObj = new ArrayList<SimpleObject>();
        List<SimpleObject> clinicalObj = new ArrayList<SimpleObject>();
        List<SimpleObject> programLevelObj = new ArrayList<SimpleObject>();
        List<SimpleObject> commodityObj = new ArrayList<SimpleObject>();
        List<SimpleObject> summaryReportingObj = new ArrayList<SimpleObject>();

        Set<String> communityOutreachForms = new HashSet<String>();
        Set<String> clinicalForms = new HashSet<String>();
        Set<String> programLevelForms = new HashSet<String>();
        Set<String> commodityForms = new HashSet<String>();
        Set<String> summaryReportingForms = new HashSet<String>();


        communityOutreachForms.add(KP_CONTACT_FORM); //Contact form
        communityOutreachForms.add(REFERRAL_AND_LINKAGE); //Referral and Linkage form
        communityOutreachForms.add(KP_CLIENT_TRACING_FORM);  //Tracing Form
        communityOutreachForms.add(KP_REFERRAL_FORM);  //Referral form
        communityOutreachForms.add(KP_PEER_CALENDAR_FORM);  //Referral form

        clinicalForms.add(KP_CLIENT_ENROLLMENT);  //Client enrollment form
        clinicalForms.add(KP_STI_TREATMENT_FORM);  //STI Treatment form
        clinicalForms.add(KP_ALCOHOL_SCREENING_FORM);  //Alcohol screening form
        clinicalForms.add(KP_DEPRESSION_SCREENING_FORM);  //KP Depression screening form
        clinicalForms.add(KP_HCW_OVERDOSE_REPORTING_FORM);  //HCW Overdose reporting form
        clinicalForms.add(KP_PEER_OVERDOSE_REPORTING_FORM);  //KP Peer overdose reporting form
        clinicalForms.add(TB_SCREENING);  //TB Screening form
        clinicalForms.add(KP_CLIENT_HIV_STATUS_FORM);  //Client HIV Status form
        clinicalForms.add(HTS_INITIAL_TEST);  //HTS Initial test
        clinicalForms.add(HTS_CONFIRMATORY_TEST);  //HTS Confirmatory test form
        clinicalForms.add(KP_CLINICAL_VISIT_FORM); //kp Clinical visit form

        programLevelForms.add(KP_VIOLENCE_SCREENING_FORM);  //Violence screening form

        AppDescriptor currentApp = kenyaUi.getCurrentApp(request);
        AppDescriptor app = null;
        app = Context.getService(AppFrameworkService.class).getApp(userApp);
        pageContext.getRequest().getRequest().setAttribute(KenyaUiConstants.REQUEST_ATTR_CURRENT_APP, app);
        pageContext.getModel().addAttribute(KenyaUiConstants.MODEL_ATTR_CURRENT_APP, app);

        if (currentApp == null) {
            currentApp = app;
        }

        List<FormDescriptor> completedForms = new ArrayList<FormDescriptor>();
        List<SimpleObject> otherForms = new ArrayList<SimpleObject>();

        List<Encounter> encounters = new ArrayList<Encounter>();

        if (visit != null) {
            List<Encounter> allEncounters = new ArrayList<Encounter>(visit.getEncounters());
            completedForms = formManager.getCompletedFormsForVisit(currentApp, visit);
            for (Encounter encounter : allEncounters) {
                Form form = encounter.getForm();

                if (encounter.isVoided() || form == null) {
                    continue;
                }

                FormDescriptor descriptor = formManager.getFormDescriptor(form);

                if (completedForms.contains(descriptor)) {
                    encounters.add(encounter);
                }
            }

            for (FormDescriptor descriptor : formManager.getAllUncompletedFormsForVisit(currentApp, visit)) {

                if (communityOutreachForms.contains(descriptor.getTarget().getUuid())) {

                    communityOutreachObj.add(ui.simplifyObject(descriptor.getTarget()));
                } else if (clinicalForms.contains(descriptor.getTarget().getUuid())) {
                    clinicalObj.add(ui.simplifyObject(descriptor.getTarget()));
                } else if (programLevelForms.contains(descriptor.getTarget().getUuid())) {
                    programLevelObj.add(ui.simplifyObject(descriptor.getTarget()));
                } else
                    otherForms.add(ui.simplifyObject(descriptor.getTarget()));
            }

            Collections.sort(encounters, new Comparator<Encounter>() {
                @Override
                public int compare(Encounter left, Encounter right) {
                    return left.getEncounterDatetime().compareTo(right.getEncounterDatetime());
                }
            });

        }
        model.addAttribute("otherForms", otherForms);
        model.addAttribute("communityOutreachForms", communityOutreachObj);
        model.addAttribute("clinicalForms", clinicalObj);
        model.addAttribute("programLevelForms", programLevelObj);
        model.addAttribute("encounters", encounters);
    }

}