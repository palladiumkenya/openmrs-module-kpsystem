<%
	//ui.decorateWith("kenyaemr", "standardPage", [ patient: currentPatient ])
	ui.decorateWith("kenyaemr", "standardPage", [ layout: "sidebar" ])
	//ui.includeJavascript("kenyaemr", "controllers/patient.js")

%>

<div class="ke-page-sidebar">

</div>
<div class="ke-page-content">
<div class="ke-panel-frame">
	<div class="ke-panel-heading">Peers</div>
<div class="ke-panel-content">
	<div>
		<tbody>
		<% if (!peers) { %>
		<div>0 Peers found!</div>
		<% } else { %>
		<table>
			<tr>
				<th>Name</th>
				<th>Gender</th>
				<th>Age</th>
				<th></th>
			</tr>
		<% peers.each { peer -> %>
		<tr >
			<td>${ peer.name }</td>
			<td>${ peer.gender }</td>
			<td>${ peer.age }</td>
			<td>
				<button type="button"
						onclick="ui.navigate('${ ui.pageLink("kenyaemr", "enterForm", [ patientId: peer.id,
						formUuid:"7492cffe-5874-4144-a1e6-c9e455472a35",appId:"kenyaemr.medicalEncounter", returnUrl: ui.thisUrl() ])}')">
					 Enter Form
				</button>
			</td>
		</tr>
		<% }} %>
		</table>
		</tbody>

	</div>
</div>

</div>
</div>

