package units.attributes.impl.models;

import units.attack.AttackAction;
import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public class UnitArmor extends AbstractAttribute implements Attribute{
    
    public static final String CODE = "armor";
    public static final int DEFAULT_PROTECTION_LEVEL = 0;
    public static final int MAX_PROTECTION_LEVEL = 100;
    
    public UnitArmor() {
        this(new NumericValue(DEFAULT_PROTECTION_LEVEL));
    }
    
    public UnitArmor(AttributeValue value) {
        super(CODE, value);
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
    public void updateValue(AttributeValueChange change, UnitAttributes attributes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
