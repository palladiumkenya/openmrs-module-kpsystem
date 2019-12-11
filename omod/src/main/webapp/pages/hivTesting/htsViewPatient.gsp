<%
	ui.decorateWith("kenyaemr", "standardPage", [ patient: currentPatient ])
	ui.includeCss("kenyaemr", "referenceapplication.css", 100)
	ui.includeCss("kenyaemrorderentry", "font-awesome.css")
	ui.includeCss("kenyaemrorderentry", "font-awesome.min.css")
	ui.includeCss("kenyaemrorderentry", "font-awesome.css.map")
	ui.includeCss("kenyaemrorderentry", "../fontawesome-webfont.svg")

	def onEncounterClick = { encounter ->
		"""kenyaemr.openEncounterDialog('${ currentApp.id }', ${ encounter.id });"""
	}
%>
<style>
.dashboard .info-container {
	display: inline;
	float: left;
	width: 96.41667% !important;
	margin: 0 1.04167%;
}
.dashboard .action-container {
	display: inline;
	float: left;
	width: 95.91667% !important;
	margin: 0 1.04167%;
}
</style>

<div class="ke-page-content">
	<table cellpadding="0" cellspacing="0" border="0" width="100%">
		<tr>
			<td width="30%" valign="top">
				${ ui.includeFragment("kenyaemr", "patient/patientSummary", [ patient: currentPatient ]) }
				${ ui.includeFragment("kenyaemr", "patient/patientRelationships", [ patient: currentPatient ]) }
			</td>
			<td width="55%" valign="top" style="padding-left: 5px">

				${ ui.includeFragment("kenyaemr", "hivTesting/htsHistory", [ patient: currentPatient]) }

				<% if (activeVisit) { %>
				${ ui.includeFragment("kenyaemr", "visitAvailableForms", [ visit: activeVisit ]) }
				${ ui.includeFragment("kenyaemr", "visitCompletedForms", [ visit: activeVisit ]) }
				<% } %>
			</td>
			<td width="15%" valign="top" style="padding-left: 5px" class="dashboard clear">
				<div class="info-container action-container column ">
					${ ui.includeFragment("kenyaemr", "patient/actionsPanel") }
				</div>


			</td>
		</tr>
	</table>

</div>





