/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.reporting.library.ETLReports.moh731B;

import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.SqlCohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by dev on 1/14/17.
 */

/**
 * Library of cohort definitions used specifically in the MOH731 report based on ETL tables. It has incorporated green card components
 */
@Component

//activeFsw

public class ETLMoh731BCohortLibrary {

    public CohortDefinition activeFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select  en.client_id  from kp_etl.etl_client_enrollment en  inner join encounter e on e.patient_id = en.client_id\n" +
                "inner join kp_etl.kp_etl.etl_client_social_status s on en.client_id = s.client_id\n" +
                "where s.key_population_type = \"Female sex worker\"  and en.voided = 0\n" +
                "group by en.client_id\n" +
                "having timestampdiff(MONTH,Max(date(e.encounter_datetime)),date(:endDate))<=3;";
        cd.setName("activeFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("activeFsw");

        return cd;
    }
    //activeMsm
    public CohortDefinition activeMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select  en.client_id  from kp_etl.etl_client_enrollment en  inner join encounter e on e.patient_id = en.client_id\n" +
                "                                                            inner join kp_etl.kp_etl.etl_client_social_status s on en.client_id = s.client_id\n" +
                "where s.key_population_type = \"Male who have sex with Men\"  and en.voided = 0\n" +
                "group by en.client_id\n" +
                "having timestampdiff(MONTH,Max(date(e.encounter_datetime)),date(:endDate))<=3;";
        cd.setName("activeMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("activeMsm");

        return cd;
    }

    public CohortDefinition activeMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select  en.client_id  from kp_etl.etl_client_enrollment en  inner join encounter e on e.patient_id = en.client_id\n" +
                "                                                            inner join kp_etl.kp_etl.etl_client_social_status s on en.client_id = s.client_id\n" +
                "where s.key_population_type = \"Male sex worker\"  and en.voided = 0\n" +
                "group by en.client_id\n" +
                "having timestampdiff(MONTH,Max(date(e.encounter_datetime)),date(:endDate))<=3;";
        cd.setName("activeMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("activeMsw");

        return cd;
    }

    public CohortDefinition activePwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select  en.client_id  from kp_etl.etl_client_enrollment en  inner join encounter e on e.patient_id = en.client_id\n" +
                "                                                            inner join kp_etl.kp_etl.etl_client_social_status s on en.client_id = s.client_id\n" +
                "where s.key_population_type = \"People who inject drugs\"  and en.voided = 0\n" +
                "group by en.client_id\n" +
                "having timestampdiff(MONTH,Max(date(e.encounter_datetime)),date(:endDate))<=3;";
        cd.setName("activePwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("activePwid");

        return cd;
    }

    public CohortDefinition activePwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select  en.client_id  from kp_etl.etl_client_enrollment en  inner join encounter e on e.patient_id = en.client_id\n" +
                "                                                            inner join kp_etl.kp_etl.etl_client_social_status s on en.client_id = s.client_id\n" +
                "where s.key_population_type = \"People who use drugs\"  and en.voided = 0\n" +
                "group by en.client_id\n" +
                "having timestampdiff(MONTH,Max(date(e.encounter_datetime)),date(:endDate))<=3;                      inner join kp_etl.kp_etl.etl_client_social_status s on en.client_id = s.client_id\n" +
                "where s.key_population_type = \"People who use drugs\"  and en.voided = 0\n" +
                "group by en.client_id\n" +
                "having timestampdiff(MONTH,Max(date(e.encounter_datetime)),date(:endDate))<=3;";
        cd.setName("activePwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("activePwud");

        return cd;
    }

    public CohortDefinition activeTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("activeTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("activeTransgender");

        return cd;
    }

    public CohortDefinition hivTestedFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where date(h.visit_date) between date(:startDate) and date(:endDate) and s.key_population_type = \"Female sex worker\"\n" +
                "group by h.client_id;";
        cd.setName("hivTestedFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("hivTestedFsw");

        return cd;
    }

    public CohortDefinition hivTestedMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where date(h.visit_date) between date(:startDate) and date(:endDate) and s.key_population_type = \"Male who have sex with Men\"\n" +
                "group by h.client_id;";
        cd.setName("hivTestedMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("hivTestedMsm");

        return cd;
    }

    public CohortDefinition hivTestedMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where date(h.visit_date) between date(:startDate) and date(:endDate) and s.key_population_type = \"Male sex worker\"\n" +
                "group by h.client_id;";
        cd.setName("hivTestedMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("hivTestedMsw");

        return cd;
    }

    public CohortDefinition hivTestedPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where date(h.visit_date) between date(:startDate) and date(:endDate) and s.key_population_type = \"People who inject drugs\"\n" +
                "group by h.client_id;";
        cd.setName("hivTestedPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("hivTestedPwid");

        return cd;
    }

    public CohortDefinition hivTestedPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where date(h.visit_date) between date(:startDate) and date(:endDate) and s.key_population_type = \"People who use drugs\"\n" +
                "group by h.client_id;";
        cd.setName("hivTestedPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("hivTestedPwud");

        return cd;
    }

    public CohortDefinition hivTestedTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("hivTestedTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("hivTestedTransgender");

        return cd;
    }

    public CohortDefinition testedAtFacilityFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"Female sex worker\"\n" +
                " and date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "and h.hts_entry_point in (\"In Patient Department(IPD)\",\n" +
                "                          \"Out Patient Department(OPD)Peadiatric Clinic\",\n" +
                "                          \"Nutrition Clinic\",\n" +
                "                          \"PMTCT\",\n" +
                "                          \"TB\",\n" +
                "                          \"CCC\",\n" +
                "                          \"VCT\")\n" +
                "group by h.client_id;";
        cd.setName("testedAtFacilityFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtFacilityFsw");

        return cd;
    }

    public CohortDefinition testedAtFacilityMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"Male who have sex with Men\"\n" +
                "  and date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "  and h.hts_entry_point in (\"In Patient Department(IPD)\",\n" +
                "                            \"Out Patient Department(OPD)Peadiatric Clinic\",\n" +
                "                            \"Nutrition Clinic\",\n" +
                "                            \"PMTCT\",\n" +
                "                            \"TB\",\n" +
                "                            \"CCC\",\n" +
                "                            \"VCT\")\n" +
                "group by h.client_id;";
        cd.setName("testedAtFacilityMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtFacilityMsm");

        return cd;
    }

    public CohortDefinition testedAtFacilityMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"Male sex worker\"\n" +
                "  and date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "  and h.hts_entry_point in (\"In Patient Department(IPD)\",\n" +
                "                            \"Out Patient Department(OPD)Peadiatric Clinic\",\n" +
                "                            \"Nutrition Clinic\",\n" +
                "                            \"PMTCT\",\n" +
                "                            \"TB\",\n" +
                "                            \"CCC\",\n" +
                "                            \"VCT\")\n" +
                "group by h.client_id;";
        cd.setName("testedAtFacilityMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtFacilityMsw");

        return cd;
    }

    public CohortDefinition testedAtFacilityPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"People who inject drugs\"\n" +
                "  and date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "  and h.hts_entry_point in (\"In Patient Department(IPD)\",\n" +
                "                            \"Out Patient Department(OPD)Peadiatric Clinic\",\n" +
                "                            \"Nutrition Clinic\",\n" +
                "                            \"PMTCT\",\n" +
                "                            \"TB\",\n" +
                "                            \"CCC\",\n" +
                "                            \"VCT\")\n" +
                "group by h.client_id;";
        cd.setName("testedAtFacilityPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtFacilityPwid");

        return cd;
    }    public CohortDefinition testedAtFacilityPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"People who use drugs\"\n" +
                "  and date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "  and h.hts_entry_point in (\"In Patient Department(IPD)\",\n" +
                "                            \"Out Patient Department(OPD)Peadiatric Clinic\",\n" +
                "                            \"Nutrition Clinic\",\n" +
                "                            \"PMTCT\",\n" +
                "                            \"TB\",\n" +
                "                            \"CCC\",\n" +
                "                            \"VCT\")\n" +
                "group by h.client_id;";
        cd.setName("diagnosedSTI");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Diagnosed for STI");

        return cd;
    }

    public CohortDefinition testedAtFacilityTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("testedAtFacilityTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtFacilityTransgender");

