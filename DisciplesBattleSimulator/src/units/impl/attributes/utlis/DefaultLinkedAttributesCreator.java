/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.impl.attributes.utlis;

import java.util.HashMap;
import java.util.Map;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.modificators.LinkedAttributes;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.NumericValue;

/**
 *
 * @author A653901
 */
public class DefaultLinkedAttributesCreator {
    
    public static Map<AttributeId, LinkedAttributes> create(AttributesCollection collection){
	Map<AttributeId, LinkedAttributes> result = new HashMap<>();
	
	
	
	return result;
    }
    
    private LinkedAttributes loadHitPointsAttributes(AttributesCollection collection){
	AttributeId hitPointsId = AttributeId.HIT_POINTS;
	Attribute hitPointsAttribute = collection.getAttributeByName(hitPointsId);
	LinkedAttributes linkedAttributes = hitPointsAttribute.getLinkedAttributes();
	if(!linkedAttributes.containsFactor(AttributeId.DAMAGE)){
	    
	}
	
	return null;
    }
    
    private double getDefaultDamageChangeFactor(Attribute hitPointsAttribute){
	int hp = (int) hitPointsAttribute.getAttributeValue().get();
	return Math.pow(hp, -1.0);
    }
}
