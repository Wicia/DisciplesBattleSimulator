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
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.modificators.AttributeValueChangeFactorImpl;
import units.api.modificators.AttributeValueChangeFactor;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public abstract class AbstractLinkedAttributesChange {

    private Map<AttributeId, AttributeValue> attributeNameToFactor;

    public AbstractLinkedAttributesChange(){
        this.attributeNameToFactor = new HashMap<>();
    }

    public AttributeValueChangeFactor calculateAttributeChangeFactor(AttributeId attributeName, 
            AttributeValueChangeFactor mainAttributeChangeValue) {
        double conversionValue = getFactorValue(attributeName);
        double attributeFactor = (double)mainAttributeChangeValue.getModificatorValue().get();
        double finalfactor = conversionValue * attributeFactor;
        return new AttributeValueChangeFactorImpl(new RealValue(finalfactor));
    }
    
    private double getFactorValue(AttributeId attributeName){
        AttributeValue value = this.attributeNameToFactor.get(attributeName);
        if(value == null){
            throw new IllegalArgumentException("Getting value for unknown attribute " 
                    + attributeName.getCode());
        }
        return (double) value.get();
    }
    
    public void addLinkedAttributeChangeValue(AttributeId name, double factor){
        this.attributeNameToFactor.put(name, new RealValue(factor));
    }
    
    public void addLinkedAttributeChangeValue(List<AttributeId> names, double factor){
        names.stream().forEach((name) -> {
            this.addLinkedAttributeChangeValue(name, factor);
        });
    }
    
    public Set<AttributeId> getLinkedAttributesNames(){
        return this.attributeNameToFactor.keySet();
    }
}