        return cd;
    }
//testedAtCommunityFsw
    public CohortDefinition testedAtCommunityFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"Female sex worker\"\n" +
                "  and date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "  and h.hts_entry_point in (\"Home Based Testing\",\n" +
                "                            \"Mobile Outreach\",\n" +
                "                            \"Other\")\n" +
                "group by h.client_id;";
        cd.setName("testedAtCommunityFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityFsw");

        return cd;
    }
//testedAtCommunityMsm
    public CohortDefinition testedAtCommunityMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"Male who have sex with Men\"\n" +
                "  and date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "  and h.hts_entry_point in (\"Home Based Testing\",\n" +
                "                            \"Mobile Outreach\",\n" +
                "                            \"Other\")\n" +
                "group by h.client_id;";
        cd.setName("testedAtCommunityMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityMsm");

        return cd;
    }
//testedAtCommunityMsw
    public CohortDefinition testedAtCommunityMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"Male sex worker\"\n" +
                "  and date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "  and h.hts_entry_point in (\"Home Based Testing\",\n" +
                "                            \"Mobile Outreach\",\n" +
                "                            \"Other\")\n" +
                "group by h.client_id;";
        cd.setName("testedAtCommunityMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityMsw");

        return cd;
    }
//testedAtCommunityPwid
    public CohortDefinition testedAtCommunityPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery = "select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"People who inject drugs\"\n" +
                "  and date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "  and h.hts_entry_point in (\"Home Based Testing\",\n" +
                "                            \"Mobile Outreach\",\n" +
                "                            \"Other\")\n" +
                "group by h.client_id;";
        cd.setName("testedAtCommunityPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityPwid");

        return cd;
    }
//testedAtCommunityPwud
    public CohortDefinition testedAtCommunityPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"People who use drugs\"\n" +
                "  and date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "  and h.hts_entry_point in (\"Home Based Testing\",\n" +
                "                            \"Mobile Outreach\",\n" +
                "                            \"Other\")\n" +
                "group by h.client_id;";
        cd.setName("testedAtCommunityPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityPwud");

        return cd;
    }
//testedAtCommunityTransgender
    public CohortDefinition testedAtCommunityTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"transgender\"\n" +
                "  and date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "  and h.hts_entry_point in (\"Home Based Testing\",\n" +
                "                            \"Mobile Outreach\",\n" +
                "                            \"Other\")\n" +
                "group by h.client_id;";
        cd.setName("testedAtCommunityTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityTransgender");

        return cd;
    }
//testedNewFsw
    public CohortDefinition testedNewFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_client_enrollment e on t.client_id = e.client_id\n" +
                "inner join kp_etl.etl_client_social_status ss on t.client_id = e.client_id\n" +
                "where ss.key_population_type = \"Female sex worker\"\n" +
                "group by t.client_id\n" +
                "having min(date(t.visit_date)) between  date(:startDate) and date(:endDate);";
        cd.setName("testedNewFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedNewFsw");

        return cd;
    }
//testedNewMsm
    public CohortDefinition testedNewMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_client_enrollment e on t.client_id = e.client_id\n" +
                "                                       inner join kp_etl.etl_client_social_status ss on t.client_id = e.client_id\n" +
                "where ss.key_population_type = \"Male who have sex with Men\"\n" +
                "group by t.client_id\n" +
                "having min(date(t.visit_date)) between  date(:startDate) and date(:endDate);";
        cd.setName("testedNewMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedNewMsm");

        return cd;
    }
//testedNewMsw
    public CohortDefinition testedNewMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_client_enrollment e on t.client_id = e.client_id\n" +
                "                                       inner join kp_etl.etl_client_social_status ss on t.client_id = e.client_id\n" +
                "where ss.key_population_type = \"Male sex worker\"\n" +
                "group by t.client_id\n" +
                "having min(date(t.visit_date)) between  date(:startDate) and date(:endDate);";
        cd.setName("testedNewMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedNewMsw");

        return cd;
    }
//testedNewPwid
    public CohortDefinition testedNewPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_client_enrollment e on t.client_id = e.client_id\n" +
                "                                       inner join kp_etl.etl_client_social_status ss on t.client_id = e.client_id\n" +
                "where ss.key_population_type = \"People who inject drugs\"\n" +
                "group by t.client_id\n" +
                "having min(date(t.visit_date)) between  date(:startDate) and date(:endDate);";
        cd.setName("testedNewPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedNewPwid");

        return cd;
    }
//testedNewPwud
    public CohortDefinition testedNewPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_client_enrollment e on t.client_id = e.client_id\n" +
                "                                       inner join kp_etl.etl_client_social_status ss on t.client_id = e.client_id\n" +
                "where ss.key_population_type = \"People who use drugs\"\n" +
                "group by t.client_id\n" +
                "having min(date(t.visit_date)) between  date(:startDate) and date(:endDate);";
        cd.setName("testedNewPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedNewPwud");

        return cd;
    }
//testedAtNewTransgender
    public CohortDefinition testedAtNewTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("testedAtNewTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtNewTransgender");

        return cd;
    }
//testedRepeatFsw
    public CohortDefinition testedRepeatFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_client_enrollment e on t.client_id = e.client_id\n" +
                "                                              inner join kp_etl.etl_client_social_status ss on t.client_id = e.client_id\n" +
                "where ss.key_population_type = \"Female sex worker\"\n" +
                "group by t.client_id having count(distinct(t.visit_id)) >1;";
        cd.setName("testedRepeatFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedRepeatFsw");

        return cd;
    }
//testedRepeatMsm
    public CohortDefinition testedRepeatMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_client_enrollment e on t.client_id = e.client_id\n" +
                "                                              inner join kp_etl.etl_client_social_status ss on t.client_id = e.client_id\n" +
                "where ss.key_population_type = \"Male who have sex with Men\"\n" +
                "group by t.client_id having count(distinct(t.visit_id)) >1;";
        cd.setName("testedRepeatMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedRepeatMsm");

        return cd;
    }

    //testedRepeatMsw
    public CohortDefinition testedRepeatMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_client_enrollment e on t.client_id = e.client_id\n" +
                "                                              inner join kp_etl.etl_client_social_status ss on t.client_id = e.client_id\n" +
                "where ss.key_population_type = \"Male sex worker\"\n" +
                "group by t.client_id having count(distinct(t.visit_id)) >1;";
        cd.setName("testedRepeatMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedRepeatMsw");

        return cd;
    }
//testedRepeatPwid
    public CohortDefinition testedRepeatPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_client_enrollment e on t.client_id = e.client_id\n" +
                "                                              inner join kp_etl.etl_client_social_status ss on t.client_id = e.client_id\n" +
                "where ss.key_population_type = \"People who inject drugs\"\n" +
                "group by t.client_id having count(distinct(t.visit_id)) >1;";
        cd.setName("testedRepeatPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedRepeatPwid");

        return cd;
    }
//testedRepeatPwud
    public CohortDefinition testedRepeatPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_client_enrollment e on t.client_id = e.client_id\n" +
                "                                              inner join kp_etl.etl_client_social_status ss on t.client_id = e.client_id\n" +
                "where ss.key_population_type = \"People who inject drugs\"\n" +
                "group by t.client_id having count(distinct(t.visit_id)) >1;";
        cd.setName("testedRepeatPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedRepeatPwud");

        return cd;
    }

    public CohortDefinition testedRepeatTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("testedRepeatTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedRepeatTransgender");

        return cd;
    }

//knownPositiveFsw
    public CohortDefinition knownPositiveFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "inner join encounter en on h.client_id = en.patient_id\n" +
                "where s.key_population_type = \"Female sex worker\" and h.final_test_result =\"Positive\"\n" +
                "group by h.client_id\n" +
                "having timestampdiff(MONTH,Max(date(en.encounter_datetime)),date(:endDate))<=3;";
        cd.setName("knownPositiveFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("knownPositiveFsw");

        return cd;
    }
//knownPositiveMsm
    public CohortDefinition knownPositiveMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                                                                        inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "                                                                                        inner join encounter en on h.client_id = en.patient_id\n" +
                "where s.key_population_type = \"Male who have sex with Men\" and h.final_test_result =\"Positive\"\n" +
                "group by h.client_id\n" +
                "having timestampdiff(MONTH,Max(date(en.encounter_datetime)),date(:endDate))<=3;\n";
        cd.setName("knownPositiveMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("knownPositiveMsm");

        return cd;
    }


