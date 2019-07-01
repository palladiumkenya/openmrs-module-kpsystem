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
        for (Role userRole : userRoles ) {
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
        }
        else if (userRolesStr.contains(ROLE_DIRECTORY)) {
            userApp = APP_DIRECTORY;
        }else if (userRolesStr.contains(ROLE_ADMIN)) {
            userApp = APP_ADMIN;
        }else if (userRolesStr.contains(ROLE_FACILITIES)) {
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
        Set<String> c = new HashSet<String>();
        Set<String> summaryReportingForms = new HashSet<String>();


        communityOutreachForms.add("185dec84-df6f-4fc7-a370-15aa8be531ec"); //Contact form
        communityOutreachForms.add("050a7f12-5c52-4cad-8834-863695af335d"); //Referral and Linkage form
        communityOutreachForms.add("63917c60-3fea-11e9-b210-d663bd873d93");  //Tracing Form
        communityOutreachForms.add("bd12f98a-fcfe-4472-a858-17f28457932b");  //Referral form
        clinicalForms.add("c7f47cea-207b-11e9-ab14-d663bd873d93");  //Client enrollment form
        clinicalForms.add("318ad7be-e4da-481f-bcdd-0368cb7601c8");  //STI Treatment form
        clinicalForms.add("7ba743c8-d8e6-44ad-aeed-8d2ff9e985db");  //Alcohol screening form
        clinicalForms.add("5fe533ee-0c40-4a1f-a071-dc4d0fbb0c17");  //KP Depression screening form
        clinicalForms.add("d753bab3-0bbb-43f5-9796-5e95a5d641f3");  //HCW Overdose reporting form
        clinicalForms.add("92fd9c5a-c84a-483b-8d78-d4d7a600db30");  //KP Peer overdose reporting form
        clinicalForms.add("59ed8e62-7f1f-40ae-a2e3-eabe350277ce");  //TB Screening form
        clinicalForms.add("99979576-8854-11e9-bc42-526af7764f64");  //Client HIV Status form
        clinicalForms.add("402dc5d7-46da-42d4-b2be-f43ea4ad87b0");  //HTS Initial test
        clinicalForms.add("b08471f6-0892-4bf7-ab2b-bf79797b8ea4");  //HTS Confirmatory test form
        clinicalForms.add("92e041ac-9686-11e9-bc42-526af7764f64"); //kp Clinical visit form

        programLevelForms.add("10cd2ca0-8d25-4876-b97c-b568a912957e");  //Violence screening form

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

                if(communityOutreachForms.contains(descriptor.getTarget().getUuid())){

                    communityOutreachObj.add(ui.simplifyObject(descriptor.getTarget()));
                }
                else if(clinicalForms.contains(descriptor.getTarget().getUuid())){
                    clinicalObj.add(ui.simplifyObject(descriptor.getTarget()));
                }

                else if(programLevelForms.contains(descriptor.getTarget().getUuid())){
                    programLevelObj.add(ui.simplifyObject(descriptor.getTarget()));
                }
                else
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