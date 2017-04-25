/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.attributes.impl.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import units.attributes.api.AttributeName;


/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class AttributesCollection {
    
    private final Map<AttributeName, AbstractAttribute> attributes;
    
    public AttributesCollection() {
        this.attributes = new HashMap<>();
    }
    
    public AttributesCollection(List<AbstractAttribute> attributes) {
        this.attributes = transformList(attributes);
    }
    
    private Map<AttributeName, AbstractAttribute> transformList(
            List<AbstractAttribute> attributes){
        Map<AttributeName, AbstractAttribute> result = new HashMap<>();
        attributes.stream().forEach((AbstractAttribute a) -> (addAttribute(a)));
        return result;
    }
    
    public <V> V getAttributeByName(AttributeName name){
       return (V) this.attributes.get(name);
    }
    
    public void addAttribute(AbstractAttribute attribute){
        this.attributes.put(attribute.getName(), attribute);
    }
}
