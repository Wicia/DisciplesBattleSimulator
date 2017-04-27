package units.attributes.impl.models.damage;

import units.actions.impl.ChangeAttributesValuesAction;
import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;

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
    public void updateValue(ChangeAttributesValuesAction action, AttributesCollection attributes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
