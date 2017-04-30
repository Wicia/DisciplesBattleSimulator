/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.impl.attributes.modificators;

import units.api.attributes.AttributeValue;
import units.impl.attributes.values.NumericValue;
import units.impl.attributes.values.RealValue;
import units.api.modificators.AttributeValueChangeFactor;

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
    
    private AttributeValue convert(AttributeValue attributeValue){
        double value = (double) attributeValue.get();
        if(value == 0){
            throw new IllegalArgumentException("0 nie jest akceptowane!");
        }
        if(value > 0 && value < 1){
            return new RealValue(value);
        }
        else{
            value /= 100.0;
            return new RealValue(value);
        }
    }
    
    @Override
    public AttributeValue getNewValue(AttributeValue attributeValue){
        AttributeValue newValue = null;
        if(valueToChange.get() instanceof Integer){
            newValue = getNewNumericValue((Integer) attributeValue.get());
        }
        if(valueToChange.get() instanceof Double){
            newValue = getPecentageValue((Integer) attributeValue.get());
        }

        return newValue;
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
            double pecentModificator = 1.0 - modificatorValue;
            simpleValue = (int) (simpleValue * pecentModificator);
        }
        return new NumericValue(simpleValue);
    }

    private <Value> Value getSimpleModificatorValue() {
        return (Value) valueToChange.get();
    }

    @Override
    public AttributeValue getModificatorValue() {
        return this.valueToChange;
    }
}