//knownPositiveMsw
    public CohortDefinition knownPositiveMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                                                                        inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "                                                                                        inner join encounter en on h.client_id = en.patient_id\n" +
                "where s.key_population_type = \"Male sex worker\" and h.final_test_result =\"Positive\"\n" +
                "group by h.client_id\n" +
                "having timestampdiff(MONTH,Max(date(en.encounter_datetime)),date(:endDate))<=3;";
        cd.setName("knownPositiveMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("knownPositiveMsw");

        return cd;
    }
//knownPositivePwid
    public CohortDefinition knownPositivePwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                                                                        inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "                                                                                        inner join encounter en on h.client_id = en.patient_id\n" +
                "where s.key_population_type = \"People who inject drugs\" and h.final_test_result =\"Positive\"\n" +
                "group by h.client_id\n" +
                "having timestampdiff(MONTH,Max(date(en.encounter_datetime)),date(:endDate))<=3;";
        cd.setName("knownPositivePwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("knownPositivePwid ");

        return cd;
    }
//knownPositivePwud
    public CohortDefinition knownPositivePwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                                                                        inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "                                                                                        inner join encounter en on h.client_id = en.patient_id\n" +
                "where s.key_population_type = \"People who use drugs\" and h.final_test_result =\"Positive\"\n" +
                "group by h.client_id\n" +
                "having timestampdiff(MONTH,Max(date(en.encounter_datetime)),date(:endDate))<=3;";
        cd.setName("knownPositivePwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("knownPositivePwud");

        return cd;
    }

    public CohortDefinition knownPositiveTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("knownPositiveTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("knownPositiveTransgender");

        return cd;
    }
//receivedPositiveResultsFsw
    public CohortDefinition receivedPositiveResultsFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "                                              where s.key_population_type = \"Female sex worker\" and h.final_test_result =\"Positive\" and h.patient_given_result = \"Yes\"\n" +
                "and  date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "group by h.client_id;";
        cd.setName("receivedPositiveResultsFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivedPositiveResultsFsw");

        return cd;
    }
//receivedPositiveResultsMsm
    public CohortDefinition receivedPositiveResultsMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"Male who have sex with Men\" and h.final_test_result =\"Positive\" and h.patient_given_result = \"Yes\"\n" +
                "  and  date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "group by h.client_id;";
        cd.setName("receivedPositiveResultsMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivedPositiveResultsMsm");

        return cd;
    }
//receivedPositiveResultsMsw
    public CohortDefinition receivedPositiveResultsMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"Male sex worker\" and h.final_test_result =\"Positive\" and h.patient_given_result = \"Yes\"\n" +
                "  and  date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "group by h.client_id;";
        cd.setName("receivedPositiveResultsMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivedPositiveResultsMsw");

        return cd;
    }
//receivedPositiveResultsPwid
    public CohortDefinition receivedPositiveResultsPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"People who inject drugs\" and h.final_test_result =\"Positive\" and h.patient_given_result = \"Yes\"\n" +
                "  and  date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "group by h.client_id;";
        cd.setName("receivedPositiveResultsPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivedPositiveResultsPwid");

        return cd;
    }
//receivedPositiveResultsPwud
    public CohortDefinition receivedPositiveResultsPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select h.client_id from kp_etl.kp_etl.etl_hts_test h inner join kp_etl.etl_client_enrollment e on h.client_id = e.client_id\n" +
                "                                              inner join kp_etl.kp_etl.etl_client_social_status s on h.client_id = s.client_id\n" +
                "where s.key_population_type = \"People who use drugs\" and h.final_test_result =\"Positive\" and h.patient_given_result = \"Yes\"\n" +
                "  and  date(h.visit_date) between date(:startDate) and date(:endDate)\n" +
                "group by h.client_id;";
        cd.setName("receivedPositiveResultsPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivedPositiveResultsPwud");

        return cd;
    }
//receivedPositiveResultsTransgender
    public CohortDefinition receivedPositiveResultsTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivedPositiveResultsTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivedPositiveResultsTransgender");

        return cd;
    }
//linkedFsw
    public CohortDefinition linkedFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="\n" +
                "select k.client_id from ((select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_hts_referral_and_linkage r on t.client_id=r.client_id where  timestampdiff(MONTH,date(t.visit_date),date(:enddate))<=3 and t.final_test_result=\"Positive\")\n" +
                "union all (select hs.client_id from kp_etl.etl_hiv_status hs\n" +
                "                       where hs.current_in_care =\"Yes\" and timestampdiff(MONTH,date(hs.test_date),date(:enddate))<=3 ))k  inner join kp_etl.etl_client_social_status ss on ss.client_id = k.client_id\n" +
                "and ss.key_population_type = \"Female sex worker\"\n" +
                "group by k.client_id;";
        cd.setName("linkedFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("linkedFsw");

        return cd;
    }


