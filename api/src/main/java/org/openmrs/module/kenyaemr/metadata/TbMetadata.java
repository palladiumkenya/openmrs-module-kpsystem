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
import org.openmrs.module.kenyaemr.Dictionary;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.metadatadeploy.bundle.Requires;
import org.springframework.stereotype.Component;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.encounterType;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.form;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.patientIdentifierType;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.program;

/**
 * TB metadata bundle
 */
@Component
@Requires({ CommonMetadata.class })
public class TbMetadata extends AbstractMetadataBundle {

	public static String tb_concept = "160541AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	public static final class _EncounterType {
		public static final String TB_DISCONTINUATION = "d3e3d723-7458-4b4e-8998-408e8a551a84";
		public static final String TB_ENROLLMENT = "9d8498a4-372d-4dc4-a809-513a2434621e";
		public static final String TB_SCREENING = "ed6dacc9-0827-4c82-86be-53c0d8c449be";
		public static final String TB_CONSULTATION = "fbf0bfce-e9f4-45bb-935a-59195d8a0e35";
	}

	public static final class _Form {
		public static final String TB_COMPLETION = "4b296dd0-f6be-4007-9eb8-d0fd4e94fb3a";
		public static final String TB_ENROLLMENT = "89994550-9939-40f3-afa6-173bce445c79";
		public static final String TB_SCREENING = "59ed8e62-7f1f-40ae-a2e3-eabe350277ce";
		public static final String TB_FOLLOW_UP = "2daabb77-7ad6-4952-864b-8d23e109c69d";
		public static final String GENE_XPERT = "f1eaceeb-c865-4e23-b68e-6523de403ac7";
	}

	public static final class _Program {
		public static final String TB = "9f144a34-3a4a-44a9-8486-6b7af6cc64f6";
	}

	/**
	 * @see AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {
		install(encounterType("TB Screening", "Screening of patient for TB", _EncounterType.TB_SCREENING));
		install(encounterType("TB Enrollment", "Enrollment onto TB program", _EncounterType.TB_ENROLLMENT));
		install(encounterType("TB Discontinuation", "Discontinuation from TB program", _EncounterType.TB_DISCONTINUATION));
		install(encounterType("TB FollowUp", "Consultation in TB Program", _EncounterType.TB_CONSULTATION));

		install(form("TB Screening", null, _EncounterType.TB_SCREENING, "1", _Form.TB_SCREENING));
		install(form("TB Enrollment", null, _EncounterType.TB_ENROLLMENT, "1", _Form.TB_ENROLLMENT));
		install(form("TB Discontinuation", null, _EncounterType.TB_DISCONTINUATION, "1", _Form.TB_COMPLETION));
		install(form("TB FollowUp" ,null, _EncounterType.TB_CONSULTATION, "1", _Form.TB_FOLLOW_UP));
		install(form("TB GeneXpert", null, _EncounterType.TB_SCREENING, "1", _Form.GENE_XPERT));


		install(program("TB", "Treatment for TB patients", tb_concept, _Program.TB));
	}
}