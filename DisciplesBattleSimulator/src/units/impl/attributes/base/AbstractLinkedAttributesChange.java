/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.impl.attributes.base;

import units.impl.attributes.values.RealValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import units.api.attributes.AttributeName;
import units.api.attributes.AttributeValue;
import units.impl.attributes.modificators.AttributeValueChangeFactorImpl;
import units.api.modificators.AttributeValueChangeFactor;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public abstract class AbstractLinkedAttributesChange {

    private Map<AttributeName, AttributeValue> attributeNameToFactor;

    public AbstractLinkedAttributesChange(){
        this.attributeNameToFactor = new HashMap<>();
    }

    public AttributeValueChangeFactor calculateAttributeChangeFactor(AttributeName attributeName, 
            AttributeValueChangeFactor mainAttributeChangeValue) {
        double conversionValue = getFactorValue(attributeName);
        double attributeFactor = (double)mainAttributeChangeValue.getModificatorValue().get();
        double finalfactor = conversionValue * attributeFactor;
        return new AttributeValueChangeFactorImpl(new RealValue(finalfactor));
    }
    
    private double getFactorValue(AttributeName attributeName){
        AttributeValue value = this.attributeNameToFactor.get(attributeName);
        if(value == null){
            throw new IllegalArgumentException("Getting value for unknown attribute " 
                    + attributeName.getCode());
        }
        return (double) value.get();
    }
    
    public void addLinkedAttributeChangeValue(AttributeName name, double factor){
        this.attributeNameToFactor.put(name, new RealValue(factor));
    }
    
    public void addLinkedAttributeChangeValue(List<AttributeName> names, double factor){
        names.stream().forEach((name) -> {
            this.addLinkedAttributeChangeValue(name, factor);
        });
    }
    
    public Set<AttributeName> getLinkedAttributesNames(){
        return this.attributeNameToFactor.keySet();
    }
    
    public AttributeValueChangeFactor getPecentageChangeFactor(AttributeValue beforeValue, 
            AttributeValue currentValue){       
        
        Object before = beforeValue.get();
        Object current = currentValue.get();
        
        if(before.getClass() != current.getClass()){
            throw new IllegalArgumentException("Atrybuty są różnych typów!");
        }
        
        double delta = 0;
        if(before instanceof Double){
            double simpleBeforeValue = (double) before;
            double simpleCurrentValue = (double) current;
            delta = (simpleCurrentValue * 100.0) / simpleBeforeValue;
        }
        if(before instanceof Integer){
            int simpleBeforeValue = (int) before;
            int simpleCurrentValue = (int) current;
            delta = (simpleCurrentValue * 100.0) / (simpleBeforeValue * 1.0);
        }
        
        return new AttributeValueChangeFactorImpl(new RealValue(delta));
    }
}