//linkedMsm
    public CohortDefinition linkedMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select k.client_id from ((select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_hts_referral_and_linkage r on t.client_id=r.client_id where  timestampdiff(MONTH,date(t.visit_date),date(:enddate))<=3 and t.final_test_result=\"Positive\")\n" +
                "                         union all (select hs.client_id from kp_etl.etl_hiv_status hs\n" +
                "                                    where hs.current_in_care =\"Yes\" and timestampdiff(MONTH,date(hs.test_date),date(:enddate))<=3 ))k  inner join kp_etl.etl_client_social_status ss on ss.client_id = k.client_id\n" +
                "                                                                                                                                                                                   and ss.key_population_type = \"Male who have sex with Men\"\n" +
                "group by k.client_id;";
        cd.setName("linkedMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("linkedMsm");

        return cd;
    }
//linkedMsw
    public CohortDefinition linkedMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select k.client_id from ((select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_hts_referral_and_linkage r on t.client_id=r.client_id where  timestampdiff(MONTH,date(t.visit_date),date(:enddate))<=3 and t.final_test_result=\"Positive\")\n" +
                "                         union all (select hs.client_id from kp_etl.etl_hiv_status hs\n" +
                "                                    where hs.current_in_care =\"Yes\" and timestampdiff(MONTH,date(hs.test_date),date(:enddate))<=3 ))k  inner join kp_etl.etl_client_social_status ss on ss.client_id = k.client_id\n" +
                "                                                                                                                                                                                   and ss.key_population_type = \"Male sex worker\"\n" +
                "group by k.client_id;";
        cd.setName("linkedMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("linkedMsw");

        return cd;
    }
//linkedPwid
    public CohortDefinition linkedPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select k.client_id from ((select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_hts_referral_and_linkage r on t.client_id=r.client_id where  timestampdiff(MONTH,date(t.visit_date),date(:enddate))<=3 and t.final_test_result=\"Positive\")\n" +
                "                         union all (select hs.client_id from kp_etl.etl_hiv_status hs\n" +
                "                                    where hs.current_in_care =\"Yes\" and timestampdiff(MONTH,date(hs.test_date),date(:enddate))<=3 ))k  inner join kp_etl.etl_client_social_status ss on ss.client_id = k.client_id\n" +
                "                                                                                                                                                                                   and ss.key_population_type = \"People who inject drugs\"\n" +
                "group by k.client_id;";
        cd.setName("linkedPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("linkedPwid");

        return cd;
    }
//linkedPwud
    public CohortDefinition linkedPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select k.client_id from ((select t.client_id from kp_etl.etl_hts_test t inner join kp_etl.etl_hts_referral_and_linkage r on t.client_id=r.client_id where  timestampdiff(MONTH,date(t.visit_date),date(:enddate))<=3 and t.final_test_result=\"Positive\")\n" +
                "                         union all (select hs.client_id from kp_etl.etl_hiv_status hs\n" +
                "                                    where hs.current_in_care =\"Yes\" and timestampdiff(MONTH,date(hs.test_date),date(:enddate))<=3 ))k  inner join kp_etl.etl_client_social_status ss on ss.client_id = k.client_id\n" +
                "                                                                                                                                                                                   and ss.key_population_type = \"People who use drugs\"\n" +
                "group by k.client_id;";
        cd.setName("linkedPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("linkedPwud");

        return cd;
    }
//linkedTransgender
    public CohortDefinition linkedTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("linkedTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("linkedTransgender");

        return cd;
    }

    public CohortDefinition receivingCondomsFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select ce.client_id from kp_etl.etl_client_enrollment ce\n" +
                "join  inv_transaction tr on ce.client_id = tr.patient_id \n" +
                "join etl_client_social_status ss on ce.client_id = ss.client_id \n" +
                "join  inv_item i on tr.item_id = i.item_id\n" +
                "where i.name like \"%condom%\" and ss.key_population_type =\"Female sex worker\" and \n" +
                "date(tr.date_created) between date(:startDate) and date(:endDate);";
        cd.setName("receivingCondomsFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsFsw");

        return cd;
    }

    public CohortDefinition receivingCondomsMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select ce.client_id from kp_etl.etl_client_enrollment ce\n" +
                "join  inv_transaction tr on ce.client_id = tr.patient_id \n" +
                "join etl_client_social_status ss on ce.client_id = ss.client_id\n" +
                "join  inv_item i on tr.item_id = i.item_id\n" +
                "where i.name like \"%Needles  & syringes%\" and ss.key_population_type =\"Male who have sex with Men\"\n" +
                "date(tr.date_created) between date(:startDate) and date(:endDate);";
        cd.setName("receivingCondomsMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsMsm ");

        return cd;
    }

    public CohortDefinition receivingCondomsMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select ce.client_id from kp_etl.etl_client_enrollment ce\n" +
                "join  inv_transaction tr on ce.client_id = tr.patient_id \n" +
                "join etl_client_social_status ss on ce.client_id = ss.client_id\n" +
                "join  inv_item i on tr.item_id = i.item_id\n" +
                "where i.name like \"%Needles  & syringes%\" and ss.key_population_type =\"Male sex worker\"\n" +
                "date(tr.date_created) between date(:startDate) and date(:endDate);";
        cd.setName("receivingCondomsMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsMsw");

        return cd;
    }


    public CohortDefinition receivingCondomsPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select ce.client_id from kp_etl.etl_client_enrollment ce\n" +
                "join  inv_transaction tr on ce.client_id = tr.patient_id \n" +
                "join etl_client_social_status ss on ce.client_id = ss.client_id \n" +
                "join  inv_item i on tr.item_id = i.item_id\n" +
                "where i.name like \"%condom%\" and ss.key_population_type =\"People who inject drugs\" and \n" +
                "date(tr.date_created) between date(:startDate) and date(:endDate);";
        cd.setName("receivingCondomsPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsPwid");

        return cd;
    }

    public CohortDefinition receivingCondomsPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select ce.client_id from kp_etl.etl_client_enrollment ce\n" +
                "join  inv_transaction tr on ce.client_id = tr.patient_id \n" +
                "join etl_client_social_status ss on ce.client_id = ss.client_id \n" +
                "join  inv_item i on tr.item_id = i.item_id\n" +
                "where i.name like \"%condom%\" and ss.key_population_type =\"People who use drugs\" and \n" +
                "date(tr.date_created) between date(:startDate) and date(:endDate);";
        cd.setName("receivingCondomsPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsPwud");

        return cd;
    }

    public CohortDefinition receivingCondomsTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingCondomsTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsTransgender");

        return cd;
    }

    public CohortDefinition receivingCondomsPerNeedPerNeedFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingCondomsPerNeedPerNeedFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsPerNeedPerNeedFsw");

        return cd;
    }

    public CohortDefinition receivingCondomsPerNeedMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingCondomsPerNeedMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsPerNeedMsm");

        return cd;
    }


    public CohortDefinition receivingCondomsPerNeedMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingCondomsPerNeedMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsPerNeedMsw");

        return cd;
    }

    public CohortDefinition receivingCondomsPerNeedPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingCondomsPerNeedPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsPerNeedPwid");

        return cd;
    }



    public CohortDefinition receivingCondomsPerNeedPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingCondomsPerNeedPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsPerNeedPwud");

        return cd;
    }

    public CohortDefinition receivingCondomsPerNeedTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingCondomsPerNeedTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsPerNeedTransgender");

        return cd;
    }

    public CohortDefinition receivingNeedlesAndSyringesFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select ce.client_id from kp_etl.etl_client_enrollment ce\n" +
                "join  inv_transaction tr on ce.client_id = tr.patient_id \n" +
                "join etl_client_social_status ss on ce.client_id = ss.client_id\n" +
                "join  inv_item i on tr.item_id = i.item_id\n" +
                "where i.name like \"%Needles  & syringes%\" and ss.key_population_type =\"Female sex worker\"\n" +
                "date(tr.date_created) between date(:startDate) and date(:endDate);";
        cd.setName("receivingNeedlesAndSyringesPerNeedFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesPerNeedFsw");

        return cd;
    }

    public CohortDefinition receivingNeedlesAndSyringesMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select ce.client_id from kp_etl.etl_client_enrollment ce\n" +
                "join  inv_transaction tr on ce.client_id = tr.patient_id \n" +
                "join etl_client_social_status ss on ce.client_id = ss.client_id\n" +
                "join  inv_item i on tr.item_id = i.item_id\n" +
                "where i.name like \"%Needles  & syringes%\" and ss.key_population_type =\"Male who have sex with Men\"\n" +
                "date(tr.date_created) between date(:startDate) and date(:endDate);";
        cd.setName("receivingNeedlesAndSyringesMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesMsm");

        return cd;
    }

    public CohortDefinition receivingNeedlesAndSyringesMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select ce.client_id from kp_etl.etl_client_enrollment ce\n" +
                "join  inv_transaction tr on ce.client_id = tr.patient_id \n" +
                "join etl_client_social_status ss on ce.client_id = ss.client_id\n" +
                "join  inv_item i on tr.item_id = i.item_id\n" +
                "where i.name like \"%Needles  & syringes%\" and ss.key_population_type =\"Male sex worker\"\n" +
                "date(tr.date_created) between date(:startDate) and date(:endDate);";
        cd.setName("receivingNeedlesAndSyringesMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesMsw");

        return cd;
    }

    public CohortDefinition receivingNeedlesAndSyringesPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select ce.client_id from kp_etl.etl_client_enrollment ce\n" +
                "join inv_transaction tr on ce.client_id = tr.patient_id \n" +
                "join etl_client_social_status ss on ce.client_id = ss.client_id\n" +
                "join inv_item i on tr.item_id = i.item_id\n" +
                "where i.name like \"%Needles  & syringes%\" and ss.key_population_type =\"People who inject drugs\"\n" +
                "date(tr.date_created) between date(:startDate) and date(:endDate);";
        cd.setName("receivingNeedlesAndSyringesPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesPwid");

        return cd;
    }


    public CohortDefinition receivingNeedlesAndSyringesPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select ce.client_id from kp_etl.etl_client_enrollment ce\n" +
                "join  inv_transaction tr on ce.client_id = tr.patient_id \n" +
                "join etl_client_social_status ss on ce.client_id = ss.client_id\n" +
                "join  inv_item i on tr.item_id = i.item_id\n" +
                "where i.name like \"%Needles  & syringes%\" and ss.key_population_type =\"People who use drugs\"\n" +
                "date(tr.date_created) between date(:startDate) and date(:endDate);";
        cd.setName("receivingNeedlesAndSyringesPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesPwud");

        return cd;
    }


    public CohortDefinition receivingNeedlesAndSyringesTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingNeedlesAndSyringesTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesTransgender");

        return cd;
    }


    public CohortDefinition receivingNeedlesAndSyringesPerNeedFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingNeedlesAndSyringesPerNeedFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesPerNeedFsw");

        return cd;
    }

    public CohortDefinition receivingNeedlesAndSyringesPerNeedMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingNeedlesAndSyringesPerNeedPerNeedMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesPerNeedPerNeedMsm ");

        return cd;
    }
    public CohortDefinition receivingNeedlesAndSyringesPerNeedMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingNeedlesAndSyringesPerNeedPerNeedMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesPerNeedPerNeedMsw ");

        return cd;
    }

    public CohortDefinition receivingNeedlesAndSyringesPerNeedPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingNeedlesAndSyringesPerNeedPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesPerNeedPerNeedPwid");

        return cd;
    }

    public CohortDefinition receivingNeedlesAndSyringesPerNeedPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingNeedlesAndSyringesPerNeedPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesPerNeedPwud");

        return cd;
    }

    public CohortDefinition receivingNeedlesAndSyringesPerNeedTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingNeedlesAndSyringesPerNeedTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesPerNeedTransgender");

        return cd;
    }


    public CohortDefinition receivingLubricantsFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsFsw");

        return cd;
    }

    public CohortDefinition receivingLubricantsMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsMsm");

        return cd;
    }

    public CohortDefinition receivingLubricantsMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsMsw");

        return cd;
    }

    public CohortDefinition receivingLubricantsPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsPwid");

        return cd;
    }

    public CohortDefinition receivingLubricantsPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsPwud");

        return cd;
    }

    public CohortDefinition receivingLubricantsTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsTransgender");

        return cd;
    }

    public CohortDefinition receivingLubricantsPerNeedFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsPerNeedFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsPerNeedFsw");

        return cd;
    }

    public CohortDefinition receivingLubricantsPerNeedMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsPerNeedMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsPerNeedMsm");

        return cd;
    }

    public CohortDefinition receivingLubricantsPerNeedMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsPerNeedMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsPerNeedMsw");

        return cd;
    }

    public CohortDefinition receivingLubricantsPerNeedPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsPerNeedPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsPerNeedPwid");

        return cd;
    }

    public CohortDefinition receivingLubricantsPerNeedPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsPerNeedPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsPerNeedPwud");

        return cd;
    }

    public CohortDefinition receivingLubricantsPerNeedTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingLubricantsPerNeedTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingLubricantsPerNeedTransgender");

        return cd;
    }
