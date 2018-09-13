package org.openmrs.module.kenyaemr.reporting.data.converter.definition;

import org.openmrs.module.reporting.data.BaseDataDefinition;
import org.openmrs.module.reporting.data.encounter.definition.EncounterDataDefinition;
import org.openmrs.module.reporting.definition.configuration.ConfigurationPropertyCachingStrategy;
import org.openmrs.module.reporting.evaluation.caching.Caching;

/**
 * ANC Gravida Column
 */
@Caching(strategy=ConfigurationPropertyCachingStrategy.class)
public class ANCGravidaDataDefinition extends BaseDataDefinition implements EncounterDataDefinition {

    public static final long serialVersionUID = 1L;

    /**
     * Default Constructor
     */
    public ANCGravidaDataDefinition() {
        super();
    }

    /**
     * Constructor to populate name only
     */
    public ANCGravidaDataDefinition(String name) {
        super(name);
    }

    //***** INSTANCE METHODS *****

    /**
     * @see org.openmrs.module.reporting.data.DataDefinition#getDataType()
     */
    public Class<?> getDataType() {
        return Integer.class;
    }
}
