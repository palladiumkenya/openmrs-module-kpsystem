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

import org.openmrs.Patient;
import org.openmrs.Person;
import org.openmrs.Relationship;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;
import org.openmrs.module.kenyaemr.EmrConstants;
import org.openmrs.module.kenyaui.annotation.AppPage;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * View peer clients page for peer calender app
 */
@AppPage(EmrConstants.APP_PEER_CALENDER)
public class PeerViewClientsPageController {
	PersonService person = Context.getPersonService();
	
	public void controller() {
	}
	public void get(@RequestParam("patientId") Patient patient, UiUtils ui,
					PageModel model){
		model.put("peers", getPeers(patient));
	}

	public List<SimpleObject> getPeers( Patient patient) {
		List<SimpleObject> peer = new ArrayList<SimpleObject>();
		Person p = person.getPerson(patient);
		peer.add(SimpleObject.create(
				"name",p.getGivenName()+" " + p.getMiddleName()
						+" "+p.getFamilyName(),
				"gender", p.getGender(),
				"age", p.getAge(),
				"birthdate", p.getBirthdate(),
				"id",p.getId()
		));

		for (Relationship relationship : Context.getPersonService().getRelationshipsByPerson(patient)) {
			if (relationship.getRelationshipType().getbIsToA().equals("Peer")) {
				peer.add(SimpleObject.create(
						"name",relationship.getPersonB().getGivenName()+" " + relationship.getPersonA().getMiddleName()
						+" "+relationship.getPersonB().getFamilyName(),
						"gender", relationship.getPersonB().getGender(),
						"age", relationship.getPersonB().getAge(),
						"birthdate", relationship.getPersonB().getBirthdate(),
						"id",relationship.getPersonB().getId()
				));
			}
		}
		return peer;
	}
}