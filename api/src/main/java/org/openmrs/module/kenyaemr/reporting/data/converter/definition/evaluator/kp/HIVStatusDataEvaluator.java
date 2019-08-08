/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.reporting.data.converter.definition.evaluator.kp;

import org.openmrs.annotation.Handler;
import org.openmrs.module.kenyaemr.reporting.data.converter.definition.kp.HIVStatusDataDefinition;
import org.openmrs.module.kenyaemr.reporting.data.converter.definition.kp.HIVTestFrequencyDataDefinition;
import org.openmrs.module.reporting.data.person.EvaluatedPersonData;
import org.openmrs.module.reporting.data.person.definition.PersonDataDefinition;
import org.openmrs.module.reporting.data.person.evaluator.PersonDataEvaluator;
import org.openmrs.module.reporting.evaluation.EvaluationContext;
import org.openmrs.module.reporting.evaluation.EvaluationException;
import org.openmrs.module.reporting.evaluation.querybuilder.SqlQueryBuilder;
import org.openmrs.module.reporting.evaluation.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Evaluates a PersonDataDefinition
 */
@Handler(supports= HIVStatusDataDefinition.class, order=50)
public class HIVStatusDataEvaluator implements PersonDataEvaluator {

    @Autowired
    private EvaluationService evaluationService;

    public EvaluatedPersonData evaluate(PersonDataDefinition definition, EvaluationContext context) throws EvaluationException {
        EvaluatedPersonData c = new EvaluatedPersonData(definition, context);

        String qry = "select r.client_id,case coalesce(max(t.final_test_result),max(v.test_confirmatory_results),max(v.self_test_results),max(v.hiv_self_rep_status)) when \"Negative\"  then (case when timestampdiff(Month,mid(max(concat(t.final_test_result,t.visit_date)),11),date(:endDate))between 1 and 3 THEN \"PN\"\n" +
                "    when timestampdiff(Month,mid(max(concat(t.final_test_result,t.visit_date)),11),date(:endDate))<1 then \"N\" when timestampdiff(Month,mid(max(concat(t.final_test_result,t.visit_date)),11),date(:endDate))>3 then \"U\" end) when \"Positive\" then\n" +
                "    (case when (timestampdiff(Month,(coalesce((mid(max(concat(t.final_test_result,t.visit_date)),11)),(mid(max(concat(v.test_confirmatory_results,v.visit_date)),11)),(mid(max(concat(v.self_test_results,v.visit_date)),11)),(mid(max(concat(v.hiv_self_rep_status,v.visit_date)),11)))),date(:endDate)))<1 then \"P\"\n" +
                "        when (timestampdiff(Month,(coalesce((mid(max(concat(t.final_test_result,t.visit_date)),11)),(mid(max(concat(v.test_confirmatory_results,v.visit_date)),11)),(mid(max(concat(v.self_test_results,v.visit_date)),11)),(mid(max(concat(v.hiv_self_rep_status,v.visit_date)),11)))),date(:endDate)))>1 then \"Known Positive\" end )\n" +
                "    when \"Known Positive\" then \"Known Positive\" else \"\" end as hiv_status\n" +
                "from kp_etl.etl_client_registration r left join kp_etl.etl_clinical_visit v on r.client_id = v.client_id\n" +
                "left join kp_etl.etl_hts_test t on r.client_id = t.client_id\n" +
                "where v.client_id is not null or t.client_id is not null\n" +
                "group by r.client_id;";

        SqlQueryBuilder queryBuilder = new SqlQueryBuilder();
        queryBuilder.append(qry);
        Map<Integer, Object> data = evaluationService.evaluateToMap(queryBuilder, Integer.class, Object.class, context);
        c.setData(data);
        return c;
    }
}