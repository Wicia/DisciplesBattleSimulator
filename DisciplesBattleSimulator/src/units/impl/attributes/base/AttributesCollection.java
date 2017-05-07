/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.impl.attributes.base;

import common.api.validators.Validatable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class AttributesCollection implements Validatable{
    
    private Map<AttributeId, Attribute> attributes = new HashMap<>();
    
    public AttributesCollection() {
    }
    
    public AttributesCollection(Collection<Attribute> attributes) {
        addAttributes(attributes);
    }
    
    public Attribute getAttributeByName(AttributeId name){
       return this.attributes.get(name);
    }
    
    public void addAttributes(Collection<Attribute> attributes){
        attributes.stream().forEach((Attribute a) -> (addAttribute(a)));
    }
    
    public void addAttribute(Attribute attribute){
        this.attributes.put(attribute.getAttributeId(), attribute);
    }
    
    public List<Attribute> getAttributes(){
        return new ArrayList<>(attributes.values());
    }
    
    public boolean isEmpty(){
        return this.attributes.isEmpty();
    }
    
    @Override
    public void validate(){
        if(attributes == null || attributes.isEmpty()){
            throw new IllegalStateException("Brak atrybutów!");
        }
    }
}
