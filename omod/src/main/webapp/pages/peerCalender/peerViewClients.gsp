<%
	ui.decorateWith("kenyaemr", "standardPage", [ layout: "sidebar" ])
	ui.includeJavascript("kenyaemr", "controllers/patient.js")

	//def heading = config.heading ?: "Matching Peers"
%>

<div class="ke-panel-frame"  >
	<div class="ke-panel-heading">Matching Peers</div>
	<div class="ke-panel-content">
		<div class="ke-stack-item ke-navigable" ng-repeat="patient in clientResults" ng-click="onResultClick(patient)">
			${ ui.includeFragment("kenyaemr", "peerSearch/peerClientResult.full") }
		</div>
		<div ng-if="results.length == 0" style="text-align: center; font-style: italic">None</div>
	</div>
</div>