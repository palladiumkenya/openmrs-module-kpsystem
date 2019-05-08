<%
    def baseLink = ui.pageLink("htmlformentryui", "htmlform/flowsheet", [patientId: currentPatient.patientId, headerForm: "kenyaemr:headertest.xml", returnUrl: ui.thisUrl()])

	def triageFlowsheets = "flowsheets=kenyaemr:triageForm.xml&flowsheets=kenyaemr:kpComplaints.xml&flowsheets=kenyaemr:kpChronicIllnesses.xml&\n" +
		"flowsheets=kenyaemr:kpKnownAllergies.xml&flowsheets=kenyaemr:kpDrugReactions.xml&flowsheets=kenyaemr:kpImmunizationAndVaccination.xml"

	def screeningFlowsheets = "flowsheets=kenyaemr:kpHepatitisBScreening.xml&flowsheets=kenyaemr:kpHepatitisCScreening.xml&\n" +
			"flowsheets=kenyaemr:kpOverdoseManagement.xml&flowsheets=kenyaemr:kpAlcoholScreening.xml&\n" +
			"flowsheets=kenyaemr:kpAbscesScreening.xml&flowsheets=kenyaemr:kpRiskReduction.xml&\n" +
			"flowsheets=kenyaemr:kpPep.xml&flowsheets=kenyaemr:kpPrep.xml&flowsheets=kenyaemr:kpSTITreatment.xml&\n" +
			"flowsheets=kenyaemr:kpViolenceScreening.xml"

	def obsgynFlowsheets = "flowsheets=kenyaemr:kpPregnancyAndFamilyPlanning.xml&flowsheets=kenyaemr:kpCervicalCancerScreening.xml&flowsheets=kenyaemr:kpOtherServices.xml"

	def examDiagnosisFlowsheets = "flowsheets=kenyaemr:kpSystemsExamination.xml&flowsheets=kenyaemr:kpDiagnosisAndTreatmentPlan.xml&flowsheets=kenyaemr:kpClinicalNotes.xml"

	def triageFlowsheeturl = baseLink + triageFlowsheets
	def screeningFlowsheeturl = baseLink + screeningFlowsheets
	def obsgynFlowsheeturl = baseLink + obsgynFlowsheets
	def examDiagnosisFlowsheeturl = baseLink + examDiagnosisFlowsheets
%>

<div class="action-container column">
	<div class="action-section">

		<ul class="float-left">
			<h3>General Actions</h3>
			<li class="float-left" style="margin-top: 7px">
				<a href="${ ui.pageLink("registrationapp", "registerPatient", [appId:"referenceapplication.registrationapp.registerPatient"]) }" class="float-left">
					<i class="fa fa-search fa-2x"></i>
					Register Client
				</a>
			</li>
		</ul>
		<ul>
			<h3>Flowsheets</h3>
			<li class="float-left" style="margin-top: 7px">
				<a href="${ triageFlowsheeturl }" class="float-left">
					<i class="fa fa-plus-square fa-2x"></i>
					Triage and History
				</a>
			</li>
			<li class="float-left" style="margin-top: 7px">
				<a href="${ examDiagnosisFlowsheeturl }" class="float-left">
					<i class="fa fa-plus-square fa-2x"></i>
					Examinations and Diagnosis
				</a>
			</li>
			<li class="float-left" style="margin-top: 7px">
				<a href="${ screeningFlowsheeturl }" class="float-left">
					<i class="fa fa-plus-square fa-2x"></i>
                    KP Screening
				</a>
			</li>
			<li class="float-left" style="margin-top: 7px">
				<a href="${ obsgynFlowsheeturl }" class="float-left">
					<i class="fa fa-plus-square fa-2x"></i>
					Obs-gynae and Other Services
				</a>
			</li>
		</ul>
		<ul>
			<h3>Visit Actions</h3>
			<li class="float-left" style="margin-top: 7px">
				<a href="${ ui.pageLink("htmlformentryui", "htmlform/enterHtmlFormWithSimpleUi", [patientId: currentPatient.patientId, definitionUiResource: "kenyaemr:simpleuiforms/triage.xml", returnUrl: ui.thisUrl()]) }" class="float-left">
					<i class="fa fa-plus-square fa-2x"></i>
					Triage
				</a>
			</li>
			<li class="float-left" style="margin-top: 7px">
				<a href="${ ui.pageLink("htmlformentryui", "htmlform/enterHtmlFormWithStandardUi", [patientId: currentPatient.patientId, definitionUiResource: "kenyaemr:simpleuiforms/simpleVisitNote.xml", returnUrl: ui.thisUrl()]) }" class="float-left">
					<i class="fa fa-plus-square fa-2x"></i>
					Visit Note
				</a>
			</li>
			<li class="float-left" style="margin-top: 7px">
				<a href="${ ui.pageLink("kenyaemrorderentry", "drugOrders", [patient: currentPatient]) }" class="float-left">
					<i class="fa fa-medkit fa-2x"></i>
					Drug Orders
				</a>
			</li>
			<li class="float-left" style="margin-top: 7px">
				<a href="${ ui.pageLink("kenyaemrorderentry", "labOrders", [patient: currentPatient]) }" class="float-left">
					<i class="fa fa-flask fa-2x"></i>
					Lab Orders
				</a>
			</li>
		</ul>
			<ul>
				<h3>Available Forms</h3>
				<li class="float-left" style="margin-top: 7px">
					<%
						def onFormClick = { form ->
							def visitId = currentVisit ? currentVisit.id : activeVisit.id
							def opts = [ appId: currentApp.id, visitId: visitId, formUuid: form.formUuid, returnUrl: ui.thisUrl() ]
							"""ui.navigate('${ ui.pageLink('kenyaemr', 'enterForm', opts) }');"""
						}
					%>
					${ ui.includeFragment("kenyaui", "widget/formStack", [ forms: availableForms, onFormClick: onFormClick ]) }

					</a>
				</li>
			</ul>
			<ul>
				<h3>Completed Forms</h3>
				<li class="float-left" style="margin-top: 7px">

					<%

						def onEncounterClick = { encounter ->
							"""kenyaemr.openEncounterDialog('${ currentApp.id }', ${ encounter.id });"""
						}
					%>
					${ ui.includeFragment("kenyaemr", "widget/encounterLightStack", [ encounters: encounters, onEncounterClick: onEncounterClick ]) }
					</a>
				</li>

			</ul>

	</div>
</div>