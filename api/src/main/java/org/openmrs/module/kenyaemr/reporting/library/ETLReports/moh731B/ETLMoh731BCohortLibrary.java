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


public class ETLMoh731BCohortLibrary {

    public CohortDefinition activeFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("activeFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("activeFsw");

        return cd;
    }

    public CohortDefinition activeMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("activeMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("activeMsm");

        return cd;
    }

    public CohortDefinition activeMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("activeMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("activeMsw");

        return cd;
    }

    public CohortDefinition activePwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("activePwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("activePwid");

        return cd;
    }

    public CohortDefinition activePwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
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
        String sqlQuery ="";
                cd.setName("hivTestedFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("hivTestedFsw");

        return cd;
    }

    public CohortDefinition hivTestedMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("hivTestedMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("hivTestedMsm");

        return cd;
    }

    public CohortDefinition hivTestedMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("hivTestedMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("hivTestedMsw");

        return cd;
    }

    public CohortDefinition hivTestedPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("hivTestedPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("hivTestedPwid");

        return cd;
    }

    public CohortDefinition hivTestedPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
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
        String sqlQuery ="";
                cd.setName("testedAtFacilityFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtFacilityFsw");

        return cd;
    }

    public CohortDefinition testedAtFacilityMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedAtFacilityMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtFacilityMsm");

        return cd;
    }

    public CohortDefinition testedAtFacilityMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedAtFacilityMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtFacilityMsw");

        return cd;
    }

    public CohortDefinition testedAtFacilityPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedAtFacilityPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtFacilityPwid");

        return cd;
    }    public CohortDefinition testedAtFacilityPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
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

    public CohortDefinition testedAtCommunityFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedAtCommunityFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityFsw");

        return cd;
    }

    public CohortDefinition testedAtCommunityMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedAtCommunityMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityMsm");

        return cd;
    }

    public CohortDefinition testedAtCommunityMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedAtCommunityMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityMsw");

        return cd;
    }

    public CohortDefinition testedAtCommunityPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery = "";
                cd.setName("testedAtCommunityPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityPwid");

        return cd;
    }

    public CohortDefinition testedAtCommunityPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedAtCommunityPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityPwud");

        return cd;
    }

    public CohortDefinition testedAtCommunityTransgender(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedAtCommunityTransgender");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedAtCommunityTransgender");

        return cd;
    }

    public CohortDefinition testedNewFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedNewFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedNewFsw");

        return cd;
    }

    public CohortDefinition testedNewMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedNewMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedNewMsm");

        return cd;
    }

    public CohortDefinition testedNewMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedNewMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedNewMsw");

        return cd;
    }

    public CohortDefinition testedNewPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedNewPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedNewPwid");

        return cd;
    }

    public CohortDefinition testedNewPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedNewPwud");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedNewPwud");

        return cd;
    }

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

    public CohortDefinition testedRepeatFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedRepeatFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedRepeatFsw");

        return cd;
    }

    public CohortDefinition testedRepeatMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedRepeatMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedRepeatMsm");

        return cd;
    }

    public CohortDefinition testedRepeatMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedRepeatMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedRepeatMsw");

        return cd;
    }

    public CohortDefinition testedRepeatPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("testedRepeatPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("testedRepeatPwid");

        return cd;
    }

    public CohortDefinition testedRepeatPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
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


    public CohortDefinition knownPositiveFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("knownPositiveFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("knownPositiveFsw");

        return cd;
    }

    public CohortDefinition knownPositiveMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("knownPositiveMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("knownPositiveMsm");

        return cd;
    }



        public CohortDefinition knownPositiveMsw(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("knownPositiveMsw");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("knownPositiveMsw");

            return cd;
        }

        public CohortDefinition knownPositivePwid(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("knownPositivePwid");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("knownPositivePwid ");

            return cd;
        }

        public CohortDefinition knownPositivePwud(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
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

        public CohortDefinition receivedPositiveResultsFsw(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("receivedPositiveResultsFsw");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivedPositiveResultsFsw");

            return cd;
        }

        public CohortDefinition receivedPositiveResultsMsm(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("receivedPositiveResultsMsm");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivedPositiveResultsMsm");

            return cd;
        }

        public CohortDefinition receivedPositiveResultsMsw(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("receivedPositiveResultsMsw");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivedPositiveResultsMsw");

            return cd;
        }

        public CohortDefinition receivedPositiveResultsPwid(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("receivedPositiveResultsPwid");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivedPositiveResultsPwid");

            return cd;
        }

        public CohortDefinition receivedPositiveResultsPwud(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("receivedPositiveResultsPwud");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivedPositiveResultsPwud");

            return cd;
        }

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

        public CohortDefinition linkedFsw(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("linkedFsw");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("linkedFsw");

            return cd;
        }



    public CohortDefinition linkedMsm(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("linkedMsm");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("linkedMsm");

        return cd;
    }

    public CohortDefinition linkedMsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("linkedMsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("linkedMsw");

        return cd;
    }

        public CohortDefinition linkedPwid(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("linkedPwid");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("linkedPwid");

            return cd;
        }

        public CohortDefinition linkedPwud(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("linkedPwud");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("linkedPwud");

            return cd;
        }

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
            String sqlQuery ="";
            cd.setName("receivingCondomsFsw");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivingCondomsFsw");

            return cd;
        }

        public CohortDefinition receivingCondomsMsm(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("receivingCondomsMsm");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivingCondomsMsm ");

            return cd;
        }

        public CohortDefinition receivingCondomsMsw(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("receivingCondomsMsw");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivingCondomsMsw");

            return cd;
        }


    public CohortDefinition receivingCondomsPwid(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingCondomsPwid");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingCondomsPwid");

        return cd;
    }

    public CohortDefinition receivingCondomsPwud(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
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
            String sqlQuery ="";
            cd.setName("receivingNeedlesAndSyringesPerNeedFsw");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivingNeedlesAndSyringesPerNeedFsw");

            return cd;
        }

        public CohortDefinition receivingNeedlesAndSyringesMsm(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("receivingNeedlesAndSyringesMsm");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivingNeedlesAndSyringesMsm");

            return cd;
        }

        public CohortDefinition receivingNeedlesAndSyringesMsw(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("receivingNeedlesAndSyringesMsw");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivingNeedlesAndSyringesMsw");

            return cd;
        }

        public CohortDefinition receivingNeedlesAndSyringesPwid(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("receivingNeedlesAndSyringesPwid");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivingNeedlesAndSyringesPwid");

            return cd;
        }


    public CohortDefinition receivingNeedlesAndSyringesPwud(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
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

    public CohortDefinition receivingNeedlesAndSyringesPerNeedFsw(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("receivingNeedlesAndSyringesPerNeedPerNeedFsw");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("receivingNeedlesAndSyringesPerNeedPerNeedFsw ");

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

        public CohortDefinition receivingNeedlesAndSyringesPerNeedPerNeedMsw(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("receivingNeedlesAndSyringesPerNeedPerNeedMsw");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("receivingNeedlesAndSyringesPerNeedPerNeedMsw");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Completed PEP within ");

        return cd;
    }



    public CohortDefinition completedPEPWithin28Days(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Completed PEP within ");

        return cd;
    }

    public CohortDefinition completedPEPWithin28Days(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Completed PEP within ");

        return cd;
    }

    public CohortDefinition completedPEPWithin28Days(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery =""

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Completed PEP within ");

        return cd;
    }



    public CohortDefinition completedPEPWithin28Days(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Completed PEP within ");

        return cd;
    }

    public CohortDefinition completedPEPWithin28Days(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Completed PEP within ");

        return cd;
    }

    public CohortDefinition completedPEPWithin28Days(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery =""

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Completed PEP within ");

        return cd;
    }


    public CohortDefinition completedPEPWithin28Days(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
                cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Completed PEP within ");

        return cd;
    }

    public CohortDefinition completedPEPWithin28Days(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery ="";
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Completed PEP within ");

        return cd;
    }

    public CohortDefinition completedPEPWithin28Days(){
        SqlCohortDefinition cd = new SqlCohortDefinition();
        String sqlQuery =""

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }

        public CohortDefinition completedPEPWithin28Days(){
            SqlCohortDefinition cd = new SqlCohortDefinition();
            String sqlQuery ="";
            cd.setName("completedPEPWithin28Days");
            cd.setQuery(sqlQuery);
            cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
            cd.addParameter(new Parameter("endDate", "End Date", Date.class));
            cd.setDescription("Completed PEP within ");

            return cd;
        }
        cd.setName("completedPEPWithin28Days");
        cd.setQuery(sqlQuery);
        cd.addParameter(new Parameter("startDate", "Start Date", Date.class));
        cd.addParameter(new Parameter("endDate", "End Date", Date.class));
        cd.setDescription("Completed PEP within ");

        return cd;
    }


}
