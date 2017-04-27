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
import units.attributes.impl.modificators.api.AttributeValueChange;
import units.attributes.impl.modificators.impl.AttributeValueChangeImpl;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public abstract class AbstractAttributesChange {

    private Map<AttributeName, Double> attributeNameToFactor;

    public AbstractAttributesChange(){
        this.attributeNameToFactor = new HashMap<>();
    }

    public AttributeValueChange getAttributeChange(AttributeName attributeName, 
            double attributeChangeFactor) {
        double conversionValue = getFactorValue(attributeName);
        double finalfactor = conversionValue * attributeChangeFactor;
        return new AttributeValueChangeImpl(finalfactor);
    }
    
    private double getFactorValue(AttributeName attributeName){
        return this.attributeNameToFactor.getOrDefault(attributeName, 1.0);
    }
    
    public void addLinkedAttributeChangeValue(AttributeName name, double factor){
        this.attributeNameToFactor.put(name, factor);
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
