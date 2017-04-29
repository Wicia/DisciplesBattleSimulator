package units.impl.attributes.models.damage;

import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeDomain;
import units.api.attributes.AttributeName;
import units.api.attributes.AttributeValue;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.NumericValue;

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
    public void updateValue(ChangeAttributesValuesAction action) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateValue(AttributesCollection attributes, AttributeValue newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
