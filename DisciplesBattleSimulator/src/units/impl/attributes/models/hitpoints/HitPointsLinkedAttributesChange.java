/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.impl.attributes.models.hitpoints;

import units.api.attributes.AttributeId;
import units.impl.attributes.base.AbstractLinkedAttributesChange;
import units.api.modificators.LinkedAttributesChange;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
class HitPointsLinkedAttributesChange extends AbstractLinkedAttributesChange 
        implements LinkedAttributesChange{

    public HitPointsLinkedAttributesChange() {
        super.addLinkedAttributeChangeValue(AttributeId.DAMAGE, 0.75);
        super.addLinkedAttributeChangeValue(AttributeId.ARMOR, 0.15);
    }
}
