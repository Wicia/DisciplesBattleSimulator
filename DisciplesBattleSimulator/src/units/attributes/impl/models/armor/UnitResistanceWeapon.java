package units.attributes.impl.models.armor;

import units.attributes.impl.models.damage.AttackAction;
import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public class UnitResistanceWeapon extends AbstractAttribute implements Attribute{
    
    public static final AttributeName NAME = AttributeName.RESIST_WEAPON;
    public static final int DEFAULT_PROTECTION_LEVEL = 0;
    public static final int MAX_PROTECTION_LEVEL = 100;
    
    public UnitResistanceWeapon() {
        this(new NumericValue(DEFAULT_PROTECTION_LEVEL));
    }
    
    public UnitResistanceWeapon(AttributeValue value) {
        super(NAME, value, AttributeDomain.PROTECTION, null);
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
        return (Integer) super.getValue().value();
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
