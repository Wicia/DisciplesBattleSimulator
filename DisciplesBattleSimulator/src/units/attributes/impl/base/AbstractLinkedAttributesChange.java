/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.impl.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.impl.modificators.impl.AttributeValueChangeFactorImpl;
import units.attributes.impl.modificators.api.AttributeValueChangeFactor;

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
            AttributeValue value) {
        double conversionValue = getFactorValue(attributeName);
        double attributeFactor = (double)value.get();
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
}
