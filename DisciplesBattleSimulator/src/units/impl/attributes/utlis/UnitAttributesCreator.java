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
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.LinkedAttributes;
import units.impl.attributes.values.NumericValue;
import units.impl.attributes.values.TextValue;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.base.SimpleNumericAttribute;
import units.impl.attributes.base.SimpleTextAttribute;
import units.impl.attributes.models.resistances.UnitArmorDurability;
import units.impl.attributes.models.damage.UnitDamage;
import units.impl.attributes.models.hitpoints.UnitHitPoints;
import units.impl.attributes.models.hitpoints.UnitMaxHitPoints;
import units.impl.attributes.modificators.LinkedAttributesImpl;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class UnitAttributesCreator {
    
    private Map<String, Attribute> possibleAttributes;
    private final String LINKED = "attributes.links";

    public UnitAttributesCreator() {
        this.initPossibleAttributes();
    }
    
    private void initPossibleAttributes(){
        this.possibleAttributes = new HashMap<>();
        
        addDefaultAttribute(new SimpleTextAttribute(AttributeId.NAME));
        addDefaultAttribute(new SimpleTextAttribute(AttributeId.RACE));
        addDefaultAttribute(new SimpleTextAttribute(AttributeId.TYPE));
        addDefaultAttribute(new SimpleTextAttribute(AttributeId.NOTE));
        
        addDefaultAttribute(new SimpleNumericAttribute(AttributeId.RESIST_WEAPON));
        addDefaultAttribute(new SimpleNumericAttribute(AttributeId.RESIST_AIR));
        addDefaultAttribute(new SimpleNumericAttribute(AttributeId.RESIST_EARTH));
        addDefaultAttribute(new SimpleNumericAttribute(AttributeId.RESIST_WATER));
        addDefaultAttribute(new SimpleNumericAttribute(AttributeId.RESIST_FIRE));
        
        addDefaultAttribute(new UnitDamage());
        addDefaultAttribute(new UnitHitPoints());
        addDefaultAttribute(new UnitMaxHitPoints());
        addDefaultAttribute(new UnitArmorDurability()); 
    }
    
    private void addDefaultAttribute(Attribute attribute){
        this.possibleAttributes.put(attribute.getAttributeId().getCode(), attribute);
    }
    
    public AttributesCollection load(File file) {
        
        try {
            JSONObject jsonObject = parseJSONFile(file.getAbsolutePath());
            Iterator keys = jsonObject.keys();
            while(keys.hasNext()){
                String attributeCode = keys.next().toString();
                if(LINKED.equals(attributeCode)){
                    assignLinkedAttributes(loadLinkedAttributes(jsonObject));
                }
                else{
                    AttributeValue value = getAttributeValue(jsonObject, attributeCode);
                    Attribute attribute = this.possibleAttributes.get(attributeCode);
                    if(attribute != null){
                        attribute.setValue(value);
                    }
                }
            }
        } 
        catch (IOException | JSONException ex) {}
        
        return new AttributesCollection(this.possibleAttributes.values());
    }
    
    private void assignLinkedAttributes(
            Map<String, LinkedAttributes> atrributeCodeToLinkedAttributes) {
        atrributeCodeToLinkedAttributes.keySet().stream().forEach((attributeCodeLinked) -> {
            Attribute attributeWithLinked = this.possibleAttributes.get(attributeCodeLinked);
            if (attributeWithLinked != null) {
                attributeWithLinked.setLinkedAttributes(
                        atrributeCodeToLinkedAttributes.get(attributeCodeLinked));
            }
        });
    }
    
    private AttributeValue getAttributeValue(JSONObject jsonObject, 
            String attributeCode) throws JSONException{
        Object propertyValue = jsonObject.get(attributeCode);
        return getValue(propertyValue);
    }
    
    private Map<String, LinkedAttributes> loadLinkedAttributes(JSONObject mainObject){
        
        Map<String, LinkedAttributes> result = new HashMap<>();
        try {
            JSONObject attributeLinks = mainObject.getJSONObject(LINKED);
            Iterator attributesWithinks = attributeLinks.keys();
            while(attributesWithinks.hasNext()){
                String rooAttributeCode = (String) attributesWithinks.next();
                JSONObject rootAttributeObject = attributeLinks.getJSONObject(rooAttributeCode);
                Iterator linkedAttributesCodes = rootAttributeObject.keys();
                LinkedAttributes attributes = new LinkedAttributesImpl();
                while(linkedAttributesCodes.hasNext()){
                    String linkedAttributeCode = (String) linkedAttributesCodes.next();
                    double factorValue = rootAttributeObject.getDouble(linkedAttributeCode);
                    AttributeId attributeId = this.possibleAttributes.get(linkedAttributeCode).getAttributeId();
                    attributes.addChangeValue(attributeId, factorValue);
                }
                result.put(rooAttributeCode, attributes);
            }
            
        } 
        catch (JSONException ex) {}
        
        return result;
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
