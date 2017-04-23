package units.attributes.impl.models;

import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public class UnitDamage extends AbstractAttribute implements Attribute{
    
    public static final String CODE = "damage";
    public static final int DEFAULT_DAMAGE = 0;
    
    public UnitDamage() {
        this(new NumericValue(DEFAULT_DAMAGE));
    }
    
    public UnitDamage(AttributeValue value) {
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