/*screenedForSTIFsw*/
    public CohortDefinition screenedForSTIFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select sc.client_id from kp_etl.etl_sti_screening sc inner join kp_etl.etl_client_social_status ss on ss.client_id = sc.client_id\n" +
                "where sc.sti_screening_done = \"Yes\" and ss.key_population_type = \"Female sex worker\"  and sc.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForSTIFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForSTIFsw");

        return cd;
    }

//screenedForSTIMsm
    public CohortDefinition screenedForSTIMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select sc.client_id from kp_etl.etl_sti_screening sc inner join kp_etl.etl_client_social_status ss on ss.client_id = sc.client_id\n" +
                "where sc.sti_screening_done = \"Yes\" and ss.key_population_type = \"Male who have sex with Men\"  and sc.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForSTIMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForSTIMsm");

        return cd;
    }
//screenedForSTIMsw
    public CohortDefinition screenedForSTIMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select sc.client_id from kp_etl.etl_sti_screening sc inner join kp_etl.etl_client_social_status ss on ss.client_id = sc.client_id\n" +
                "where sc.sti_screening_done = \"Yes\" and ss.key_population_type = \"Male sex worker\"  and sc.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForSTIMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForSTIMsw");

        return cd;
    }

    public CohortDefinition screenedForSTIPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select sc.client_id from kp_etl.etl_sti_screening sc inner join kp_etl.etl_client_social_status ss on ss.client_id = sc.client_id\n" +
                "where sc.sti_screening_done = \"Yes\" and ss.key_population_type = \"People who inject drugs\" and sc.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForSTIPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForSTIPwid");

        return cd;
    }

    public CohortDefinition screenedForSTIPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select sc.client_id from kp_etl.etl_sti_screening sc inner join kp_etl.etl_client_social_status ss on ss.client_id = sc.client_id\n" +
                "where sc.sti_screening_done = \"Yes\" and ss.key_population_type = \"People who use drugs\" and sc.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForSTIPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForSTIPwud");

        return cd;
    }

    public CohortDefinition screenedForSTITransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("screenedForSTITransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForSTITransgender");

        return cd;
    }

    //screenedForHCVFsw
    public CohortDefinition screenedForHCVFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis C\" and ss.key_population_type = \"Female sex worker\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForHCVFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHCVFsw");

        return cd;
    }

//screenedForHCVMsm
    public CohortDefinition screenedForHCVMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis C\" and ss.key_population_type = \"Male who have sex with Men\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForHCVMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHCVMsm");

        return cd;
    }

    //screenedForHCVMsw
    public CohortDefinition screenedForHCVMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis C\" and ss.key_population_type = \"Male sex worker\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForHCVMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHCVMsw");

        return cd;
    }
//screenedForHCVPwid
    public CohortDefinition screenedForHCVPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis C\" and ss.key_population_type = \"People who inject drugs\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForHCVPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHCVPwid");

        return cd;
    }
//screenedForHCVPwud
    public CohortDefinition screenedForHCVPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis C\" and ss.key_population_type = \"People who use drugs\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForHCVPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHCVPwud ");

        return cd;
    }

//screenedForHCVTransgender
    public CohortDefinition screenedForHCVTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("screenedForHCVTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHCVTransgender");

        return cd;
    }

//screenedForHBVFsw
    public CohortDefinition screenedForHBVFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and ss.key_population_type = \"Female sex worker\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);\n";
        cd.setName("screenedForHBVFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHBVFsw");

        return cd;
    }
//screenedForHBVMsm
    public CohortDefinition screenedForHBVMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and ss.key_population_type = \"Male who have sex with Men\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForHBVMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHBVMsm");

        return cd;
    }

//screenedForHBVMsw
    public CohortDefinition screenedForHBVMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and ss.key_population_type = \"Male sex worker\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForHBVMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHBVMsw");

        return cd;
    }
//screenedForHBVPwid
    public CohortDefinition screenedForHBVPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and ss.key_population_type = \"People who inject drugs\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForHBVPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHBVPwid");

        return cd;
    }

//screenedForHBVPwud
    public CohortDefinition screenedForHBVPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and ss.key_population_type = \"People who use drugs\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedForHBVPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHBVPwud ");

        return cd;
    }
//screenedForHBVTransgender
    public CohortDefinition screenedForHBVTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("screenedForHBVTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedForHBVTransgender");

        return cd;
    }
//positiveHBVFsw
    public CohortDefinition positiveHBVFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Positive\" and ss.key_population_type = \"Female sex worker\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("positiveHBVFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("positiveHBVFsw");

        return cd;
    }
//positiveHBVMsm
    public CohortDefinition positiveHBVMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Positive\" and ss.key_population_type = \"Male who have sex with Men\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("positiveHBVMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("positiveHBVMsm");

        return cd;
    }
//positiveHBVMsw
    public CohortDefinition positiveHBVMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Positive\" and ss.key_population_type = \"Male sex worker\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("positiveHBVMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("positiveHBVMsw");

        return cd;
    }
//positiveHBVPwid
    public CohortDefinition positiveHBVPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Positive\" and ss.key_population_type = \"People who inject drugs\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("positiveHBVPwid");

        return cd;
    }
//positiveHBVPwud
    public CohortDefinition positiveHBVPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Positive\" and ss.key_population_type = \"People who use drugs\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("positiveHBVPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("positiveHBVPwud ");

        return cd;
    }
//positiveHBVTransgender
    public CohortDefinition positiveHBVTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Completed PEP within ");

        return cd;
    }
//treatedHBVFsw
    public CohortDefinition treatedHBVFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Positive\" and treated =\"Yes\" and ss.key_population_type = \"Female sex worker\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("treatedHBVFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("treatedHBVFsw");

        return cd;
    }
//treatedHBVMsm
    public CohortDefinition treatedHBVMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Positive\" and treated =\"Yes\" and ss.key_population_type = \"Male who have sex with Men\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("treatedHBVMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("treatedHBVMsm");

        return cd;
    }
//treatedHBVMsw
    public CohortDefinition treatedHBVMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Positive\" and treated =\"Yes\" and ss.key_population_type = \"Male sex worker\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("treatedHBVMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("treatedHBVMsw ");

        return cd;
    }

    //treatedHBVPwid
    public CohortDefinition treatedHBVPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Positive\" and treated =\"Yes\" and ss.key_population_type = \"People who inject drugs\" and hp.voided = 0 and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("treatedHBVPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("treatedHBVPwid");

        return cd;
    }

    //treatedHBVPwud
    public CohortDefinition treatedHBVPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Positive\" and treated =\"Yes\" and ss.key_population_type = \"People who use drugs\" and hp.voided = 0" +
                "and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("treatedHBVPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("treatedHBVPwud");

        return cd;
    }

    public CohortDefinition treatedHBVTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("treatedHBVTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("treatedHBVTransgender");

        return cd;
    }
