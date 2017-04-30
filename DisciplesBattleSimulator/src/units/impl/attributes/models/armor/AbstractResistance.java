/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.impl.attributes.models.armor;

import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.LinkedAttributesChange;
import units.impl.actions.ChangeAttributesValuesAction;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.models.damage.AttackAction;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class AbstractResistance extends AbstractAttribute{
    
    public static final double DEFAULT_PROTECTION_LEVEL = 0.0;
    public static final double MAX_PROTECTION_LEVEL = 100.0;
    
    public AbstractResistance(AttributeId id, AttributeValue value, 
            LinkedAttributesChange attributeChange) {
        super(id, value, null);
    }

    @Override
    public void updateValueForAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        // DO NOTHING
    }

    @Override
    public void updateValue(AttributesCollection attributes, AttributeValue newValue) {
        //DO NOTHING
    }
    
    public int getReducedDamage(AttackAction attackAction) {
        double level = (double)super.getAttributeValue().get();
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
        double protection = (double)super.getAttributeValue().get();
        return (100.0 - protection) / MAX_PROTECTION_LEVEL;
    }
}
