package units.attributes.impl.models;

import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;


public class UnitDescription extends AbstractAttribute implements Attribute{
    
    public static final AttributeName NAME = AttributeName.DESCRIPTION;
    public static final String DEFAULT_DESC = "NaN";
    
    public UnitDescription() {
        this(new TextValue(DEFAULT_DESC));
    }
    
    public UnitDescription(AttributeValue value) {
        super(NAME, value, AttributeDomain.DESCRIPTION, null);
    }

    @Override
    public void updateValue(AttributeValueChange change, AttributesCollection attributes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