//negativeHBVVaccinatedFsw
    public CohortDefinition negativeHBVVaccinatedFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Vaccinated\" and treated =\"Yes\" and ss.key_population_type = \"Female sex worker\" and hp.voided = 0\n" +
                "  and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("negativeHBVVaccinatedFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("negativeHBVVaccinatedFsw");

        return cd;
    }
//negativeHBVVaccinatedMsm
    public CohortDefinition negativeHBVVaccinatedMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Vaccinated\" and treated =\"Yes\" and ss.key_population_type = \"Male who have sex with Men\" and hp.voided = 0\n" +
                "  and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("negativeHBVVaccinatedMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("negativeHBVVaccinatedMsm");

        return cd;
    }
//negativeHBVVaccinatedMsw
    public CohortDefinition negativeHBVVaccinatedMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Vaccinated\" and treated =\"Yes\" and ss.key_population_type = \"Male sex worker\" and hp.voided = 0\n" +
                "  and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("negativeHBVVaccinatedMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("negativeHBVVaccinatedMsw ");

        return cd;
    }
//negativeHBVVaccinatedPwid
    public CohortDefinition negativeHBVVaccinatedPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Vaccinated\" and treated =\"Yes\" and ss.key_population_type = \"People who inject drugs\" and hp.voided = 0\n" +
                "and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("negativeHBVVaccinatedPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("negativeHBVVaccinatedPwid ");

        return cd;
    }
//negativeHBVVaccinatedPwud
    public CohortDefinition negativeHBVVaccinatedPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select hp.client_id from kp_etl.etl_hepatitis_screening hp inner join kp_etl.etl_client_social_status ss on ss.client_id = hp.client_id\n" +
                "where hp.hepatitis_screening_done = \"Hepatitis B\" and results =\"Vaccinated\" and treated =\"Yes\" and ss.key_population_type = \"People who use drugs\" and hp.voided = 0\n" +
                "and date(hp.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("negativeHBVVaccinatedPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("negativeHBVVaccinatedPwud");

        return cd;
    }

    public CohortDefinition negativeHBVVaccinatedTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("negativeHBVVaccinatedTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("negativeHBVVaccinatedTransgender");

        return cd;
    }
//screenedTBFsw
    public CohortDefinition screenedTBFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"Female sex worker\" and tb.voided = 0\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedTBFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedTBFsw ");

        return cd;
    }
//screenedTBMsm
    public CohortDefinition screenedTBMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"Male who have sex with Men\" and tb.voided = 0\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedTBMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedTBMsm");

        return cd;
    }
//screenedTBMsw
    public CohortDefinition screenedTBMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"Male sex worker\" and tb.voided = 0\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedTBMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedTBMsw");

        return cd;
    }
//screenedTBPwid
    public CohortDefinition screenedTBPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"People who inject drugs\" and tb.voided = 0\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("screenedTBPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedTBPwid ");

        return cd;
    }
//screenedTBPwud
    public CohortDefinition screenedTBPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"People who use drugs\" and tb.voided = 0 \n" +
                "and date(tb.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedTBPwud ");

        return cd;
    }

    public CohortDefinition screenedTBTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("screenedTBTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("screenedTBTransgender");

        return cd;
    }
//diagnosedTBFsw
    public CohortDefinition diagnosedTBFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"Female sex worker\" and tb.voided = 0 and tb.tb_results_status = \"TB Confirmed\"\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("diagnosedTBFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("diagnosedTBFsw");

        return cd;
    }

//diagnosedTBMsm
    public CohortDefinition diagnosedTBMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"Male who have sex with Men\" and tb.voided = 0 and tb.tb_results_status = \"TB Confirmed\"\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("diagnosedTBMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("diagnosedTBMsm ");

        return cd;
    }
//diagnosedTBMsw
    public CohortDefinition diagnosedTBMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"Male sex worker\" and tb.voided = 0 and tb.tb_results_status = \"TB Confirmed\"\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("diagnosedTBMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("diagnosedTBMsw");

        return cd;
    }
//diagnosedTBPwid
    public CohortDefinition diagnosedTBPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"People who inject drugs\" and tb.voided = 0 and tb.tb_results_status = \"TB Confirmed\"\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("diagnosedTBPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("diagnosedTBPwid");

        return cd;
    }
//diagnosedTBPwud
    public CohortDefinition diagnosedTBPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"People who use drugs\" and tb.voided = 0 and tb.tb_results_status = \"TB Confirmed\"\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate);";
        cd.setName("diagnosedTBPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("diagnosedTBPwud");

        return cd;
    }
//diagnosedTBTransgender
    public CohortDefinition diagnosedTBTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("diagnosedTBTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("diagnosedTBTransgender ");

        return cd;
    }
//startedOnTBTxFsw
    public CohortDefinition startedOnTBTxFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"Female sex worker\" and tb.voided = 0 and tb.tb_results_status = \"TB Confirmed\" and tb.start_anti_TB = \"Yes\"\n" +
                "  and date(tb.tb_treatment_date) between date(:startDate) and date(:endDate);";
        cd.setName("startedOnTBTxFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("startedOnTBTxFsw");

        return cd;
    }
//startedOnTBTxMsm
    public CohortDefinition startedOnTBTxMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"Male who have sex with Men\" and tb.voided = 0 and tb.tb_results_status = \"TB Confirmed\" and tb.start_anti_TB = \"Yes\"\n" +
                "  and date(tb.tb_treatment_date) between date(:startDate) and date(:endDate);";
        cd.setName("startedOnTBTxMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("startedOnTBTxMsm");

        return cd;
    }
//startedOnTBTxMsw
    public CohortDefinition startedOnTBTxMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"Male sex worker\" and tb.voided = 0 and tb.tb_results_status = \"TB Confirmed\" and tb.start_anti_TB = \"Yes\"\n" +
                "  and date(tb.tb_treatment_date) between date(:startDate) and date(:endDate);";
        cd.setName("startedOnTBTxMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("startedOnTBTxMsw ");

        return cd;
    }
    //startedOnTBTxPwid
    public CohortDefinition startedOnTBTxPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"People who inject drugs\" and tb.voided = 0 and tb.tb_results_status = \"TB Confirmed\" and tb.start_anti_TB = \"Yes\"\n" +
                "  and date(tb.tb_treatment_date) between date(:startDate) and date(:endDate);";
        cd.setName("startedOnTBTxPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("startedOnTBTxPwid");

        return cd;
    }

//startedOnTBTxPwud
    public CohortDefinition startedOnTBTxPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_client_social_status ss on ss.client_id = tb.client_id\n" +
                "where  ss.key_population_type = \"People who use drugs\" and tb.voided = 0 and tb.tb_results_status = \"TB Confirmed\" and tb.start_anti_TB = \"Yes\"\n" +
                "  and date(tb.tb_treatment_date) between date(:startDate) and date(:endDate);";
        cd.setName("startedOnTBTxPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("startedOnTBTxPwud");

        return cd;
    }
//startedOnTBTxTransgender
    public CohortDefinition startedOnTBTxTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("startedOnTBTxTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("startedOnTBTxTransgender ");

        return cd;
    }
    //tbClientsOnHAARTFsw
    public CohortDefinition tbClientsOnHAARTFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb inner join kp_etl.etl_hts_referral_and_linkage r on tb.client_id = r.client_id\n" +
                "inner join kp_etl.etl_hiv_status hs on tb.client_id = hs.client_id\n" +
                "inner join kp_etl.etl_client_social_status ss on tb.client_id = ss.client_id\n" +
                "where r.art_start_date <= tb.visit_date or (hs.art_start_date <= tb.visit_date and hs.current_in_care =\"Yes\")\n" +
                "    and ss.key_population_type = \"Female sex worker\"\n" +
                "and date(tb.visit_date) between date(:startDate) and date(:endDate) group by tb.client_id;\n";
        cd.setName("tbClientsOnHAARTFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("tbClientsOnHAARTFsw ");

        return cd;
    }

