/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.attributes.impl.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


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

    public UnitAttributes(Properties properties) {
        this.attributes = transformProperties(properties);
    }
    
    private Map<String, AbstractAttribute> transformProperties(Properties props){
        Map<String, AbstractAttribute> result = new HashMap<>();
        Set<Object> keySet = props.keySet();
        for(Object property : keySet){
            
        } 
        return result;
    }
    
    private Map<String, AbstractAttribute> transformList(
            List<AbstractAttribute> attributes){
        Map<String, AbstractAttribute> result = new HashMap<>();
        attributes.stream().forEach((AbstractAttribute a) -> (addAttribute(a)));
        return result;
    }
    
    public AbstractAttribute getAttributeById(String id){
       return this.attributes.get(id);
    }
    
    public void addAttribute(AbstractAttribute attribute){
        this.attributes.put(attribute.getId(), attribute);
    }
}
