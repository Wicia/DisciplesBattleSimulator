/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.modificators.impl;

import units.attributes.api.Attribute;
import units.attributes.api.AttributeValue;
import units.attributes.impl.base.NumericValue;
import units.attributes.modificators.api.AttributeValueChange;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public class AttributeValueChangeImpl<Value> 
        implements AttributeValueChange<Value> {
    
    private final Value valueToChange;
    
    public AttributeValueChangeImpl(Value valueToChange){
        this.valueToChange = valueToChange;
    }
    
    @Override
    public AttributeValue getNewValue(Attribute attribute){
        AttributeValue<Integer> wrappedWalue = attribute.getValue();
        AttributeValue newValue = null;
        if(valueToChange instanceof Integer){
            newValue = getNewNumericValue(wrappedWalue.get());
        }
        if(valueToChange instanceof Double){
            newValue = getPecentageValue(wrappedWalue.get());
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

    private <Value> Value getModificatorValue() {
        return (Value) valueToChange;
    }
}