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
import org.openmrs.api.context.Context;
import org.openmrs.module.appframework.domain.AppDescriptor;
import org.openmrs.module.kenyacore.form.FormDescriptor;
import org.openmrs.module.kenyacore.form.FormManager;
import org.openmrs.module.kenyaemr.EmrConstants;
import org.openmrs.module.kenyaemr.fragment.controller.VisitAvailableFormsFragmentController;
import org.openmrs.module.kenyaui.KenyaUiUtils;
import org.openmrs.module.kenyaui.annotation.AppPage;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.openmrs.ui.framework.page.PageRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Patient forms
 */
@AppPage(EmrConstants.APP_CLINICIAN)
public class ActionsPanelFragmentController {

	protected static final Log log = LogFactory.getLog(VisitAvailableFormsFragmentController.class);

	public void controller(FragmentModel model,
						  @FragmentParam("patient") Patient patient,
						   @FragmentParam("visit") Visit visit,
						   UiUtils ui,
						   PageRequest request,
						   @SpringBean FormManager formManager,
						   @SpringBean KenyaUiUtils kenyaUi) {

		AppDescriptor currentApp = kenyaUi.getCurrentApp(request);

	List<FormDescriptor> completedForms = formManager.getCompletedFormsForVisit(currentApp, visit);

		List<Encounter> allEncounters = new ArrayList<Encounter>(visit.getEncounters());

		List<Encounter> encounters = new ArrayList<Encounter>();
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

		List<SimpleObject> availableForms = new ArrayList<SimpleObject>();

		for (FormDescriptor descriptor : formManager.getAllUncompletedFormsForVisit(currentApp, visit)) {
			availableForms.add(ui.simplifyObject(descriptor.getTarget()));
		}

		Collections.sort(encounters, new Comparator<Encounter>() {
			@Override
			public int compare(Encounter left, Encounter right) {
				return left.getEncounterDatetime().compareTo(right.getEncounterDatetime());
			}
		});

		model.addAttribute("availableForms", availableForms);
		model.addAttribute("encounters", encounters);
	}

}