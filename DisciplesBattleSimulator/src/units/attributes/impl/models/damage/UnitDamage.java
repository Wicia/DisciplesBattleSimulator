package units.attributes.impl.models.damage;

import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public class UnitDamage extends AbstractAttribute implements Attribute{
    
    public static final AttributeName NAME = AttributeName.DAMAGE;
    public static final int DEFAULT_DAMAGE = 0;
    
    public UnitDamage() {
        this(new NumericValue(DEFAULT_DAMAGE));
    }
    
    public UnitDamage(AttributeValue value) {
        super(NAME, value, AttributeDomain.ATTACK, null);
    }

    @Override
    public AttributeValue getSimpleValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateValue(AttributeValueChange change, AttributesCollection attributes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