//tbClientsOnHAARTMsm
    public CohortDefinition tbClientsOnHAARTMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb left join kp_etl.etl_hts_referral_and_linkage r on tb.client_id = r.client_id\n" +
                "                                             inner join kp_etl.etl_hiv_status hs on tb.client_id = hs.client_id\n" +
                "                                             inner join kp_etl.etl_client_social_status ss on tb.client_id = ss.client_id\n" +
                "where (r.art_start_date <= tb.visit_date or (hs.art_start_date <= tb.visit_date and hs.current_in_care =\"Yes\"))\n" +
                "  and ss.key_population_type = \"Male who have sex with Men\" and tb.tb_results_status = \"TB Confirmed\"\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate) group by tb.client_id;";
        cd.setName("tbClientsOnHAARTMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("tbClientsOnHAARTMsm ");

        return cd;
    }

    //tbClientsOnHAARTMsw
    public CohortDefinition tbClientsOnHAARTMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb left join kp_etl.etl_hts_referral_and_linkage r on tb.client_id = r.client_id\n" +
                "                                             inner join kp_etl.etl_hiv_status hs on tb.client_id = hs.client_id\n" +
                "                                             inner join kp_etl.etl_client_social_status ss on tb.client_id = ss.client_id\n" +
                "where (r.art_start_date <= tb.visit_date or (hs.art_start_date <= tb.visit_date and hs.current_in_care =\"Yes\"))\n" +
                "  and ss.key_population_type = \"Male sex worker\" and tb.tb_results_status = \"TB Confirmed\"\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate) group by tb.client_id;";
        cd.setName("tbClientsOnHAARTMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("tbClientsOnHAARTMsw ");

        return cd;
    }
    //tbClientsOnHAARTPwid
    public CohortDefinition tbClientsOnHAARTPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb left join kp_etl.etl_hts_referral_and_linkage r on tb.client_id = r.client_id\n" +
                "                                             inner join kp_etl.etl_hiv_status hs on tb.client_id = hs.client_id\n" +
                "                                             inner join kp_etl.etl_client_social_status ss on tb.client_id = ss.client_id\n" +
                "where (r.art_start_date <= tb.visit_date or (hs.art_start_date <= tb.visit_date and hs.current_in_care =\"Yes\"))\n" +
                "  and ss.key_population_type = \"People who inject drugs\" and tb.tb_results_status = \"TB Confirmed\"\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate) group by tb.client_id;";
        cd.setName("tbClientsOnHAARTPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("tbClientsOnHAARTPwid");

        return cd;
    }

//tbClientsOnHAARTPwud
    public CohortDefinition tbClientsOnHAARTPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select tb.client_id from kp_etl.etl_tb_screening tb left join kp_etl.etl_hts_referral_and_linkage r on tb.client_id = r.client_id\n" +
                "                                             inner join kp_etl.etl_hiv_status hs on tb.client_id = hs.client_id\n" +
                "                                             inner join kp_etl.etl_client_social_status ss on tb.client_id = ss.client_id\n" +
                "where (r.art_start_date <= tb.visit_date or (hs.art_start_date <= tb.visit_date and hs.current_in_care =\"Yes\"))\n" +
                "  and ss.key_population_type = \"People who use drugs\" and tb.tb_results_status = \"TB Confirmed\"\n" +
                "  and date(tb.visit_date) between date(:startDate) and date(:endDate) group by tb.client_id;";
        cd.setName("tbClientsOnHAARTPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("tbClientsOnHAARTPwud ");

        return cd;
    }

    public CohortDefinition tbClientsOnHAARTTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("tbClientsOnHAARTTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("tbClientsOnHAARTTransgender ");

        return cd;
    }
    //initiatedPrEPFsw
    public CohortDefinition initiatedPrEPFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select p.client_id from kp_etl.kp_etl.etl_prep_pep_screening p inner join kp_etl.etl_client_social_status ss on p.client_id = ss.client_id\n" +
                "where status = \"Negative\" and ss.key_population_type = \"Female sex worker\" and screened_for = \"PrEP\" and status = \"Initiated\" and p.visit_date between date(:startDate) and date(:endDate)\n" +
                "group by p.client_id;";
        cd.setName("initiatedPrEPFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("initiatedPrEPFsw");
        return cd;
    }

//initiatedPrEPMsm
    public CohortDefinition initiatedPrEPMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select p.client_id from kp_etl.kp_etl.etl_prep_pep_screening p inner join kp_etl.etl_client_social_status ss on p.client_id = ss.client_id\n" +
                "where status = \"Negative\" and ss.key_population_type = \"Male who have sex with Men\" and screened_for = \"PrEP\" and status = \"Initiated\" and p.visit_date between date(:startDate) and date(:endDate)\n" +
                "group by p.client_id;";
        cd.setName("initiatedPrEPMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("initiatedPrEPMsm ");

        return cd;
    }
//initiatedPrEPMsw
    public CohortDefinition initiatedPrEPMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select p.client_id from kp_etl.kp_etl.etl_prep_pep_screening p inner join kp_etl.etl_client_social_status ss on p.client_id = ss.client_id\n" +
                "where status = \"Negative\" and ss.key_population_type = \"Male sex worker\" and screened_for = \"PrEP\" and status = \"Initiated\" and p.visit_date between date(:startDate) and date(:endDate)\n" +
                "group by p.client_id;";
        cd.setName("initiatedPrEPMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("initiatedPrEPMsw");

        return cd;
    }
    //initiatedPrEPPwid
    public CohortDefinition initiatedPrEPPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select p.client_id from kp_etl.kp_etl.etl_prep_pep_screening p inner join kp_etl.etl_client_social_status ss on p.client_id = ss.client_id\n" +
                "where status = \"Negative\" and ss.key_population_type = \"People who inject drugs\" and screened_for = \"PrEP\" and status = \"Initiated\" and p.visit_date between date(:startDate) and date(:endDate)\n" +
                "group by p.client_id;";
        cd.setName("initiatedPrEPPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("initiatedPrEPPwid ");

        return cd;
    }

//initiatedPrEPPwud
    public CohortDefinition initiatedPrEPPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select p.client_id from kp_etl.kp_etl.etl_prep_pep_screening p inner join kp_etl.etl_client_social_status ss on p.client_id = ss.client_id\n" +
                "where status = \"Negative\" and ss.key_population_type = \"People who use drugs\" and screened_for = \"PrEP\" and status = \"Initiated\" and p.visit_date between date(:startDate) and date(:endDate)\n" +
                "group by p.client_id;";
        cd.setName("initiatedPrEPPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("initiatedPrEPPwud ");

        return cd;
    }

    public CohortDefinition initiatedPrEPTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("initiatedPrEPTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("initiatedPrEPTransgender");

        return cd;
    }
    //currentOnPrEPFsw
    public CohortDefinition currentOnPrEPFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("currentOnPrEPFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("currentOnPrEPFsw");

        return cd;
    }
//currentOnPrEPMsm
    public CohortDefinition currentOnPrEPMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("currentOnPrEPMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("currentOnPrEPMsm");

        return cd;
    }

    public CohortDefinition currentOnPrEPMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("currentOnPrEPMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("currentOnPrEPMsw");

        return cd;
    }

    public CohortDefinition currentOnPrEPPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("currentOnPrEPPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("currentOnPrEPPwid");

        return cd;
    }

    public CohortDefinition currentOnPrEPPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("currentOnPrEPPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("currentOnPrEPPwud");

        return cd;
    }

    public CohortDefinition currentOnPrEPTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("currentOnPrEPTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("currentOnPrEPTransgender ");

        return cd;
    }
//turningPositiveWhileOnPrEPFsw
    public CohortDefinition turningPositiveWhileOnPrEPFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select p.client_id from kp_etl.etl_prep_pep_screening p inner join kp_etl.etl_client_social_status ss  on p.client_id = ss.client_id\n" +
                "inner join kp_etl.etl_hts_test t on t.client_id = p.client_id\n" +
                "where ss.key_population_type = \"Female sex worker\"\n" +
                "  and p.screened_for =\"PrEP\" and  p.status=\"Initiated\"\n" +
                "  and date(t.visit_date) >date(p.visit_date) and t.final_test_result=\"Positive\"\n" +
                "and date(t.visit_date) between date(:startDate) and date(:endDate)\n" +
                "group by p.client_id;";
        cd.setName("turningPositiveWhileOnPrEPFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("turningPositiveWhileOnPrEPFsw");

        return cd;
    }
