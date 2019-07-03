<%
	ui.decorateWith("kenyaui", "panel", [ heading: "Search for a Peer Educator" ])

	ui.includeJavascript("kenyaemr", "controllers/patient.js")

	def defaultWhich = config.defaultWhich ?: "all"

	def id = config.id ?: ui.generateId();
%>
<form id="${ id }" ng-controller="PeerSearchForm" ng-init="init()">
	<label  class="ke-field-label">Which peers</label>


	<label class="ke-field-label">ID or name (3 chars min)</label>
	<span class="ke-field-content">
		<input type="text" name="query" ng-model="query" ng-change="updateSearch()" style="width: 260px" />
	</span>
</form>