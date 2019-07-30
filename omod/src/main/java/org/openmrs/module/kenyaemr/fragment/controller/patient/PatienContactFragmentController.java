/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.fragment.controller.patient;

import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.Person;
import org.openmrs.Relationship;
import org.openmrs.api.context.Context;
import org.openmrs.module.kenyaemr.EmrConstants;
import org.openmrs.module.kenyaemr.metadata.CommonMetadata;
import org.openmrs.module.kenyaemr.util.EmrUtils;
import org.openmrs.module.kenyaui.KenyaUiUtils;
import org.openmrs.ui.framework.Link;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.openmrs.ui.framework.page.PageRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller for patient relationships panel
 */
public class PatienContactFragmentController {

    private Log log = LogFactory.getLog(this.getClass());
    public void controller(@FragmentParam(value="patient") Patient patient,
                           @SpringBean KenyaUiUtils kenyaUi,
                           PageRequest pageRequest,
                           UiUtils ui,
                           FragmentModel model)
    {

        Encounter encounters = EmrUtils.lastEncounter(patient,	Context.getEncounterService().getEncounterTypeByUuid(CommonMetadata._EncounterType.KP_CONTACT),
                Context.getFormService().getFormByUuid(CommonMetadata._Form.KP_CONTACT_FORM));
        if (encounters != null)
        {
            model.put("encounters", encounters);
        }
        System.out.println("this is the last encounter+++++++++++" + encounters);
        model.put("patient", patient.getPatientId());
    }
}
