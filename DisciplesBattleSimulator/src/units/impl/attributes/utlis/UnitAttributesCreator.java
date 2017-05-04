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
import java.util.Properties;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import units.api.attributes.Attribute;
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
        addDefaultAttribute(new UnitNote());
        addDefaultAttribute(new UnitHitPoints());
        addDefaultAttribute(new UnitMaxHitPoints());
        addDefaultAttribute(new UnitArmor());
        addDefaultAttribute(new UnitResistanceAir());
        addDefaultAttribute(new UnitResistanceEarth());
        addDefaultAttribute(new UnitResistanceFire());
        addDefaultAttribute(new UnitResistanceWater());
    }
    
    private void addDefaultAttribute(Attribute attribute){
        this.possibleAttributes.put(attribute.getAttributeId().getCode(), attribute);
    }
    
    public AttributesCollection load(File file) {
        
        try {
            JSONObject jsonFile = parseJSONFile(file.getAbsolutePath());
            Iterator keys = jsonFile.keys();
            while(keys.hasNext()){
                Object next = keys.next();
                System.out.println(next);
            }
        } 
        catch (IOException | JSONException e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    private JSONObject parseJSONFile(String filename) throws JSONException, IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        return new JSONObject(content);
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
