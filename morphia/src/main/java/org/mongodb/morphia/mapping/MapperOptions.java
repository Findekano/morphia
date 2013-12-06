package org.mongodb.morphia.mapping;


import org.mongodb.morphia.ObjectFactory;


/**
 * Options to control mapping behavior.
 *
 * @author Scott Hernandez
 */
public class MapperOptions {
    /**
     * <p>Treat java transient fields as if they have {@code @Transient} on them</p>
     */
    public boolean actLikeSerializer;
    /**
     * <p>Controls if null are stored. </p>
     */
    public boolean storeNulls;
    /**
     * <p>Controls if empty collection/arrays are stored. </p>
     */
    public boolean storeEmpties;
    /**
     * <p>Controls if final fields are stored. </p>
     */
    public boolean ignoreFinals; //ignore final fields.

    private CustomMapper referenceMapper;
    private CustomMapper embeddedMapper;
    private CustomMapper valueMapper;
    private CustomMapper defaultMapper;

    public ObjectFactory objectFactory = new DefaultCreator();

    public MapperOptions() {
        this(new ReferenceMapper(), new EmbeddedMapper(), new ValueMapper());
    }

    public MapperOptions(final CustomMapper referenceMapper, final CustomMapper embeddedMapper, final CustomMapper valueMapper) {
        this.referenceMapper = referenceMapper;
        this.embeddedMapper = embeddedMapper;
        this.valueMapper = valueMapper;
        this.defaultMapper = embeddedMapper;
    }

    public CustomMapper getReferenceMapper() {
        return referenceMapper;
    }

    public CustomMapper getValueMapper() {
        return valueMapper;
    }

    public CustomMapper getDefaultMapper() {
        return defaultMapper;
    }

    public CustomMapper getEmbeddedMapper() {
        return embeddedMapper;
    }

    public void setReferenceMapper(final  CustomMapper referenceMapper) {
        this.referenceMapper = referenceMapper;
    }

    public void setEmbeddedMapper(final CustomMapper embeddedMapper) {
        this.embeddedMapper = embeddedMapper;
    }

    public void setValueMapper(final CustomMapper valueMapper) {
        this.valueMapper = valueMapper;
    }

    public void setDefaultMapper(final CustomMapper defaultMapper) {
        this.defaultMapper = defaultMapper;
    }
}
