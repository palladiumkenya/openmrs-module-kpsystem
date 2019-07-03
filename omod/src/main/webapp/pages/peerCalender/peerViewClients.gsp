<%
	ui.decorateWith("kenyaemr", "standardPage", [ patient: currentPatient ])
	//ui.decorateWith("kenyaemr", "standardPage", [ layout: "sidebar" ])
	ui.includeJavascript("kenyaemr", "controllers/patient.js")

	//def heading = config.heading ?: "Matching Peers"
%>

<div class="ke-panel-frame">
	<div class="ke-panel-heading">All clients Here</div>
<div class="ke-panel-content">

	${ ui.includeFragment("kenyaemr", "peerSearch/peerClientResult.full") }
</div>

</div>

