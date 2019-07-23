<%
	ui.decorateWith("kenyaemr", "standardPage", [ layout: "sidebar" ])

	def menuItems = [
			[ label: "Create new client", extra: "Client can't be found", iconProvider: "kenyaui", icon: "buttons/patient_add.png", href: ui.pageLink("registrationapp", "registerPatient", [appId:"referenceapplication.registrationapp.registerPatient"]) ]
	]
%>

<div class="ke-page-sidebar">
	${ ui.includeFragment("kenyaemr", "patient/patientSearchForm", [ defaultWhich: "all" ]) }

	${ ui.includeFragment("kenyaui", "widget/panelMenu", [ heading: "Tasks", items: menuItems ]) }
</div>

<div class="ke-page-content">
	${ ui.includeFragment("kenyaemr", "patient/patientSearchResults", [ pageProvider: "kenyaemr", page: "clinicianFacing/patientProfile" ]) }
</div>

<script type="text/javascript">
	jQuery(function() {
		jQuery('input[name="query"]').focus();
	});
</script>