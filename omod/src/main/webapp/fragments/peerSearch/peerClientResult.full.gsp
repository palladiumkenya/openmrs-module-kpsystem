
<%
	ui.decorateWith("kenyaemr", "standardPage", [ layout: "sidebar" ])
	ui.includeJavascript("kenyaemr", "controllers/patient.js")

	//def heading = config.heading ?: "Matching Peers"
%>
<div>



<table style="width: 100%" ng-repeat="patient in clientResults">
	<tr>
		<td style="width: 32px; vertical-align: top; padding-right: 5px">
			<img width="32" height="32" ng-src="${ ui.resourceLink("kenyaui", "images/buttons/patient_") }{{ patient.personA.gender }}.png" />
		</td>
		<td style="text-align: left; vertical-align: top; width: 33%">
			<strong>{{ patient.personA.display }}</strong><br/>
			{{ patient.personA.age }} <small>(DOB {{ patient.personA.birthdate }})</small>
		</td>

	</tr>
</table>
</div>