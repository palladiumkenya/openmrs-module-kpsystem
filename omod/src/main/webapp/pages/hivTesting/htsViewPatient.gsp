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

<div class="ke-page-content">
		<table cellpadding="0" cellspacing="0" border="0" width="100%">
			<tr>
				<td width="30%" valign="top">
					${ ui.includeFragment("kenyaemr", "patient/patientSummary", [ patient: currentPatient ]) }
					${ ui.includeFragment("kenyaemr", "patient/patientRelationships", [ patient: currentPatient ]) }
				</td>
				<td width="55%" valign="top" style="padding-left: 5px">
					${ ui.includeFragment("kenyaemr", "visitMenu", [ patient: currentPatient, visit: activeVisit ]) }
					${ ui.includeFragment("kenyaemr", "hivTesting/htsHistory", [ patient: currentPatient]) }

					<% if (activeVisit) { %>
					${ ui.includeFragment("kenyaemr", "visitAvailableForms", [ visit: activeVisit ]) }
					${ ui.includeFragment("kenyaemr", "visitCompletedForms", [ visit: activeVisit ]) }
					<% } %>
				</td>
				<td width="15%" valign="top" style="padding-left: 5px" class="action-section">
					${ ui.includeFragment("kenyaemr", "patient/actionsPanel") }

				</td>
			</tr>
		</table>

</div>
