/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.calculation.library.kp;

import org.openmrs.PatientProgram;
import org.openmrs.Program;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.calculation.result.ListResult;
import org.openmrs.calculation.result.SimpleResult;
import org.openmrs.module.kenyacore.calculation.AbstractPatientCalculation;
import org.openmrs.module.kenyacore.calculation.CalculationUtils;
import org.openmrs.module.kenyacore.calculation.Calculations;
import org.openmrs.module.kenyaemr.metadata.KpMetadata;
import org.openmrs.module.metadatadeploy.MetadataUtils;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Calculate the date of enrollment into KP Program
 */
public class DateOfEnrollmentKpCalculation extends AbstractPatientCalculation {

	@Override
	public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> parameterValues, PatientCalculationContext context) {

		Program kpProgram = MetadataUtils.existing(Program.class, KpMetadata._Program.KEY_POPULATION);
		CalculationResultMap enrolledHere = Calculations.allEnrollments(kpProgram, cohort, context);

		CalculationResultMap result = new CalculationResultMap();
		for (Integer ptId : cohort) {
			Date enrollmentDate = null;
			ListResult listResult = (ListResult) enrolledHere.get(ptId);
			List<PatientProgram> patientProgram = CalculationUtils.extractResultValues(listResult);
			if(patientProgram.size() > 0){
				enrollmentDate = patientProgram.get(0).getDateEnrolled();

			}

			result.put(ptId, new SimpleResult(enrollmentDate, this));
		}

		return  result;
	}
}
