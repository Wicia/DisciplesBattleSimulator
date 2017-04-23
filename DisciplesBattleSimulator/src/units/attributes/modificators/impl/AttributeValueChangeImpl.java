/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.modificators.impl;

import units.attributes.api.AttributeValue;
import units.attributes.impl.base.AbstractAttribute;
import units.attributes.impl.base.NumericValue;
import units.attributes.modificators.api.AttributeValueChange;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public class AttributeValueChangeImpl<Value> 
        implements AttributeValueChange<Value> {
    
    private final Value changeValue;
    
    public AttributeValueChangeImpl(Value value){
        this.changeValue = value;
    }
    
    @Override
    public AttributeValue getNewValue(AbstractAttribute attribute){
        AttributeValue<Integer> attributeValue = attribute.getValue();
        Integer simpleValue = attributeValue.value();
        AttributeValue newValue = null;
        if(changeValue instanceof Integer){
            newValue = getNewNumericValue(simpleValue);
        }
        if(changeValue instanceof Double){
            newValue = getPecentageValue(simpleValue);
        }

        return newValue;
    }
    
    private NumericValue getNewNumericValue(Integer simpleValue){
        int modificatorValue = getModificatorValue();
        simpleValue = simpleValue + modificatorValue;
        return new NumericValue(simpleValue);
    }
    
    private NumericValue getPecentageValue(Integer simpleValue) {
        if (simpleValue == 0) {
            double modificatorValue = getModificatorValue();
            simpleValue = (int) modificatorValue;
        } 
        else {
            double modificatorValue = getModificatorValue();
            double pecentModificator = asPecentage(modificatorValue);
            simpleValue = (int) (simpleValue * pecentModificator);
        }
        return new NumericValue(simpleValue);
    }

    @Override
    public <Value> Value getModificatorValue() {
        return (Value) changeValue;
    }
}