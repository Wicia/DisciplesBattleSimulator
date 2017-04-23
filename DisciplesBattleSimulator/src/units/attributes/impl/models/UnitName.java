package units.attributes.impl.models;

import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;


public class UnitName extends AbstractAttribute implements Attribute{
    
    public static final String CODE = "name";
    public static final String DEFAULT_NAME = "NaN";
    
    public UnitName() {
        this(new TextValue(DEFAULT_NAME));
    }
    
    public UnitName(AttributeValue value) {
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
