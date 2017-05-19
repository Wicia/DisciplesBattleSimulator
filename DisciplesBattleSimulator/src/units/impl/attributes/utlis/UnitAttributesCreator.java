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
import units.impl.attributes.values.NumericValue;
import units.impl.attributes.values.TextValue;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.base.SimpleTextAttribute;
import units.impl.attributes.models.damage.UnitDamage;
import units.impl.attributes.models.hitpoints.UnitHitPoints;
import units.impl.attributes.models.resistances.UnitElementalResistance;
import units.impl.attributes.models.resistances.UnitMeeleResistance;
import units.impl.attributes.models.resistances.UnitMindResistance;
import units.impl.attributes.models.resistances.UnitProjectileResistance;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class UnitAttributesCreator {
    
    private Map<String, Attribute> possibleAttributes = new HashMap<>();

    public UnitAttributesCreator() {
        this.initPossibleAttributes();
    }
    
    private void initPossibleAttributes(){
        addDefaultAttribute(new SimpleTextAttribute(AttributeId.NAME));
        addDefaultAttribute(new SimpleTextAttribute(AttributeId.RACE));
        addDefaultAttribute(new SimpleTextAttribute(AttributeId.TYPE));
        addDefaultAttribute(new SimpleTextAttribute(AttributeId.NOTE));
        addDefaultAttribute(new UnitHitPoints());
        addDefaultAttribute(new UnitMeeleResistance());
        addDefaultAttribute(new UnitProjectileResistance());
        addDefaultAttribute(new UnitElementalResistance());
        addDefaultAttribute(new UnitMindResistance());
        addDefaultAttribute(new UnitDamage());
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
		AttributeValue value = getAttributeValue(jsonObject, attributeCode);
		Attribute attribute = this.possibleAttributes.get(attributeCode);
		if(attribute != null){
		    attribute.setValue(value);
		}
            }
        }
        catch (IOException | JSONException ex) {}
       
        this.loadAdditionalData();
        
        return new AttributesCollection(this.possibleAttributes.values());
    }
    
    private void loadAdditionalData(){
        Attribute hitPoints = this.possibleAttributes.get(AttributeId.HIT_POINTS.getCode());
        this.possibleAttributes.put(AttributeId.MAX_HIT_POINTS.getCode(), hitPoints);
    }
    
    private AttributeValue getAttributeValue(JSONObject jsonObject, 
            String attributeCode) throws JSONException{
        Object propertyValue = jsonObject.get(attributeCode);
        return getValue(propertyValue);
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
