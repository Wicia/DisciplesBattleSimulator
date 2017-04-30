/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.impl.attributes.utlis;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.values.NumericValue;
import units.impl.attributes.values.TextValue;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.models.armor.UnitResistanceWeapon;
import units.impl.attributes.models.damage.UnitDamage;
import units.impl.attributes.models.UnitDescription;
import units.impl.attributes.models.hitpoints.UnitHitPoints;
import units.impl.attributes.models.hitpoints.UnitMaxHitPoints;
import units.impl.attributes.models.UnitName;
import units.impl.attributes.models.armor.UnitArmorDurability;

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
        this.possibleAttributes.put(attribute.getAttributeId().getCode(), attribute);
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
