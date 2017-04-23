/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.attributes.impl.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class UnitAttributes {
    
    private final Map<String, AbstractAttribute> attributes;
    
    public UnitAttributes() {
        this.attributes = new HashMap<>();
    }
    
    public UnitAttributes(List<AbstractAttribute> attributes) {
        this.attributes = transformList(attributes);
    }
    
    private Map<String, AbstractAttribute> transformList(
            List<AbstractAttribute> attributes){
        Map<String, AbstractAttribute> result = new HashMap<>();
        attributes.stream().forEach((AbstractAttribute a) -> (addAttribute(a)));
        return result;
    }
    
    public <V> V getAttributeById(String id){
       return (V) this.attributes.get(id);
    }
    
    public void addAttribute(AbstractAttribute attribute){
        this.attributes.put(attribute.getId(), attribute);
    }
}
