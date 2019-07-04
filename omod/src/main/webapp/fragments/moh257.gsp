<%
	def onFormClick = { form ->
		def opts = [ appId: currentApp.id, patientId: currentPatient.id, formUuid: form.formUuid, returnUrl: ui.thisUrl() ]
		"""ui.navigate('${ ui.pageLink('kenyaemr', 'enterForm', opts) }');"""
	}

	def onEncounterClick = { encounter ->
		"""kenyaemr.openEncounterDialog('${ currentApp.id }', ${ encounter.id });"""
	}
%>

<div class="ke-panel-frame">
	<div class="ke-panel-heading">Initial and Followup Visits</div>
	<div class="ke-panel-content" style="background-color: #F3F9FF">
		${ ui.includeFragment("kenyaemr", "widget/encounterStack", [ encounters: page2Encounters, onEncounterClick: onEncounterClick ]) }
		<br />
		<% if (inKpProgram) { %>
			<div align="center">
				${ ui.includeFragment("kenyaui", "widget/button", [
						label: "Add Visit Summary",
						extra: "From column",
						iconProvider: "kenyaui",
						icon: "buttons/visit_retrospective.png",
						href: ui.pageLink("kenyaemr", "enterForm", [ appId: currentApp.id, patientId: currentPatient, formUuid: page2Form.uuid, returnUrl: ui.thisUrl() ])
				]) }
			</div>
		<%}%>
		<% if (!(inKpProgram)) { %>
			<div class="ke-warning" align="center">
				You need to enroll the patient into KP program before completing visit summary
			</div>
		<%}%>
	</div>
</div>

