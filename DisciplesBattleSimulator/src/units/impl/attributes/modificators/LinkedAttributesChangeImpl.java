/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.impl.attributes.modificators;

import units.impl.attributes.values.RealValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;
import units.api.modificators.LinkedAttributesChange;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public class LinkedAttributesChangeImpl implements LinkedAttributesChange{

    private Map<AttributeId, AttributeValue> attributeNameToFactor;

    public LinkedAttributesChangeImpl(){
        this.attributeNameToFactor = new HashMap<>();
    }

    @Override
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
    
    @Override
    public void addLinkedAttributeChangeValue(AttributeId name, double factor){
        this.attributeNameToFactor.put(name, new RealValue(factor));
    }
    
    @Override
    public void addLinkedAttributeChangeValue(List<AttributeId> names, double factor){
        names.stream().forEach((name) -> {
            this.addLinkedAttributeChangeValue(name, factor);
        });
    }
    
    @Override
    public Set<AttributeId> getLinkedAttributesNames(){
        return this.attributeNameToFactor.keySet();
    }
}
