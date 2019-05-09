<%
    ui.decorateWith("kenyaemr", "standardPage", [ patient: currentPatient ])
    ui.includeCss("kenyaemr", "referenceapplication.css", 100)
    ui.includeCss("kenyaemrorderentry", "font-awesome.css")
    ui.includeCss("kenyaemrorderentry", "font-awesome.min.css")
    ui.includeCss("kenyaemrorderentry", "font-awesome.css.map")
    ui.includeCss("kenyaemrorderentry", "../fontawesome-webfont.svg")


    def addSocialStatusFormLink = ui.pageLink("htmlformentryui", "htmlform/enterHtmlFormWithSimpleUi", [patientId: currentPatient.patientId, definitionUiResource: "kenyaemr:simpleuiforms/kpSocialStatus.xml", returnUrl: ui.thisUrl()])
    def editContactInfoLink =  ui.pageLink("registrationapp", "editSection", [ patientId: patient.id,sectionId: "contactInfo", appId:"referenceapplication.registrationapp.registerPatient", returnUrl: ui.thisUrl() ])
    def editAliasLink = ui.pageLink("registrationapp", "editSection", [ patientId: patient.id,sectionId: "alias", appId:"referenceapplication.registrationapp.registerPatient", returnUrl: ui.thisUrl() ])

%>
<script type="text/javascript">


    jq(function(){

    });


</script>

<div class="clear"></div>

<div id="content" class="container">

    <div class="clear"></div>
    <div class="container">
        <div class="dashboard clear">
            <div class="info-container column">

                <div class="info-section">
                    <div class="info-header">
                        <i class="icon-diagnosis"></i>
                        <h3>Registration Info</h3>
                        <span class="right">[ <a href="${editAliasLink}">Edit Client Alias</a>|<a href="${editContactInfoLink}">Edit Contact Info</a> ]</span>
                    </div>
                    <div class="info-body">
                        ${ ui.includeFragment("kenyaemr", "patient/patientSummary", [ patient: currentPatient ]) }
                    </div>
                </div>


                <div class="info-section">
                    <div class="info-header">
                        <i class="icon-calendar"></i>
                        <h3>Client Support</h3>
                        <i class="icon-pencil edit-action right" title="Add" onclick="location.href = '${addSocialStatusFormLink}'"></i>
                    </div>
                    <div class="info-body">
                        No data
                    </div>
                </div>

                <div class="info-section">
                    <div class="info-header">
                        <i class="icon-calendar"></i>
                        <h3>Social Status</h3>
                        <i class="fa fa-plus-square right" style="color: steelblue" title="Record new social status" onclick="location.href = '${addSocialStatusFormLink}'"></i>
                    </div>
                    <div class="info-body">
                        ${ ui.includeFragment("kenyaemr", "program/kp/socialStatus", [ patient: currentPatient]) }
                    </div>
                </div>

                <div class="info-section">
                    <div class="info-header">
                        <i class="icon-calendar"></i>
                        <h3>Program History</h3>
                    </div>
                    <div class="info-body">
                        ${ ui.includeFragment("kenyaemr", "program/programHistories", [ patient: currentPatient, showClinicalData: true ]) }
                    </div>
                </div>

            </div>
            <div class="info-container column">

                <div class="info-section">
                    <div class="info-header">
                        <i class="icon-calendar"></i>
                        <h3>Recent Visits</h3>
                    </div>
                    <div class="info-body">
                        ${ ui.includeFragment("kenyaemr", "patient/recentVisits", [ patient: currentPatient, showClinicalData: true ]) }
                    </div>
                </div>

                <div class="info-section allergies">
                    <div class="info-header">
                        <i class="icon-stethoscope"></i>
                        <h3>Vitals</h3>
                    </div>
                    <div class="info-body">
                        ${ ui.includeFragment("kenyaemr", "patient/currentVitals", [ patient: currentPatient]) }
                    </div>
                </div>

                <div class="info-section allergies">
                    <div class="info-header">
                        <i class="icon-medical"></i>
                        <h3>Diagnoses</h3>
                    </div>
                    <div class="info-body">
                        None
                    </div>
                </div>

                <div class="info-section allergies">
                    <div class="info-header">
                        <i class="icon-medical"></i>
                        <h3>Medications</h3>
                    </div>
                    <div class="info-body">
                        No Medications
                    </div>
                </div>

            </div>

            ${ ui.includeFragment("kenyaemr", "patient/actionsPanel", [visit: visit]) }

        </div>
    </div>
</div>
