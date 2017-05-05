/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.impl.attributes.utlis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.values.NumericValue;
import units.impl.attributes.values.TextValue;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.models.resistances.UnitArmor;
import units.impl.attributes.models.resistances.UnitResistanceWeapon;
import units.impl.attributes.models.damage.UnitDamage;
import units.impl.attributes.models.description.UnitNote;
import units.impl.attributes.models.hitpoints.UnitHitPoints;
import units.impl.attributes.models.hitpoints.UnitMaxHitPoints;
import units.impl.attributes.models.description.UnitName;
import units.impl.attributes.models.resistances.UnitResistanceAir;
import units.impl.attributes.models.resistances.UnitResistanceEarth;
import units.impl.attributes.models.resistances.UnitResistanceFire;
import units.impl.attributes.models.resistances.UnitResistanceWater;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class UnitAttributesCreator {
    
    private Map<String, Attribute> possibleAttributes;
    private Set<String> attributesWithLinkedAttributes;
    private final String VALUE = "value";

    public UnitAttributesCreator() {
        this.initPossibleAttributes();
        this.initLinkedAttributes();
    }
    
    private void initPossibleAttributes(){
        this.possibleAttributes = new HashMap<>();
        addDefaultAttribute(new UnitName());
        addDefaultAttribute(new UnitResistanceWeapon());
        addDefaultAttribute(new UnitDamage());
        addDefaultAttribute(new UnitNote());
        addDefaultAttribute(new UnitHitPoints());
        addDefaultAttribute(new UnitMaxHitPoints());
        addDefaultAttribute(new UnitArmor());
        addDefaultAttribute(new UnitResistanceAir());
        addDefaultAttribute(new UnitResistanceEarth());
        addDefaultAttribute(new UnitResistanceFire());
        addDefaultAttribute(new UnitResistanceWater());       
    }
    
    private void initLinkedAttributes() {
        this.attributesWithLinkedAttributes = new HashSet<>();
        this.attributesWithLinkedAttributes.add(AttributeId.ARMOR.getCode());
    }
    
    private void addDefaultAttribute(Attribute attribute){
        this.possibleAttributes.put(attribute.getAttributeId().getCode(), attribute);
    }
    
    public AttributesCollection load(File file) {
        
        AttributesCollection result = new AttributesCollection();
        
        try {
            JSONObject jsonObject = parseJSONFile(file.getAbsolutePath());
            Iterator keys = jsonObject.keys();
            while(keys.hasNext()){
                String attributeCode = keys.next().toString();
                if(hasLinkedAttributes(attributeCode)){
                    Attribute attribute = loadAttributesWithLinked(result, 
                            jsonObject, attributeCode);
                    if(attribute != null){
                        result.addAttribute(attribute);
                    }
                }
                else{
                    Attribute attribute = loadSingleAttribute(jsonObject, 
                            attributeCode);
                    if(attribute != null){
                        result.addAttribute(attribute);
                    }
                }
            }
        } 
        catch (IOException | JSONException ex) {}
        
        return result;
    }
    
    private Attribute loadSingleAttribute(JSONObject jsonObject, 
            String attributeCode) throws JSONException{
        Attribute attribute = possibleAttributes.get(attributeCode);
        if(attribute != null){
            Object propertyValue = jsonObject.get(attributeCode);
            attribute.setValue(getValue(propertyValue));
        }
        
        return attribute;
    }
    
    private Attribute loadAttributesWithLinked(AttributesCollection attributes, 
            JSONObject mainObject, String attributeCode){
        
        Attribute attribute = possibleAttributes.get(attributeCode);
        try {
            if(attribute != null){
                attributes.addAttribute(attribute);
            }
            JSONObject subObject = mainObject.getJSONObject(attributeCode);
            Iterator subAttributes = mainObject.getJSONObject(attributeCode).keys();
            while(subAttributes.hasNext()){
                Object nextAttributeCode = subAttributes.next();
                if(VALUE.equals(nextAttributeCode)){
                    attribute.setValue(getValue(nextAttributeCode));  
                }
                else{
                    String subAttributeCode = (String) nextAttributeCode;
                    String value = subObject.getString(subAttributeCode);
                    AttributeId id = AttributeId.getByCode(subAttributeCode);
                    attribute.getLinkedAttributes().addChangeValue(id, Double.valueOf(value));
                }
            }
            
        } 
        catch (JSONException ex) {}
        
        return attribute;
    }
    
    private boolean hasLinkedAttributes(String value){
        return this.attributesWithLinkedAttributes.contains(value);
    }
    
    private JSONObject parseJSONFile(String filename) throws JSONException, IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        return new JSONObject(content);
    }
    
    private AttributeValue getValue(Object value){
        String stringValue = (String)value;
        Integer numericValue;
        try{
            numericValue = Integer.parseInt(stringValue);
            return new NumericValue(numericValue);
        }
        catch(Exception ex){}
        return new TextValue(stringValue);
    }
}
