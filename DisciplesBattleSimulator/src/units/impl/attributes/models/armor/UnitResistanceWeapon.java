package units.impl.attributes.models.armor;

import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.RealValue;


public class UnitResistanceWeapon extends AbstractResistance implements Attribute{
    
    public static final AttributeId NAME = AttributeId.RESIST_WEAPON;
    
    public UnitResistanceWeapon() {
        this(new RealValue(DEFAULT_PROTECTION_LEVEL));
    }
    
    public UnitResistanceWeapon(AttributeValue value) {
        super(NAME, value, null);
    }

    @Override
    public void updateValueForAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateValue(AttributesCollection attributes, AttributeValue newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
