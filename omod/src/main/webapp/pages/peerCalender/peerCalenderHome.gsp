<%
	ui.decorateWith("kenyaemr", "standardPage", [ layout: "sidebar" ])

	def menuItemsNew = [
			[ label: "Seen Clients", iconProvider: "kenyaui", icon: "buttons/patients.png", href: ui.pageLink("kenyaemr", "clinician/clinicianSearchSeen") ]
	]
%>

<div class="ke-page-sidebar">
	this is the side bar
</div>

<div class="ke-page-content">
	search results here
</div>

<script type="text/javascript">
    jQuery(function() {
        jQuery('input[name="query"]').focus();
    });
</script>