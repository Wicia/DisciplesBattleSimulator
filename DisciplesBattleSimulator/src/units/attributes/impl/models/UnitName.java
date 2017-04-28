package units.attributes.impl.models;

import units.actions.impl.ChangeAttributesValuesAction;
import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;


public class UnitName extends AbstractAttribute implements Attribute{
    
    public static final AttributeName NAME = AttributeName.NAME;
    public static final String DEFAULT_NAME = "NaN";
    
    public UnitName() {
        this(new TextValue(DEFAULT_NAME));
    }
    
    public UnitName(AttributeValue value) {
        super(NAME, value, AttributeDomain.DESCRIPTION, null);
    }

    @Override
    public void updateValue(ChangeAttributesValuesAction action) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
