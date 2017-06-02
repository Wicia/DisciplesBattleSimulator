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

public class DamageValueChangeGeneratot implements AttributeValueChangeGenerator{

    private static final int STEP_FACTOR = 30;
    
    @Override
    public double getNewAttributeValueChange(AttributesCollection attributes) {
	Attribute maxHp = attributes.getAttributeByName(AttributeId.MAX_HIT_POINTS);
	Integer value = (Integer) maxHp.getAttributeValue().get();
	int multiplier = (value / STEP_FACTOR) - 2;
	return (1.0 - (0.025 * multiplier));
    }
}
