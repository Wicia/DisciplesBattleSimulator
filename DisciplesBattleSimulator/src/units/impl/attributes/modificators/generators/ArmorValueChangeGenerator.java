/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.impl.attributes.modificators.generators;

import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValueChangeGenerator;
import units.impl.attributes.base.AttributesCollection;

public class ArmorValueChangeGenerator implements AttributeValueChangeGenerator{

    private static final int FACTOR_STEP = 5;
	    
    private AttributeId resistanceAttributeName;
    
    public ArmorValueChangeGenerator(AttributeId resistanceAttributeName){
	this.resistanceAttributeName = resistanceAttributeName;
    }
    
    @Override
    public double getNewAttributeValueChange(AttributesCollection attributes) {
	Attribute resistanceAttribute = attributes.getAttributeByName(resistanceAttributeName);
	Integer resistanceValue = (Integer) resistanceAttribute.getAttributeValue().get();
	return (100.0 - getStepNumber(resistanceValue)) / 100.0;
    }
    
    private int getStepNumber(Integer resistanceValue){
	int repetitions = resistanceValue / FACTOR_STEP;
	return repetitions * FACTOR_STEP;
    }
}
