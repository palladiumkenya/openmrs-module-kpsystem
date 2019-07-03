/** * This Source Code Form is subject to the terms of the Mozilla Public License, * v. 2.0. If a copy of the MPL was not distributed with this file, You can * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under * the terms of the Healthcare Disclaimer located at http://openmrs.org/license. * * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS * graphic logo is a trademark of OpenMRS Inc. */package org.openmrs.module.kenyaemr.metadata;import org.openmrs.PatientIdentifierType.LocationBehavior;import org.openmrs.PersonAttributeType;import org.openmrs.module.idgen.validator.LuhnMod25IdentifierValidator;import org.openmrs.module.kenyaemr.EmrConstants;import org.openmrs.module.kenyaemr.datatype.FormDatatype;import org.openmrs.module.kenyaemr.datatype.LocationDatatype;import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;import org.springframework.stereotype.Component;import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.encounterType;import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.form;import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.globalProperty;import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.patientIdentifierType;import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.personAttributeType;import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.relationshipType;import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.visitAttributeType;import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.visitType;/** * Common metadata bundle */@Componentpublic class CommonMetadata extends AbstractMetadataBundle {	public static final class _EncounterType {		public static final String CONSULTATION = "465a92f2-baf8-42e9-9612-53064be868e8";		public static final String LAB_RESULTS = "17a381d1-7e29-406a-b782-aa903b963c28";		public static final String REGISTRATION = "de1f9d67-b73e-4e1b-90d0-036166fc6995";		public static final String TRIAGE = "55e67467-bd0b-4940-82c2-3281938afde3";		public static final String HTS = "9c0a7a57-62ff-4f75-babe-5835b0e921b7";		public static final String DRUG_REGIMEN_EDITOR = "7dffc392-13e7-11e9-ab14-d663bd873d93";		public static final String SOCIAL_STATUS = "f02eea5e-1f42-11e9-ab14-d663bd873d93";		public static final String KP_CLIENT_ENROLLMENT = "c7f47a56-207b-11e9-ab14-d663bd873d93";		public static final String KP_CLIENT_DISCONTINUATION = "d7142400-2495-11e9-ab14-d663bd873d93";		public static final String KP_CLIENT_TRACING = "ce841b19-0acd-46fd-b223-2ca9b5356237";		public static final String KP_CLIENT_HIV_STATUS = "999792ec-8854-11e9-bc42-526af7764f64";		public static final String KP_ABSCESS_SCREENING = "ffbf3e1a-2e6e-4ee2-9e31-2288e88f2e0b";		public static final String KP_ALCOHOL_SCREENING = "a3ce2705-d72d-458a-a76c-dae0f93398e7";		public static final String KP_APPOINTMENT_CREATION = "66609dee-3438-11e9-b210-d663bd873d93";		public static final String KP_CHRONIC_ILLNESS = "26bb869b-b569-4acd-b455-02c853e9f1e6";		public static final String KP_CLINICAL_NOTES = "bcbf6e3f-a2fc-421b-90a3-473a3158c796";		public static final String KP_COMPLAINTS = "2c3cf276-3676-11e9-b210-d663bd873d93";		public static final String KP_CURRENT_MEDICATION = "89767cca-13b9-411a-aa59-98656b096fd9";		public static final String KP_DIAGNOSIS_TREATMENT = "928ea6b2-3425-4ee9-854d-daa5ceaade03";		public static final String KP_DRUG_REACTIONS = "d7cfa460-2944-11e9-b210-d663bd873d93";		public static final String KP_HEPATITIS_SCREENING = "5c05a229-51b4-4b73-be13-0d93765a2a96";		public static final String KP_IMMUNIZATION_SCREENING = "9b8c17cc-3420-11e9-b210-d663bd873d93";		public static final String KP_ALLERGIES_SCREENING = "119362fb-6af6-4462-9fb2-7a09c43c9874";		public static final String KP_COUNSELLING_SERVICES = "28883f27-dfd1-4ce5-89f0-2a4f87974d15";		public static final String KP_OVERDOSE_SCREENING = "c3fb7831-f8fc-4b71-bd54-f23cdd77e305";		public static final String KP_PREP_PEP_SCREENING = "b06625d4-dfe4-458c-93fa-e878c8370733";		public static final String KP_PREGNANCY_AND_FP_SCREENING = "55d0b03e-8977-4d3e-8941-3333712b1afe";		public static final String KP_RISK_REDUCION_SCREENING = "dd06ac5c-70b4-4d8e-96a3-05edc9019f8f";		public static final String KP_STI_TREATMENT = "83610d13-d4fc-42c3-8c1d-a403cd6dd073";		public static final String KP_STI_DETAILED_TREATMENT = "2cc8c535-bbfa-4668-98c7-b12e3550ee7b";		public static final String KP_TB_SCREENING = "32e5ac6f-80cf-4908-aa88-200e3e199c68";		public static final String KP_SYSTEMS_EXAMINATION = "5568ab72-e951-4683-875e-c5781b6f7b81";		public static final String KP_VIOLENCE_SCREENING = "7b69daf5-b567-4384-9d29-f020c408d613";		public static final String KP_PSYCHOSOCIAL_SCREENING = "981c1420-4e83-4656-beb1-2461c45de532";		public static final String KP_DEPRESSION_SCREENING = "84220f19-9071-4745-9045-3b2f8d3dc128";		public static final String KP_PEER_OVERDOSE_REPORTING = "383974fe-58ef-488f-bdff-8962f4dd7518";		public static final String KP_HCW_OVERDOSE_REPORTING = "bd64b3b0-7bc9-4541-a813-8a917f623e2e";		public static final String KP_CONTACT = "ea68aad6-4655-4dc5-80f2-780e33055a9e";		public static final String KP_HEALTH_EDUCATION = "65c15b13-a795-4400-8791-159309b1c3bb";		public static final String KP_REFERRAL = "596f878f-5adf-4f8e-8829-6a87aaeda9a3";		public static final String KP_CLINICAL_VISIT_FORM = "92e03f22-9686-11e9-bc42-526af7764f64";		public static final String KP_PEER_CALENDAR = "c4f9db39-2c18-49a6-bf9b-b243d673c64d";	}	public static final class _Form {		public static final String CLINICAL_ENCOUNTER = "e958f902-64df-4819-afd4-7fb061f59308";		public static final String LAB_RESULTS = "7e603909-9ed5-4d0c-a688-26ecb05d8b6e";		public static final String PROGRESS_NOTE = "0038a296-62f8-4099-80e5-c9ea7590c157";		public static final String TRIAGE = "37f6bd8d-586a-4169-95fa-5781f987fe62";		public static final String HTS_INITIAL_TEST = "402dc5d7-46da-42d4-b2be-f43ea4ad87b0";		public static final String HTS_CONFIRMATORY_TEST = "b08471f6-0892-4bf7-ab2b-bf79797b8ea4";		public static final String REFERRAL_AND_LINKAGE = "050a7f12-5c52-4cad-8834-863695af335d";		public static final String CONTACT_LISTING = "d4493a7c-49fc-11e8-842f-0ed5f89f718b";		public static final String BASIC_REGISTRATION = "add7abdc-59d1-11e8-9c2d-fa7ae01bbebc";		public static final String DRUG_REGIMEN_EDITOR = "da687480-e197-11e8-9f32-f2801f1b9fd1";		public static final String SOCIAL_STATUS = "f02ee7e8-1f42-11e9-ab14-d663bd873d93";		public static final String KP_CLIENT_ENROLLMENT = "c7f47cea-207b-11e9-ab14-d663bd873d93";		public static final String KP_CLIENT_DISCONTINUATION = "1f76643e-2495-11e9-ab14-d663bd873d93";		public static final String KP_CLIENT_TRACING_FORM = "63917c60-3fea-11e9-b210-d663bd873d93";		public static final String KP_CLIENT_HIV_STATUS_FORM = "99979576-8854-11e9-bc42-526af7764f64";		public static final String KP_ABSCESS_SCREENING_FORM = "721c1c74-f54d-447a-9b10-66bf364eec04";		public static final String KP_ALCOHOL_SCREENING_FORM = "7ba743c8-d8e6-44ad-aeed-8d2ff9e985db";		public static final String KP_APPOINTMENT_CREATION_FORM = "7587529e-9d84-4947-953e-afe5643cc816";		public static final String KP_CHRONIC_ILLNESS_FORM = "458a1a0a-fb8e-4a37-a836-d47e63673b60";		public static final String KP_CLINICAL_NOTES_FORM = "7167549f-196d-4b7c-81d4-bbd11df704b1";		public static final String KP_COMPLAINTS_FORM = "da8a2442-5602-4bcd-986c-963f2a00bdcc";		public static final String KP_CURRENT_MEDICATION_FORM = "c18987d9-1a7a-4fbf-96d9-7b9b62ec26e0";		public static final String KP_DIAGNOSIS_TREATMENT_FORM = "30905fa8-5a35-4d11-a7a3-8e1016b8dc8f";		public static final String KP_DRUG_REACTIONS_FORM = "4464390d-025d-47bd-9619-64cb1d89a1da";		public static final String KP_HEPATITIS_SCREENING_FORM = "c0151dfc-6097-4eb1-8226-484303dcdc88";		public static final String KP_IMMUNIZATION_SCREENING_FORM = "2c2f1dea-1715-442e-9abe-71bc89ace1af";		public static final String KP_ALLERGIES_SCREENING_FORM = "cdad5adb-e352-4ecf-882d-b76b71be9c9d";		public static final String KP_COUNSELLING_SERVICES_FORM = "f78165e6-d2df-40ec-a0dd-2d63ef1cfc59";		public static final String KP_OVERDOSE_SCREENING_FORM = "9ce5b2d6-7c22-4fa8-8cca-edaad872c467";		public static final String KP_PREP_PEP_SCREENING_FORM = "a455aef4-56c8-4386-902e-b599c572f33f";		public static final String KP_PREGNANCY_AND_FP_SCREENING_FORM = "c534e64c-698f-47a9-b551-56e59ea5c6a0";		public static final String KP_RISK_REDUCION_SCREENING_FORM = "01d46fa8-a648-461c-a66f-5e8a125c8a54";		public static final String KP_STI_SCREENING_FORM = "d80d1c52-6a79-4c3d-b322-63eead834089";		public static final String KP_STI_TREATMENT_FORM = "318ad7be-e4da-481f-bcdd-0368cb7601c8";		public static final String KP_TB_SCREENING_FORM = "7719e79e-2e39-409c-8190-4b54b4a76cca";		public static final String KP_SYSTEMS_EXAMINATION_FORM = "20cf6054-a119-4168-a49a-8ce09830899d";		public static final String KP_VIOLENCE_SCREENING_FORM = "10cd2ca0-8d25-4876-b97c-b568a912957e";		public static final String KP_PSYCHOSOCIAL_SCREENING_FORM = "74acd5bb-1565-4261-a642-2bbc0d847e08";		public static final String KP_DEPRESSION_SCREENING_FORM = "5fe533ee-0c40-4a1f-a071-dc4d0fbb0c17";		public static final String KP_PEER_OVERDOSE_REPORTING_FORM = "92fd9c5a-c84a-483b-8d78-d4d7a600db30";		public static final String KP_HCW_OVERDOSE_REPORTING_FORM = "d753bab3-0bbb-43f5-9796-5e95a5d641f3";		public static final String KP_CONTACT_FORM = "185dec84-df6f-4fc7-a370-15aa8be531ec";		public static final String KP_HEALTH_EDUCATION_FORM = "67a224a5-907c-49e0-a1ea-e7c38b7a489d";		public static final String KP_REFERRAL_FORM = "bd12f98a-fcfe-4472-a858-17f28457932b";		public static final String KP_CLINICAL_VISIT_FORM = "92e041ac-9686-11e9-bc42-526af7764f64";		public static final String KP_PEER_CALENDAR_FORM = "7492cffe-5874-4144-a1e6-c9e455472a35";		}	public static final class _OrderType {		public static final String DRUG = "131168f4-15f5-102d-96e4-000c29c2a5d7";	}	public static final class _PatientIdentifierType {		public static final String NATIONAL_ID = "49af6cdc-7968-4abb-bf46-de10d7f4859f";		public static final String OLD_ID = "8d79403a-c2cc-11de-8d13-0010c6dffd0f";		public static final String OPENMRS_ID = "dfacd928-0370-4315-99d7-6ec1c9f7ae76";		public static final String PATIENT_CLINIC_NUMBER = "b4d66522-11fc-45c7-83e3-39a1af21ae0d";		public static final String UNIQUE_PATIENT_NUMBER = "05ee9cf4-7242-4a17-b4d4-00f707265c8a";		public static final String NATIONAL_UNIQUE_PATIENT_IDENTIFIER = "f85081e2-b4be-4e48-b3a4-7994b69bb101";		public static final String PASSPORT_NUMBER = "aec1b20e-1d8a-11e9-ab14-d663bd873d93";		public static final String KP_UNIQUE_PATIENT_NUMBER = "b7bfefd0-239b-11e9-ab14-d663bd873d93";	}	public static final class _PersonAttributeType {		public static final String NEXT_OF_KIN_ADDRESS = "7cf22bec-d90a-46ad-9f48-035952261294";		public static final String NEXT_OF_KIN_CONTACT = "342a1d39-c541-4b29-8818-930916f4c2dc";		public static final String NEXT_OF_KIN_NAME = "830bef6d-b01f-449d-9f8d-ac0fede8dbd3";		public static final String NEXT_OF_KIN_RELATIONSHIP = "d0aa9fd1-2ac5-45d8-9c5e-4317c622c8f5";		public static final String SUBCHIEF_NAME = "40fa0c9c-7415-43ff-a4eb-c7c73d7b1a7a";		public static final String TELEPHONE_CONTACT = "b2c38640-2603-4629-aebd-3b54f33f1e3a";		public static final String EMAIL_ADDRESS = "b8d0b331-1d2d-4a9a-b741-1816f498bdb6";		public static final String ALTERNATE_PHONE_CONTACT = "94614350-84c8-41e0-ac29-86bc107069be";		public static final String NEAREST_HEALTH_CENTER = "27573398-4651-4ce5-89d8-abec5998165c";		public static final String GUARDIAN_FIRST_NAME = "8caf6d06-9070-49a5-b715-98b45e5d427b";		public static final String GUARDIAN_LAST_NAME = "0803abbd-2be4-4091-80b3-80c6940303df";		public static final String CLIENT_ALIAS = "aec1b592-1d8a-11e9-ab14-d663bd873d93";		public static final String UNKNOWN_PATIENT = "29202ef6-8507-4259-8ec6-8048c1084024"; // required for registration of unknown persons	}	public static final class _Provider {		public static final String UNKNOWN = "ae01b8ff-a4cc-4012-bcf7-72359e852e14";	}	public static final class _RelationshipType {		public static final String SPOUSE = "d6895098-5d8d-11e3-94ee-b35a4132a5e3";		public static final String GUARDIAN_DEPENDANT = "5f115f62-68b7-11e3-94ee-6bef9086de92";		public static final String PARTNER = "007b765f-6725-4ae9-afee-9966302bace4";		public static final String CO_WIFE = "2ac0d501-eadc-4624-b982-563c70035d46";		public static final String PEER_EDUCATOR = "96adecc2-e7cd-41d0-b577-08eb4834abcb";	}	public static final class _VisitAttributeType {		public static final String SOURCE_FORM = "8bfab185-6947-4958-b7ab-dfafae1a3e3d";	}	public static final class _VisitType {		public static final String OUTPATIENT = "3371a4d4-f66f-4454-a86d-92c7b3da990c";	}	/**	 * @see org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle#install()	 */	@Override	public void install() {		//Installing encounters		install(encounterType("Consultation", "Collection of clinical data during the main consultation", _EncounterType.CONSULTATION));		install(encounterType("Lab Results", "Collection of laboratory results", _EncounterType.LAB_RESULTS));		install(encounterType("Registration", "Initial data collection for a patient, not specific to any program", _EncounterType.REGISTRATION));		install(encounterType("Triage", "Collection of limited data prior to a more thorough examination", _EncounterType.TRIAGE));		install(encounterType("HTS", "HTS Services", _EncounterType.HTS));		install(encounterType("Drug Regimen Editor", "Handles patient regimen events", _EncounterType.DRUG_REGIMEN_EDITOR));		install(encounterType("Social Status", "Collection of social status data", _EncounterType.SOCIAL_STATUS));		install(encounterType("KP Enrollment", "Handles KP client enrollment", _EncounterType.KP_CLIENT_ENROLLMENT));		install(encounterType("KP Discontinuation", "Records information about KP client discontinuation", _EncounterType.KP_CLIENT_DISCONTINUATION));		install(encounterType("KP Tracing", "Records information about KP tracing", _EncounterType.KP_CLIENT_TRACING));		install(encounterType("KP HIV Status", "Records information about KP Hiv Status", _EncounterType.KP_CLIENT_HIV_STATUS));		install(encounterType("KP Abscess screening", "Handles KP Abscess screening", _EncounterType.KP_ABSCESS_SCREENING));		install(encounterType("KP Alcohol screening", "Handles KP Alcohol screening", _EncounterType.KP_ALCOHOL_SCREENING));		install(encounterType("KP Appointment creation", "Handles KP Appointment creation", _EncounterType.KP_APPOINTMENT_CREATION));		install(encounterType("KP Chronic Illness Screening", "Handles KP Chronic Illness", _EncounterType.KP_CHRONIC_ILLNESS));		install(encounterType("KP Clinical notes", "Handles KP clinical notes", _EncounterType.KP_CLINICAL_NOTES));		install(encounterType("KP Complaints", "Handles KP complaints", _EncounterType.KP_COMPLAINTS));		install(encounterType("KP Current medication", "Handles KP current medication", _EncounterType.KP_CURRENT_MEDICATION));		install(encounterType("KP Diagnosis and Treatment", "Handles KP Diagnosis and treatment plan", _EncounterType.KP_DIAGNOSIS_TREATMENT));		install(encounterType("KP Adverse drug reactions", "Handles KP Adverse drug reactions", _EncounterType.KP_DRUG_REACTIONS));		install(encounterType("KP Hepatitis screening", "Handles KP Hepatits B screening", _EncounterType.KP_HEPATITIS_SCREENING));		install(encounterType("KP Immunization screening", "Handles KP Immunization screening", _EncounterType.KP_IMMUNIZATION_SCREENING));		install(encounterType("KP Allergies screening", "Handles KP Allergies screening", _EncounterType.KP_ALLERGIES_SCREENING));		install(encounterType("KP Counselling services", "Handles KP Counselling Services", _EncounterType.KP_COUNSELLING_SERVICES));		install(encounterType("KP Peer Overdose screening", "Handles KP Peer Overdose screening", _EncounterType.KP_OVERDOSE_SCREENING));		install(encounterType("KP Prophylaxis screening", "Handles KP Prophylaxis screening", _EncounterType.KP_PREP_PEP_SCREENING));		install(encounterType("KP Pregnancy and FP screening", "Handles KP Pregnancy and FP screening", _EncounterType.KP_PREGNANCY_AND_FP_SCREENING));		install(encounterType("KP Risk reduction screening", "Handles KP Risk reduction screening", _EncounterType.KP_RISK_REDUCION_SCREENING));		install(encounterType("KP STI treatment", "Handles KP STI treatment", _EncounterType.KP_STI_TREATMENT));		install(encounterType("KP STI Detailed treatment", "Handles KP STI Detailed treatment", _EncounterType.KP_STI_DETAILED_TREATMENT)); 		install(encounterType("KP TB screening", "Handles KP TB screening", _EncounterType.KP_TB_SCREENING));		install(encounterType("KP Systems examinations", "Handles KP systems examination", _EncounterType.KP_SYSTEMS_EXAMINATION));		install(encounterType("KP Violence screening", "Handles KP violence screening", _EncounterType.KP_VIOLENCE_SCREENING));		install(encounterType("KP Alcohol,drugs and risk reduction screening", "Handles KP alcohol,drugs and risk reduction screening", _EncounterType.KP_PSYCHOSOCIAL_SCREENING));		install(encounterType("KP Depression screening", "Handles KP depression screening", _EncounterType.KP_DEPRESSION_SCREENING));		install(encounterType("KP Peer Overdose reporting", "Handles KP Peer Overdose reporting", _EncounterType.KP_PEER_OVERDOSE_REPORTING));		install(encounterType("KP HCW Overdose reporting", "Handles KP HCW Overdose reporting", _EncounterType.KP_HCW_OVERDOSE_REPORTING));		install(encounterType("KP Contact", "Handles extra registration details for kp", _EncounterType.KP_CONTACT));		install(encounterType("KP Health Education", "Handles KP Health Education", _EncounterType.KP_HEALTH_EDUCATION));		install(encounterType("KP Referral", "Handles KP Referral", _EncounterType.KP_REFERRAL));		install(encounterType("KP Clinic visit form", "Handles KP Referral", _EncounterType.KP_CLINICAL_VISIT_FORM));		install(encounterType("KP Peer Calenda", "Handles KP Peer Calendar", _EncounterType.KP_PEER_CALENDAR));		//Installing forms		install(form("Clinical Encounter", null, _EncounterType.CONSULTATION, "1", _Form.CLINICAL_ENCOUNTER));		install(form("Lab Results", null, _EncounterType.LAB_RESULTS, "1", _Form.LAB_RESULTS));		install(form("Progress Note", "For additional information - mostly complaints and examination findings.", _EncounterType.CONSULTATION, "1", _Form.PROGRESS_NOTE));		install(form("Triage", null, _EncounterType.TRIAGE, "1", _Form.TRIAGE));		install(form("HTS Initial Form", "Form for HTS testing services ", _EncounterType.HTS, "1", _Form.HTS_INITIAL_TEST));		install(form("HTS Retest Form", "Form for HTS retest Services", _EncounterType.HTS, "1", _Form.HTS_CONFIRMATORY_TEST));		install(form("Referral and Linkage Form", "Form for referrals and linkages", _EncounterType.HTS, "1", _Form.REFERRAL_AND_LINKAGE));		install(form("Contact Listing Form", "Lists all contacts for a patient", _EncounterType.HTS, "1", _Form.CONTACT_LISTING));		install(form("Registration Form", "Initial data collection for a patient/client, not specific to any program", _EncounterType.REGISTRATION, "1", _Form.BASIC_REGISTRATION));		install(form("Drug Regimen Editor", null, _EncounterType.DRUG_REGIMEN_EDITOR, "1", _Form.DRUG_REGIMEN_EDITOR));		install(form("Social Status", null, _EncounterType.SOCIAL_STATUS, "1", _Form.SOCIAL_STATUS));		install(form("KP Enrollment", null, _EncounterType.KP_CLIENT_ENROLLMENT, "1", _Form.KP_CLIENT_ENROLLMENT));		install(form("Discontinuation", null, _EncounterType.KP_CLIENT_DISCONTINUATION, "1", _Form.KP_CLIENT_DISCONTINUATION));		install(form("Follow Up Tracking Form", null, _EncounterType.KP_CLIENT_TRACING, "1", _Form.KP_CLIENT_TRACING_FORM));		install(form("HIV Status", null, _EncounterType.KP_CLIENT_HIV_STATUS, "1", _Form.KP_CLIENT_HIV_STATUS_FORM));		install(form("Abscess Screening", null, _EncounterType.KP_ABSCESS_SCREENING, "1", _Form.KP_ABSCESS_SCREENING_FORM));		install(form("Alcohol Abuse Screening Tool", null, _EncounterType.KP_ALCOHOL_SCREENING, "1", _Form.KP_ALCOHOL_SCREENING_FORM));		install(form("Appointment Creation", null, _EncounterType.KP_APPOINTMENT_CREATION, "1", _Form.KP_APPOINTMENT_CREATION_FORM));		install(form("Chronic Illness", null, _EncounterType.KP_CHRONIC_ILLNESS, "1", _Form.KP_CHRONIC_ILLNESS_FORM));		install(form("Clinical Notes", null, _EncounterType.KP_CLINICAL_NOTES, "1", _Form.KP_CLINICAL_NOTES_FORM));		install(form("Complaints", null, _EncounterType.KP_COMPLAINTS, "1", _Form.KP_COMPLAINTS_FORM));		install(form("Current Medication Form", null, _EncounterType.KP_CURRENT_MEDICATION, "1", _Form.KP_CURRENT_MEDICATION_FORM));		install(form("Diagnosis and Treatment Plan", null, _EncounterType.KP_DIAGNOSIS_TREATMENT, "1", _Form.KP_DIAGNOSIS_TREATMENT_FORM));		install(form("Adverse Drug Reactions", null, _EncounterType.KP_DRUG_REACTIONS, "1", _Form.KP_DRUG_REACTIONS_FORM));		install(form("Hepatitis Screening", null, _EncounterType.KP_HEPATITIS_SCREENING, "1", _Form.KP_HEPATITIS_SCREENING_FORM));		install(form("Immunization Screening", null, _EncounterType.KP_IMMUNIZATION_SCREENING, "1", _Form.KP_IMMUNIZATION_SCREENING_FORM));		install(form("Allergies Screening", null, _EncounterType.KP_ALLERGIES_SCREENING, "1", _Form.KP_ALLERGIES_SCREENING_FORM));		install(form("Counselling Services", null, _EncounterType.KP_COUNSELLING_SERVICES, "1", _Form.KP_COUNSELLING_SERVICES_FORM));		install(form("Drug Overdose Screening", null, _EncounterType.KP_OVERDOSE_SCREENING, "1", _Form.KP_OVERDOSE_SCREENING_FORM));		install(form("Prep/Pep Services", null, _EncounterType.KP_PREP_PEP_SCREENING, "1", _Form.KP_PREP_PEP_SCREENING_FORM));		install(form("Pregnancy, FP and CaCx Screening", null, _EncounterType.KP_PREGNANCY_AND_FP_SCREENING, "1", _Form.KP_PREGNANCY_AND_FP_SCREENING_FORM));		install(form("Risk Reduction Screening", null, _EncounterType.KP_RISK_REDUCION_SCREENING, "1", _Form.KP_RISK_REDUCION_SCREENING_FORM));		install(form("STI Screening", null, _EncounterType.KP_STI_TREATMENT, "1", _Form.KP_STI_SCREENING_FORM));		install(form("STI Treatment", "Form for adding STI treatment details", _EncounterType.KP_STI_DETAILED_TREATMENT, "1", _Form.KP_STI_TREATMENT_FORM));		install(form("TB screening", null, _EncounterType.KP_TB_SCREENING, "1", _Form.KP_TB_SCREENING_FORM));		install(form("Review of Body systems", null, _EncounterType.KP_SYSTEMS_EXAMINATION, "1", _Form.KP_SYSTEMS_EXAMINATION_FORM));		install(form("Violence Reporting Form", "Violence Reporting tool", _EncounterType.KP_VIOLENCE_SCREENING, "1", _Form.KP_VIOLENCE_SCREENING_FORM));		install(form("Alcohol, Drugs and Risk Reduction Screening", null, _EncounterType.KP_PSYCHOSOCIAL_SCREENING, "1", _Form.KP_PSYCHOSOCIAL_SCREENING_FORM));		install(form("Depression Screening PHQ-9", null, _EncounterType.KP_DEPRESSION_SCREENING, "1", _Form.KP_DEPRESSION_SCREENING_FORM));		install(form("Peer Overdose Reporting Tool", "Peer Overdose Reporting Tool", _EncounterType.KP_PEER_OVERDOSE_REPORTING, "1", _Form.KP_PEER_OVERDOSE_REPORTING_FORM));		install(form("HCW Overdose Reporting Tool", "HCW Overdose Reporting Tool", _EncounterType.KP_HCW_OVERDOSE_REPORTING, "1", _Form.KP_HCW_OVERDOSE_REPORTING_FORM));		install(form("Contact form", null, _EncounterType.KP_CONTACT, "1", _Form.KP_CONTACT_FORM));		install(form("Peer Education", "Form for adding Health education", _EncounterType.KP_HEALTH_EDUCATION, "1", _Form.KP_HEALTH_EDUCATION_FORM));		install(form("Referral", "Form for adding referrals", _EncounterType.KP_REFERRAL, "1", _Form.KP_REFERRAL_FORM));		install(form("Clinic visit form", "Form for adding referrals", _EncounterType.KP_REFERRAL, "1", _Form.KP_CLINICAL_VISIT_FORM));		install(form("Peer Calendar", "Form for updating peer calendar", _EncounterType.KP_PEER_CALENDAR, "1", _Form.KP_PEER_CALENDAR_FORM));		install(globalProperty(EmrConstants.GP_DEFAULT_LOCATION, "The facility for which this installation is configured",				LocationDatatype.class, null, null));		String adxMappingString = "[{\"reportName\":\"MOH 731 Report- Green Card\",\"prefix\":\"Y18_\",\"datasets\":[{\"name\":\"2\",\"dhisName\":\"xUesg8lcmDs\"},{\"name\":\"1\",\"dhisName\":\"ptIUGFkE6jn\"},{\"name\":\"3\",\"dhisName\":\"Vo4KDrUFwnA\"}]}]";		install(globalProperty(EmrConstants.GP_DHIS2_DATASET_MAPPING, "ADX Mapping for KenyaEMR and DHIS2 datasets", adxMappingString));		install(globalProperty("order.drugDosingUnitsConceptUuid", "Drug dosing units concept", "162384AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));		// overriding this and setting the value to 1		install(globalProperty("registrationcore.identifierSourceId", "Specifies the identifier to use when generating patient identifiers", "1"));		install(patientIdentifierType("Old Identification Number", "Identifier given out prior to OpenMRS",				null, null, null,				LocationBehavior.NOT_USED, false, _PatientIdentifierType.OLD_ID));		install(patientIdentifierType("OpenMRS ID", "Medical Record Number generated by OpenMRS for every patient",				null, null, LuhnMod25IdentifierValidator.class,				LocationBehavior.REQUIRED, true, _PatientIdentifierType.OPENMRS_ID));		install(patientIdentifierType("Patient Clinic Number", "Assigned to the patient at a clinic service (not globally unique)",				".{1,15}", "At most 15 characters long", null,				LocationBehavior.REQUIRED, false, _PatientIdentifierType.PATIENT_CLINIC_NUMBER));		install(patientIdentifierType("National ID", "Kenyan national identity card number",				"\\d{5,10}", "Between 5 and 10 consecutive digits", null,				LocationBehavior.NOT_USED, false, _PatientIdentifierType.NATIONAL_ID));		install(patientIdentifierType("National Unique patient identifier", "National Unique patient identifier",				".{1,14}", "At most 14 characters long", null,				LocationBehavior.NOT_USED, false, _PatientIdentifierType.NATIONAL_UNIQUE_PATIENT_IDENTIFIER));		install(patientIdentifierType("Passport Number", "Patient/Client passport number",				null, null, null,				LocationBehavior.NOT_USED, false, _PatientIdentifierType.PASSPORT_NUMBER));		install(patientIdentifierType("KP unique Number", "Unique Number assigned to KP client upon enrollment",				null, null, null,				LocationBehavior.NOT_USED, false, _PatientIdentifierType.KP_UNIQUE_PATIENT_NUMBER));		install(personAttributeType("Telephone contact", "Telephone contact number",				String.class, null, false, 1.0, _PersonAttributeType.TELEPHONE_CONTACT));		install(personAttributeType("Email address", "Email address of person",				String.class, null, false, 2.0, _PersonAttributeType.EMAIL_ADDRESS));		// Patient only person attributes..		install(personAttributeType("Subchief name", "Name of subchief or chief of patient's area",				String.class, null, false, 3.0, _PersonAttributeType.SUBCHIEF_NAME));		install(personAttributeType("Next of kin name", "Name of patient's next of kin",				String.class, null, false, 4.0, _PersonAttributeType.NEXT_OF_KIN_NAME));		install(personAttributeType("Next of kin relationship", "Next of kin relationship to the patient",				String.class, null, false, 4.1, _PersonAttributeType.NEXT_OF_KIN_RELATIONSHIP));		install(personAttributeType("Next of kin contact", "Telephone contact of patient's next of kin",				String.class, null, false, 4.2, _PersonAttributeType.NEXT_OF_KIN_CONTACT));		install(personAttributeType("Next of kin address", "Address of patient's next of kin",				String.class, null, false, 4.3, _PersonAttributeType.NEXT_OF_KIN_ADDRESS));		install(personAttributeType("Alternate Phone Number", "Patient's alternate phone number",				String.class, null, false, 4.3, _PersonAttributeType.ALTERNATE_PHONE_CONTACT));		install(personAttributeType("Nearest Health Facility", "Patient's nearest Health Facility",				String.class, null, false, 4.3, _PersonAttributeType.NEAREST_HEALTH_CENTER));		// guardian properties		install(personAttributeType("Guardian First Name", "Guardian's first name",				String.class, null, false, 4.3, _PersonAttributeType.GUARDIAN_FIRST_NAME));		install(personAttributeType("Guardian Last Name", "Guardian's last name",				String.class, null, false, 4.3, _PersonAttributeType.GUARDIAN_LAST_NAME));		install(personAttributeType("Client Alias", "A client's local name",				String.class, null, true, 4.3, _PersonAttributeType.CLIENT_ALIAS));		install(personAttributeType("Unknown patient", "Unknown patient",				String.class, null, true, 4.3, _PersonAttributeType.UNKNOWN_PATIENT));		install(relationshipType("Peer-educator", "Peer", "One that follows up peers", _RelationshipType.PEER_EDUCATOR));//		install(relationshipType("Guardian", "Dependant", "One that guards, watches over, or protects", _RelationshipType.GUARDIAN_DEPENDANT));//		install(relationshipType("Spouse", "Spouse", "A spouse is a partner in a marriage, civil union, domestic partnership or common-law marriage a male spouse is a husband and a female spouse is a wife", _RelationshipType.SPOUSE));//		install(relationshipType("Partner", "Partner", "Someone I had sex with for fun without commitment to a relationship", _RelationshipType.PARTNER));//		install(relationshipType("Co-wife", "Co-wife", "Female member spouse in a polygamist household", _RelationshipType.CO_WIFE));		install(visitAttributeType("Source form", "The form whose submission created the visit",				FormDatatype.class, null, 0, 1, _VisitAttributeType.SOURCE_FORM));		install(visitType("Client", "Visit where the patient is not admitted to the hospital", _VisitType.OUTPATIENT));		uninstall(possible(PersonAttributeType.class, "73d34479-2f9e-4de3-a5e6-1f79a17459bb"), "Became patient identifier"); // National ID attribute type	}}