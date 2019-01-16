/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.metadata;

import org.openmrs.PatientIdentifierType.LocationBehavior;
import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.metadatadeploy.bundle.Requires;
import org.springframework.stereotype.Component;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.encounterType;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.form;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.globalProperty;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.patientIdentifierType;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.program;

/**
 * HIV metadata bundle
 */
@Component
@Requires({ CommonMetadata.class })
public class KpMetadata extends AbstractMetadataBundle {

	public static final String MODULE_ID = "kenyaemr";
	public static final String LDL_DEFAULT_VALUE = MODULE_ID + ".LDL_default_value";

	public static String kp_concept = "bf850dd4-309b-4cbd-9470-9d8110ea5550";

	public static final class _EncounterType {
		public static final String HIV_ENROLLMENT = "de78a6be-bfc5-4634-adc3-5f1a280455cc";
		public static final String HIV_CONFIRMATION = "0c61819d-4f82-434e-b24d-aa8c82d49297";
		public static final String DRUG_ORDER = "7df67b83-1b84-4fe2-b1b7-794b4e9bfcc3";
		public static final String LAB_ORDER = "e1406e88-e9a9-11e8-9f32-f2801f1b9fd1";
	}

	public static final class _Form {

		public static final String DRUG_ORDER = "888dbabd-1c18-4653-82c2-e753415ab79a";

	}

	public static final class _PatientIdentifierType {
		public static final String UNIQUE_PATIENT_NUMBER = "7447335c-18a7-11e9-ab14-d663bd873d93";
	}

	public static final class _Program {
		public static final String KEY_POPULATION = "7447305a-18a7-11e9-ab14-d663bd873d93";
	}

	/**
	 * @see org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {

		install(encounterType("HIV Confirmation", "HIV Confirmatory Encounter", _EncounterType.HIV_CONFIRMATION));
		install(encounterType("Drug Order", "Drug Order", _EncounterType.DRUG_ORDER));
		install(encounterType("Lab Order", "Lab Order", _EncounterType.LAB_ORDER));

		install(form("Drug Order", "Drug Order", _EncounterType.DRUG_ORDER, "1", _Form.DRUG_ORDER));

		install(patientIdentifierType("Unique Patient Number", "Assigned to every KP client", null, null,
				null, LocationBehavior.NOT_USED, false, _PatientIdentifierType.UNIQUE_PATIENT_NUMBER));

		install(program("Key Population", "Treatment for Key Population clients", kp_concept, _Program.KEY_POPULATION));
		install(globalProperty(LDL_DEFAULT_VALUE, "Default value for LDL results. Required for graphing", "50"));
	}
}