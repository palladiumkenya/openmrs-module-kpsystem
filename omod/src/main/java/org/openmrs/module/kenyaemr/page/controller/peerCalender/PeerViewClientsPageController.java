/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.page.controller.peerCalender;

import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.Person;
import org.openmrs.Relationship;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;
import org.openmrs.module.kenyaemr.EmrConstants;
import org.openmrs.module.kenyaemr.metadata.CommonMetadata;
import org.openmrs.module.kenyaemr.util.EmrUtils;
import org.openmrs.module.kenyaui.annotation.AppPage;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * View peer clients page for peer calender app
 */
@AppPage(EmrConstants.APP_PEER_CALENDER)
public class PeerViewClientsPageController {
	PersonService personService = Context.getPersonService();
    static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


    public void controller() {
	}
	public void get(@RequestParam("patientId") Patient patient, UiUtils ui, @RequestParam("effectiveDate") String effectiveDate,
					PageModel model){
		model.put("peers", getPeers(patient,effectiveDate));
		model.put("effectiveDate",effectiveDate);

	}

	public List<SimpleObject> getPeers( Patient patient, String effectiveDate) {

		Date entryEndDate = null;
		try {
			entryEndDate = DATE_FORMAT.parse(effectiveDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Date fromDate = getFirstDateOfMonth(entryEndDate);

		Encounter lastPeerCalendarForEducator = EmrUtils.lastEncounter(patient,
				Context.getEncounterService().getEncounterTypeByUuid(CommonMetadata._EncounterType.KP_PEER_CALENDAR),
				Context.getFormService().getFormByUuid(CommonMetadata._Form.KP_PEER_CALENDAR_FORM),
				fromDate,
				entryEndDate
				);

		List<SimpleObject> peer = new ArrayList<SimpleObject>();
		Person p = personService.getPerson(patient);

		peer.add(SimpleObject.create(
				"name",p.getGivenName()+" " + p.getMiddleName()
						+" "+p.getFamilyName(),
				"gender", p.getGender(),
				"age", p.getAge(),
				"birthdate", p.getBirthdate(),
				"id",p.getId(),
				"encounter", lastPeerCalendarForEducator != null ? lastPeerCalendarForEducator.getEncounterId() : null
		));



		for (Relationship relationship : Context.getPersonService().getRelationshipsByPerson(patient)) {
			try {
				Date endDate = new Date();
				Date startDate = new Date();
				if(relationship.getStartDate() !=null) {
					startDate = DATE_FORMAT.parse(relationship.getStartDate().toString());
				}

				if( relationship.getEndDate() !=null){
					endDate = DATE_FORMAT.parse(relationship.getEndDate().toString());
				}


				if (relationship.getRelationshipType().getbIsToA().equals("Peer") && startDate.before(endDate)) {
					if(endDate.after(endDate) || relationship.getEndDate() == null) {

						Person personB = relationship.getPersonB();
						Encounter lastPeerCalendarForPeer = EmrUtils.lastEncounter(Context.getPatientService().getPatient(personB.getPersonId()),
								Context.getEncounterService().getEncounterTypeByUuid(CommonMetadata._EncounterType.KP_PEER_CALENDAR),
								Context.getFormService().getFormByUuid(CommonMetadata._Form.KP_PEER_CALENDAR_FORM),
								fromDate,
								entryEndDate
						);

						peer.add(SimpleObject.create(
								"name", personB.getGivenName() + " " + personB.getMiddleName()
										+ " " + personB.getFamilyName(),
								"gender", personB.getGender(),
								"age", personB.getAge(),
								"birthdate", personB.getBirthdate(),
								"id", personB.getId(),
								"encounter", lastPeerCalendarForPeer != null ? lastPeerCalendarForPeer.getEncounterId() : null

						));
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}



		}
		return peer;
	}

	private Date getFirstDateOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}
}