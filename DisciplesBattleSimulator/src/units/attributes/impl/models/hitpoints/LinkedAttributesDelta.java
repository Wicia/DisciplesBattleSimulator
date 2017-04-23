/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.impl.models.hitpoints;

import units.attributes.impl.models.UnitArmor;
import units.attributes.impl.models.UnitDamage;
import units.attributes.modificators.api.AttributeValueChange;
import units.attributes.modificators.impl.AttributeValueChangeImpl;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
enum LinkedAttributesDelta {

    ARMOR(UnitArmor.CODE, 0.6),
    DAMAGE(UnitDamage.CODE, 1.0);

    private final String attributeCode;
    private final double conversionValue;

    private LinkedAttributesDelta(String attributeCode, double conversionValue) {
        this.attributeCode = attributeCode;
        this.conversionValue = conversionValue;
    }

    public String getAttributeId() {
        return attributeCode;
    }

    public AttributeValueChange getAttributeChange(double attributeChangeFactor) {
        double finalfactor = conversionValue * attributeChangeFactor;
        return new AttributeValueChangeImpl(finalfactor);
    }
}