//turningPositiveWhileOnPrEPMsm
    public CohortDefinition turningPositiveWhileOnPrEPMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select p.client_id from kp_etl.etl_prep_pep_screening p inner join kp_etl.etl_client_social_status ss  on p.client_id = ss.client_id\n" +
                "                                                 inner join kp_etl.etl_hts_test t on t.client_id = p.client_id\n" +
                "where ss.key_population_type = \"Male who have sex with Men\"\n" +
                "  and p.screened_for =\"PrEP\" and  p.status=\"Initiated\"\n" +
                "  and date(t.visit_date) >date(p.visit_date) and t.final_test_result=\"Positive\"\n" +
                "  and date(t.visit_date) between date(:startDate) and date(:endDate)\n" +
                "group by p.client_id;\n";
        cd.setName("turningPositiveWhileOnPrEPMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("turningPositiveWhileOnPrEPMsm ");

        return cd;
    }
//turningPositiveWhileOnPrEPMsw
    public CohortDefinition turningPositiveWhileOnPrEPMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select p.client_id from kp_etl.etl_prep_pep_screening p inner join kp_etl.etl_client_social_status ss  on p.client_id = ss.client_id\n" +
                "                                                 inner join kp_etl.etl_hts_test t on t.client_id = p.client_id\n" +
                "where ss.key_population_type = \"Male sex worker\"\n" +
                "  and p.screened_for =\"PrEP\" and  p.status=\"Initiated\"\n" +
                "  and date(t.visit_date) >date(p.visit_date) and t.final_test_result=\"Positive\"\n" +
                "  and date(t.visit_date) between date(:startDate) and date(:endDate)\n" +
                "group by p.client_id;";
        cd.setName("turningPositiveWhileOnPrEPMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("turningPositiveWhileOnPrEPMsw");

        return cd;
    }
//turningPositiveWhileOnPrEPPwid
    public CohortDefinition turningPositiveWhileOnPrEPPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select p.client_id from kp_etl.etl_prep_pep_screening p inner join kp_etl.etl_client_social_status ss  on p.client_id = ss.client_id\n" +
                "                                                 inner join kp_etl.etl_hts_test t on t.client_id = p.client_id\n" +
                "where ss.key_population_type = \"People who inject drugs\"\n" +
                "  and p.screened_for =\"PrEP\" and  p.status=\"Initiated\"\n" +
                "  and date(t.visit_date) >date(p.visit_date) and t.final_test_result=\"Positive\"\n" +
                "  and date(t.visit_date) between date(:startDate) and date(:endDate)\n" +
                "group by p.client_id;";
        cd.setName("turningPositiveWhileOnPrEPPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("turningPositiveWhileOnPrEPPwid");

        return cd;
    }
//turningPositiveWhileOnPrEPPwud
    public CohortDefinition turningPositiveWhileOnPrEPPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="select p.client_id from kp_etl.etl_prep_pep_screening p inner join kp_etl.etl_client_social_status ss  on p.client_id = ss.client_id\n" +
                "                                                 inner join kp_etl.etl_hts_test t on t.client_id = p.client_id\n" +
                "where ss.key_population_type = \"People who use drugs\"\n" +
                "  and p.screened_for =\"PrEP\" and  p.status=\"Initiated\"\n" +
                "  and date(t.visit_date) >date(p.visit_date) and t.final_test_result=\"Positive\"\n" +
                "  and date(t.visit_date) between date(:startDate) and date(:endDate)\n" +
                "group by p.client_id;\n";
        cd.setName("turningPositiveWhileOnPrEPPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("turningPositiveWhileOnPrEPPwud");

        return cd;
    }
//turningPositiveWhileOnPrEPTransgender
    public CohortDefinition turningPositiveWhileOnPrEPTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("turningPositiveWhileOnPrEPTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("turningPositiveWhileOnPrEPTransgender");

        return cd;
    }

    public CohortDefinition experiencingViolenceFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("experiencingViolenceFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("experiencingViolenceFsw");

        return cd;
    }

    public CohortDefinition experiencingViolenceMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("experiencingViolenceMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("experiencingViolenceMsm");

        return cd;
    }

    public CohortDefinition experiencingViolenceMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("experiencingViolenceMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("experiencingViolenceMsw");

        return cd;
    }

    public CohortDefinition experiencingViolencePwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("experiencingViolencePwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("experiencingViolencePwid");

        return cd;
    }

    public CohortDefinition experiencingViolencePwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("experiencingViolencePwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("experiencingViolencePwud");

        return cd;
    }

    public CohortDefinition experiencingViolenceTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("experiencingViolenceTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("experiencingViolenceTransgender");

        return cd;
    }

    public CohortDefinition receivingViolenceSupportFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingViolenceSupportFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingViolenceSupportFsw");

        return cd;
    }

    public CohortDefinition receivingViolenceSupportMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingViolenceSupportMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingViolenceSupportMsm");

        return cd;
    }


    public CohortDefinition receivingViolenceSupportMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingViolenceSupportMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingViolenceSupportMsw");

        return cd;
    }

    public CohortDefinition receivingViolenceSupportPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingViolenceSupportPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingViolenceSupportPwid");

        return cd;
    }

    public CohortDefinition receivingViolenceSupportPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingViolenceSupportPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingViolenceSupportPwud");

        return cd;
    }

    public CohortDefinition receivingViolenceSupportTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingViolenceSupportTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingViolenceSupportTransgender");

        return cd;
    }

    public CohortDefinition numberExposedFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("numberExposedFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("numberExposedFsw");

        return cd;
    }

    public CohortDefinition numberExposedMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("numberExposedMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("numberExposedMsm");

        return cd;
    }

    public CohortDefinition numberExposedMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("numberExposedMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("numberExposedMsw");

        return cd;
    }

    public CohortDefinition numberExposedPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("numberExposedPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("numberExposedPwid");

        return cd;
    }

    public CohortDefinition numberExposedPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("numberExposedPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("numberExposedPwud");

        return cd;
    }

    public CohortDefinition numberExposedTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("numberExposedTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("numberExposedTransgender");

        return cd;
    }

    public CohortDefinition receivingPEPWithin72HrsFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingPEPWithin72HrsFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingPEPWithin72HrsFsw");

        return cd;
    }

    public CohortDefinition receivingPEPWithin72HrsMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingPEPWithin72HrsMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingPEPWithin72HrsMsm");

        return cd;
    }

    public CohortDefinition receivingPEPWithin72HrsMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingPEPWithin72HrsMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingPEPWithin72HrsMsw");

        return cd;
    }

    public CohortDefinition receivingPEPWithin72HrsPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingPEPWithin72HrsPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingPEPWithin72HrsPwid");

        return cd;
    }

    public CohortDefinition  receivingPEPWithin72HrsPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingPEPWithin72HrsPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingPEPWithin72HrsPwud");

        return cd;
    }

    public CohortDefinition receivingPEPWithin72HrsTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingPEPWithin72HrsTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingPEPWithin72HrsTransgender");

        return cd;
    }

    public CohortDefinition completedPEPWith28DaysFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWith28DaysFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("completedPEPWith28DaysFsw");

        return cd;
    }
    public CohortDefinition completedPEPWith28DaysMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWith28DaysMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("completedPEPWith28DaysMsm");

        return cd;
    }

    public CohortDefinition completedPEPWith28DaysMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWith28DaysMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("completedPEPWith28DaysMsw");

        return cd;
    }

    public CohortDefinition completedPEPWith28DaysPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWith28DaysPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("completedPEPWith28DaysPwid");

        return cd;
    }

    public CohortDefinition completedPEPWith28DaysPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWith28DaysPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("completedPEPWith28DaysPwud");

        return cd;
    }

    public CohortDefinition completedPEPWith28DaysTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWith28DaysTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("completedPEPWith28DaysTransgender");

        return cd;
    }


}
