

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

						config.require("visit")

						def onFormClick = { form ->
							def visitId = currentVisit ? currentVisit.id : activeVisit.id
							def opts = [ appId: currentApp.id, visitId: visitId, formUuid: form.formUuid, returnUrl: ui.thisUrl() ]
							"""ui.navigate('${ ui.pageLink('kenyaemr', 'enterForm', opts) }');"""
						}
					%>
					${ ui.includeFragment("kenyaui", "widget/formLightStack", [ forms: availableForms, onFormClick: onFormClick ]) }

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