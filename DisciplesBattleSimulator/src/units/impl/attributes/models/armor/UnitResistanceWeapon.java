package units.impl.attributes.models.armor;

import units.impl.actions.ChangeAttributesValuesAction;
import units.impl.attributes.models.damage.AttackAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeDomain;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.NumericValue;


public class UnitResistanceWeapon extends AbstractAttribute implements Attribute{
    
    public static final AttributeId NAME = AttributeId.RESIST_WEAPON;
    public static final int DEFAULT_PROTECTION_LEVEL = 0;
    public static final int MAX_PROTECTION_LEVEL = 100;
    
    public UnitResistanceWeapon() {
        this(new NumericValue(DEFAULT_PROTECTION_LEVEL));
    }
    
    public UnitResistanceWeapon(AttributeValue value) {
        super(NAME, value, null);
    }
    
    public int getReducedDamage(AttackAction attackAction) {
        int level = getProtectionLevel();
        if (level == DEFAULT_PROTECTION_LEVEL) {
            return attackAction.getDamage();
        }
        if (level == MAX_PROTECTION_LEVEL) {
            return 0;
        } 
        else {
            return reduceDamage(attackAction);
        }
    }
    
    private int reduceDamage(AttackAction action){
        return (int) (action.getDamage() * getPecentFactor());
    }

    private double getPecentFactor() {
        return (100.0 - (getProtectionLevel() * 1.0)) / MAX_PROTECTION_LEVEL;
    }

    public Integer getProtectionLevel() {
        return (Integer) super.getAttributeValue().get();
    }

    @Override
    public void updateValue(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateValue(AttributesCollection attributes, AttributeValue newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
