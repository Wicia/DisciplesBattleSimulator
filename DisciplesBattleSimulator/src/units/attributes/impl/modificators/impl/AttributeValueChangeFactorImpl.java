/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.impl.modificators.impl;

import units.attributes.api.Attribute;
import units.attributes.api.AttributeValue;
import units.attributes.impl.base.NumericValue;
import units.attributes.impl.base.RealValue;
import units.attributes.impl.modificators.api.AttributeValueChangeFactor;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public class AttributeValueChangeFactorImpl implements AttributeValueChangeFactor {
    
    private final AttributeValue valueToChange;
    
    public AttributeValueChangeFactorImpl(AttributeValue valueToChange){
        if(valueToChange.get() instanceof Double){
            valueToChange = convert(valueToChange);
        }
        this.valueToChange = valueToChange;
    }
    
    @Override
    public AttributeValue getNewValue(AttributeValue attribute){
        AttributeValue newValue = null;
        if(valueToChange.get() instanceof Integer){
            newValue = getNewNumericValue((Integer) attribute.get());
        }
        if(valueToChange.get() instanceof Double){
            newValue = getPecentageValue((Integer) attribute.get());
        }

        return newValue;
    }
    
    private AttributeValue convert(AttributeValue attributeValue){
        double value = (double) attributeValue.get();
        if(value < 0){
            
        }
        if(value == 0.0 || value >= 1.0){
            value /= 100.0;
        }
        
        return new RealValue(value);
    }
    
    private NumericValue getNewNumericValue(Integer simpleValue){
        int modificatorValue = getSimpleModificatorValue();
        simpleValue = simpleValue + modificatorValue;
        return new NumericValue(simpleValue);
    }
    
    private NumericValue getPecentageValue(Integer simpleValue) {
        if (simpleValue == 0) {
            double modificatorValue = getSimpleModificatorValue();
            simpleValue = (int) modificatorValue;
        } 
        else {
            double modificatorValue = getSimpleModificatorValue();
            double pecentModificator = asPecentage(modificatorValue);
            simpleValue = (int) (simpleValue * pecentModificator);
        }
        return new NumericValue(simpleValue);
    }
    
    @Override
    public AttributeValue getPecentageChangeFactor(AttributeValue beforeValue, 
            AttributeValue currentValue){       
//        double factor = (currentValue * 100.0) / (maxHp * 1.0);
//        if(currentValue < maxHp){
//            factor *= (-1.0);
//        }
        
        //return new RealValue(factor);
        return null;
    }

    private <Value> Value getSimpleModificatorValue() {
        return (Value) valueToChange.get();
    }

    @Override
    public AttributeValue getModificatorValue() {
        return this.valueToChange;
    }
    
    private double asPecentage(double value){
        return (100 + value) / 100;
    }
}