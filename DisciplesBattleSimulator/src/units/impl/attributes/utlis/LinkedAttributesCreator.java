/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.impl.attributes.utlis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.modificators.LinkedAttributes;
import units.impl.attributes.modificators.LinkedAttributesImpl;

/**
 *
 * @author A653901
 */
public class LinkedAttributesCreator {
    
    private static final String LINKED = "attributes.links";
    
    private static Map<String, LinkedAttributes> loadJsonAttributes(
	    Map<String, Attribute> possibleAttributes, JSONObject mainObject){
        
        Map<String, LinkedAttributes> result = new HashMap<>();
        try {
            JSONObject attributeLinks = mainObject.getJSONObject(LINKED);
            Iterator attributesWithLinks = attributeLinks.keys();
            while(attributesWithLinks.hasNext()){
                String rooAttributeCode = (String) attributesWithLinks.next();
                JSONObject rootAttributeObject = attributeLinks.getJSONObject(rooAttributeCode);
                result.put(rooAttributeCode, loadLinkedAttributes(rootAttributeObject, possibleAttributes));
            }
            
        } 
        catch (JSONException ex) {}
        
        return result;
    }
    
    private static LinkedAttributes loadLinkedAttributes(JSONObject rootAttributeObject, 
	    Map<String, Attribute> possibleAttributes) throws JSONException{
	LinkedAttributes attributes = new LinkedAttributesImpl();
	Iterator linkedAttributesCodes = rootAttributeObject.keys();
	while(linkedAttributesCodes.hasNext()){
	    String linkedAttributeCode = (String) linkedAttributesCodes.next();
	    double factorValue = rootAttributeObject.getDouble(linkedAttributeCode);
	    AttributeId attributeId = possibleAttributes.get(linkedAttributeCode).getAttributeId();
	    attributes.addChangeValue(attributeId, factorValue);
	}
	
	return attributes;
    }
    
    public static void load(Map<String, Attribute> possibleAttributes, JSONObject mainObject){
	Map<String, LinkedAttributes> attributes = loadJsonAttributes(possibleAttributes, mainObject);
	assignLinkedAttributes(possibleAttributes, attributes);
    }
    
    private static void assignLinkedAttributes(Map<String, Attribute> possibleAttributes,
            Map<String, LinkedAttributes> atrributeCodeToLinkedAttributes) {
        atrributeCodeToLinkedAttributes.keySet().stream().forEach((attributeCodeLinked) -> {
            Attribute attributeWithLinked = possibleAttributes.get(attributeCodeLinked);
            if (attributeWithLinked != null) {
                attributeWithLinked.setLinkedAttributes(
                        atrributeCodeToLinkedAttributes.get(attributeCodeLinked));
            }
        });
    }
    
    public static boolean isLinked(String attributeCode){
	return LINKED.equals(attributeCode);
    }
}
