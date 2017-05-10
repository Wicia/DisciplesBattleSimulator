/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.impl.attributes.models.resistances.base;

import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;
import units.api.modificators.LinkedAttributes;
import units.impl.actions.ChangeAttributesValuesAction;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.models.damage.AttackAction;
import units.impl.attributes.modificators.AttributeValueChangeFactorImpl;
import units.impl.attributes.values.NumericValue;
import units.impl.attributes.values.RealValue;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class AbstractResistance extends AbstractAttribute{
    
    public static final int DEFAULT_RESISTANCE = 0;
    public static final int MIN_RESISTANCE = -100;
    public static final int MAX_RESISTANCE = 100;

    public AbstractResistance(AttributeId id, AttributeValue value, 
            LinkedAttributes linkedAttributes) {
        super(id, value, new NumericValue(MIN_RESISTANCE), 
                new NumericValue(MAX_RESISTANCE), linkedAttributes);
    }

    public AbstractResistance(AttributeId id, AttributeValue value) {
        super(id, value, new NumericValue(MIN_RESISTANCE), 
                new NumericValue(MAX_RESISTANCE));
    }

    @Override
    public void updateWithAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        AttributeValueChangeFactor attributeChange = action.getAttributeChange(getAttributeId());
        super.setValue(attributeChange.getNewValue(super.getAttributeValue()));
    }

    @Override
    public void update(AttributesCollection attributes, AttributeValue newValue) {
        super.setValue(newValue);
    }
    
    public int getReducedDamage(AttackAction attackAction) {
        double level = (double)super.getAttributeValue().get();
        if (level == DEFAULT_RESISTANCE) {
            return attackAction.getDamage();
        }
        if (level == MAX_RESISTANCE) {
            return 0;
        } 
        else {
            return reduceDamage(attackAction);
        }
    }
    
    private int reduceDamage(AttackAction action){
        double protection = (double)super.getAttributeValue().get();
        AttributeValueChangeFactor factor = new AttributeValueChangeFactorImpl(new RealValue(protection));
        return (int) (action.getDamage() * (double)factor.getModificatorValue().get());
    }
}