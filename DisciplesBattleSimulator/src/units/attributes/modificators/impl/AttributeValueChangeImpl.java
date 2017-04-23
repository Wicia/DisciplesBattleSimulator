/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.modificators.impl;

import units.attributes.api.AttributeValue;
import units.attributes.impl.base.AbstractAttribute;
import units.attributes.modificators.api.AttributeValueChange;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public class AttributeValueChangeImpl<Value> 
        implements AttributeValueChange<Value> {
    
    private final Value factorValue;
    
    public AttributeValueChangeImpl(Value value){
        this.factorValue = value;
    }
    
    @Override
    public AbstractAttribute apply(AbstractAttribute attribute){
        AttributeValue<Integer> attributeValue = attribute.getValue();
        Integer simpleValue = attributeValue.value();
        if(factorValue instanceof Integer){
            int modificatorValue = getModificatorValue();
            simpleValue = simpleValue + modificatorValue;
        }
        if(factorValue instanceof Double){
            double modificatorValue = getModificatorValue();
            double x = getPecentage(modificatorValue); //TODO: nazwa!
            simpleValue = (int)(simpleValue * x);
        }
        
        return attribute;
    }

    @Override
    public <Value> Value getModificatorValue() {
        return (Value) factorValue;
    }
}
