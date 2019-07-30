<%
	ui.decorateWith("kenyaui", "panel", [ heading: "", frameOnly: true ])
%>
<script type="text/javascript">
	function onVoidRelationship(relId) {
		kenyaui.openConfirmDialog({
			heading: 'Void Relationship',
			message: '${ ui.message("kenyaemr.confirmVoidRelationship") }',
			okCallback: function() { doRelationshipVoid(relId); }
		});
	}

	function doRelationshipVoid(relId) {
		ui.getFragmentActionAsJson('kenyaemr', 'emrUtils', 'voidRelationship', { relationshipId: relId, reason: 'Data entry error' }, function() {
			ui.reloadPage();
		});
	}
</script>



<div class="ke-panel-footer">

	<% if (!encounters) { %>
	<div>0 contact found!</div>
	<% } else { %>

	<% encounters.eachWithIndex { encounter, index, indexPlusOne = index + 1  -> %>
	<tr >
		<td>

			<button type="button"
					onclick="ui.navigate('${ ui.pageLink("kenyaemr", "editForm", [ patientId: patients,encounterId:encounters.encounter,
						formUuid: "185dec84-df6f-4fc7-a370-15aa8be531ec",appId:"kenyaemr.medicalEncounter", returnUrl: ui.thisUrl() ])}')">
				Edit Form
			</button>


		</td>
	</tr>
	<% } }%>



</div>