/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.attributes.impl.utlis;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import units.attributes.api.AttributeValue;
import units.attributes.impl.base.AbstractAttribute;
import units.attributes.impl.base.NumericValue;
import units.attributes.impl.base.TextValue;
import units.attributes.impl.base.UnitAttributes;
import units.attributes.impl.models.UnitArmor;
import units.attributes.impl.models.UnitDamage;
import units.attributes.impl.models.UnitDescription;
import units.attributes.impl.models.hitpoints.UnitHitPoints;
import units.attributes.impl.models.hitpoints.UnitMaxHitPoints;
import units.attributes.impl.models.UnitName;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class UnitAttributesCreator {
    
    private Map<String, AbstractAttribute> possibleAttributes;

    public UnitAttributesCreator() {
        this.initProperties();
        this.saveDefaultImplementations();
    }
    
    private void initProperties(){
        this.possibleAttributes = new HashMap<>();
    }
    
    private void saveDefaultImplementations() {
        addDefaultAttribute(new UnitName());
        addDefaultAttribute(new UnitArmor());
        addDefaultAttribute(new UnitDamage());
        addDefaultAttribute(new UnitDescription());
        addDefaultAttribute(new UnitHitPoints());
        addDefaultAttribute(new UnitMaxHitPoints());
    }
    
    private void addDefaultAttribute(AbstractAttribute attribute){
        this.possibleAttributes.put(attribute.getId(), attribute);
    }
    
    public UnitAttributes load(Properties props){
        UnitAttributes result = new UnitAttributes();
        Set<Object> keySet = props.keySet();
        for(Object propName : keySet){
            Object propertyValue = props.get(propName);
            AbstractAttribute attribute = possibleAttributes.get(propName.toString());
            if(attribute != null){
                attribute.setValue(getValue(propertyValue));
                result.addAttribute(attribute);
            }
        }
        
        return result;
    }
    
    private AttributeValue getValue(Object value){
        String stringValue = (String)value;
        Integer numericValue = null;
        try{
            numericValue = Integer.parseInt(stringValue);
            return new NumericValue(numericValue);
        }
        catch(Exception ex){}
        return new TextValue(stringValue);
    }
}
