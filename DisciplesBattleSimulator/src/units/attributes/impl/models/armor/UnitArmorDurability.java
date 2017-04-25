package units.attributes.impl.models.armor;

import units.attributes.impl.models.damage.AttackAction;
import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public class UnitArmorDurability extends AbstractAttribute implements Attribute{
    
    public static final AttributeName NAME = AttributeName.ARMOR_DURABILITY;
    public static final int MIN_DURABILITY = 0;
    
    public UnitArmorDurability() {
        this(new NumericValue(MIN_DURABILITY));
    }
    
    public UnitArmorDurability(AttributeValue value) {
        super(NAME, value, new LinkedAttributesChangeImpl());
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
