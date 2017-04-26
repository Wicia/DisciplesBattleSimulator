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
import units.attributes.api.Attribute;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.impl.base.AbstractAttribute;
import units.attributes.impl.base.NumericValue;
import units.attributes.impl.base.TextValue;
import units.attributes.impl.base.AttributesCollection;
import units.attributes.impl.models.armor.UnitResistanceWeapon;
import units.attributes.impl.models.damage.UnitDamage;
import units.attributes.impl.models.UnitDescription;
import units.attributes.impl.models.hitpoints.UnitHitPoints;
import units.attributes.impl.models.hitpoints.UnitMaxHitPoints;
import units.attributes.impl.models.UnitName;
import units.attributes.impl.models.armor.UnitArmorDurability;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class UnitAttributesCreator {
    
    private Map<String, Attribute> possibleAttributes;

    public UnitAttributesCreator() {
        this.initProperties();
        this.saveDefaultImplementations();
    }
    
    private void initProperties(){
        this.possibleAttributes = new HashMap<>();
    }
    
    private void saveDefaultImplementations() {
        addDefaultAttribute(new UnitName());
        addDefaultAttribute(new UnitResistanceWeapon());
        addDefaultAttribute(new UnitDamage());
        addDefaultAttribute(new UnitDescription());
        addDefaultAttribute(new UnitHitPoints());
        addDefaultAttribute(new UnitMaxHitPoints());
        addDefaultAttribute(new UnitArmorDurability());
    }
    
    private void addDefaultAttribute(Attribute attribute){
        this.possibleAttributes.put(attribute.getName().getCode(), attribute);
    }
    
    public AttributesCollection load(Properties props){
        AttributesCollection result = new AttributesCollection();
        Set<Object> keySet = props.keySet();
        for(Object propName : keySet){
            Object propertyValue = props.get(propName);
            Attribute attribute = possibleAttributes.get(propName.toString());
            if(attribute != null){
                attribute.setValueOnly(getValue(propertyValue));
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
