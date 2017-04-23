package units.attributes.impl.models;

import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;


public class UnitDescription extends AbstractAttribute implements Attribute{
    
    public static final String CODE = "description";
    public static final String DEFAULT_DESC = "NaN";
    
    public UnitDescription() {
        this(new TextValue(DEFAULT_DESC));
    }
    
    public UnitDescription(AttributeValue value) {
        super(CODE, value);
    }

    @Override
    public AttributeValue getSimpleValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateValue(AttributeValueChange change, UnitAttributes attributes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
