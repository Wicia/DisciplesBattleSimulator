/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.attributes.impl.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeName;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class AttributesCollection {
    
    private final Map<AttributeName, Attribute> attributes;
    
    public AttributesCollection() {
        this.attributes = new HashMap<>();
    }
    
    public AttributesCollection(List<Attribute> attributes) {
        this.attributes = transformList(attributes);
    }
    
    private Map<AttributeName, Attribute> transformList(List<Attribute> attributes){
        Map<AttributeName, Attribute> result = new HashMap<>();
        attributes.stream().forEach((Attribute a) -> (addAttribute(a)));
        return result;
    }
    
    public <V> V getAttributeByName(AttributeName name){
       return (V) this.attributes.get(name);
    }
    
    public void addAttribute(Attribute attribute){
        this.attributes.put(attribute.getName(), attribute);
    }
    
    public List<Attribute> getAttributes(){
        return new ArrayList<>(attributes.values());
    }
}
