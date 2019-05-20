/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.fragment.controller.program.kp;

import org.openmrs.*;
import org.openmrs.module.kenyacore.form.FormManager;
import org.openmrs.module.kenyaemr.metadata.CommonMetadata;
import org.openmrs.module.kenyaemr.util.EmrUtils;
import org.openmrs.module.kenyaui.KenyaUiUtils;
import org.openmrs.module.metadatadeploy.MetadataUtils;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.openmrs.ui.framework.page.PageRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Patient summary fragment
 */
public class ClientSupportFragmentController {
	static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

	public void controller(@FragmentParam("patient") Patient patient,
						   @SpringBean FormManager formManager,
						   @SpringBean KenyaUiUtils kenyaUi,
						   PageRequest pageRequest,
						   UiUtils ui,
						   FragmentModel model) {


		EncounterType encSocialStatus = MetadataUtils.existing(EncounterType.class, CommonMetadata._EncounterType.SOCIAL_STATUS);
		Form formSocialStatus = MetadataUtils.existing(Form.class, CommonMetadata._Form.SOCIAL_STATUS);

		List<Encounter> encs = EmrUtils.AllEncounters(patient, encSocialStatus, formSocialStatus);
		List<SimpleObject> simplifiedEncData = new ArrayList<SimpleObject>();
		for (Encounter e : encs) {
			SimpleObject o = buildEncounterData(e.getObs(), e);
			simplifiedEncData.add(o);
		}
		model.addAttribute("patient", patient);
		model.addAttribute("encounters", simplifiedEncData);
	}

	public static SimpleObject buildEncounterData(Set<Obs> obsList, Encounter e) {

		int KPTYPE = 164930;
		int HOTSPOT = 164984;
		int SEX_ACTS_PER_WEEK = 164986;
		int ANAL_SEX_ACTS_PER_WEEK = 164987;
		int DAILY_DRUG_INJECTIONS = 164988;
		int WEEKLY_DRUG_INJECTIONS = 164989;


		String kpType = null;
		String frequentedHotspot = null;
		Integer weeklySexActs = null;
		Integer weeklyAnalSexActs = null;
		Integer dailyDrugInjections = null;
		Integer weeklyDrugInjections = null;
		String encDate = e != null? DATE_FORMAT.format(e.getEncounterDatetime()) : "";

		for(Obs obs:obsList) {

			if (obs.getConcept().getConceptId().equals(KPTYPE) ) {
				if (obs.getValueCoded().getConceptId().equals(164982)) {
					kpType = "FSW";
				} else if (obs.getValueCoded().getConceptId().equals(160578)) {
					kpType = "MSM";
				} else if (obs.getValueCoded().getConceptId().equals(164981)) {
					kpType = "MSW";
				} else if (obs.getValueCoded().getConceptId().equals(160666)) {
					kpType = "Drug User";
				} else if (obs.getValueCoded().getConceptId().equals(157351)) {
					kpType = "Drug Injector";
				}
			} else if (obs.getConcept().getConceptId().equals(HOTSPOT)) {
				frequentedHotspot = obs.getValueCoded() != null ?  obs.getValueCoded().getName().getName() : "";
			} else if (obs.getConcept().getConceptId().equals(SEX_ACTS_PER_WEEK)) {
				weeklySexActs = obs.getValueNumeric().intValue();
			}  else if (obs.getConcept().getConceptId().equals(ANAL_SEX_ACTS_PER_WEEK)) {
				weeklyAnalSexActs = obs.getValueNumeric().intValue();
			} else if (obs.getConcept().getConceptId().equals(DAILY_DRUG_INJECTIONS)) {
				dailyDrugInjections = obs.getValueNumeric().intValue();
			} else if (obs.getConcept().getConceptId().equals(WEEKLY_DRUG_INJECTIONS)) {
				weeklyDrugInjections = obs.getValueNumeric().intValue();
			}
		}

		return SimpleObject.create(
				"encDate", encDate,
				"kpType", kpType != null? kpType : "",
				"hotspot", frequentedHotspot != null ? frequentedHotspot : "",
				"weeklySexActs", weeklySexActs != null ? weeklySexActs : "",
				"weeklyAnalSexActs", weeklyAnalSexActs != null ? weeklyAnalSexActs : "",
				"dailyDrugInjections", dailyDrugInjections != null ? dailyDrugInjections : "",
				"weeklyDrugInjections",weeklyDrugInjections != null ? weeklyDrugInjections : ""

		);
	}

}