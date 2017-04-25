/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.impl.models.hitpoints;

import units.attributes.api.AttributeName;
import units.attributes.modificators.api.AttributeValueChange;
import units.attributes.modificators.impl.AttributeValueChangeImpl;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
enum LinkedAttributesDelta {

    ARMOR(AttributeName.RESIST_WEAPON, 0.6),
    DAMAGE(AttributeName.DAMAGE, 1.0);

    private final AttributeName name;
    private final double conversionValue;

    private LinkedAttributesDelta(AttributeName name, double conversionValue) {
        this.name = name;
        this.conversionValue = conversionValue;
    }

    public AttributeName getAttributeName() {
        return name;
    }

    public AttributeValueChange getAttributeChange(double attributeChangeFactor) {
        double finalfactor = conversionValue * attributeChangeFactor;
        return new AttributeValueChangeImpl(finalfactor);
    }
}
