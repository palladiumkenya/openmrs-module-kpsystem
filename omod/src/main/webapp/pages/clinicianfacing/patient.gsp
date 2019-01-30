<%
    ui.decorateWith("kenyaemr", "standardPage", [ patient: currentPatient ])
    ui.includeCss("kenyaemr", "referenceapplication.css", 100)
    ui.includeCss("kenyaemrorderentry", "font-awesome.css")
    ui.includeCss("kenyaemrorderentry", "font-awesome.min.css")
    ui.includeCss("kenyaemrorderentry", "font-awesome.css.map")
    ui.includeCss("kenyaemrorderentry", "fontawesome-webfont.svg")
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
                    </div>
                    <div class="info-body">
                        ${ ui.includeFragment("kenyaemr", "patient/patientSummary", [ patient: currentPatient ]) }
                    </div>
                </div>

                <div class="info-section">
                    <div class="info-header">
                        <i class="icon-calendar"></i>
                        <h3>Social Status</h3>
                        <i class="icon-pencil edit-action right" title="Edit" onclick="location.href = '/openmrs/coreapps/conditionlist/manageConditions.page?patientId=f83f4a1c-cc28-4a85-a8fb-bdf98130ec0e&amp;'"></i>
                    </div>
                    <div class="info-body">
                        None
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
                        None
                    </div>
                </div>

                <div class="info-section allergies">
                    <div class="info-header">
                        <i class="icon-medical"></i>
                        <h3>Vitals</h3>
                    </div>
                    <div class="info-body">
                        None
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

            <div class="action-container column">
                <div class="action-section">

                    <ul class="float-left">
                        <h3>General Actions</h3>
                        <li class="float-left" style="margin-top: 7px">
                            <a href="${ ui.pageLink("registrationapp", "registerPatient", [appId:"referenceapplication.registrationapp.registerPatient"]) }" class="float-left">
                                <i class="fa fa-search fa-2x"></i>
                                Register Client
                            </a>
                        </li>
                    </ul>


                    <ul>
                        <h3>Visit Actions</h3>
                        <li class="float-left" style="margin-top: 7px">
                            <a href="${ ui.pageLink("htmlformentryui", "htmlform/enterHtmlFormWithSimpleUi", [patientId: currentPatient.patientId, definitionUiResource: "kenyaemr:simpleuiforms/triage.xml", returnUrl: ui.thisUrl()]) }" class="float-left">
                                <i class="fa fa-plus-square fa-2x"></i>
                                Triage
                            </a>
                        </li>

                        <li class="float-left" style="margin-top: 7px">
                            <a href="${ ui.pageLink("htmlformentryui", "htmlform/enterHtmlFormWithStandardUi", [patientId: currentPatient.patientId, definitionUiResource: "kenyaemr:simpleuiforms/simpleVisitNote.xml", returnUrl: ui.thisUrl()]) }" class="float-left">
                                <i class="fa fa-plus-square fa-2x"></i>
                                Visit Note
                            </a>
                        </li>

                        <li class="float-left" style="margin-top: 7px">
                            <a href="${ ui.pageLink("kenyaemrorderentry", "drugOrders", [patient: currentPatient]) }" class="float-left">
                                <i class="fa fa-medkit fa-2x"></i>
                                Drug Orders
                            </a>
                        </li>

                        <li class="float-left" style="margin-top: 7px">
                            <a href="${ ui.pageLink("kenyaemrorderentry", "labOrders", [patient: currentPatient]) }" class="float-left">
                                <i class="fa fa-flask fa-2x"></i>
                                Lab Orders
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>
