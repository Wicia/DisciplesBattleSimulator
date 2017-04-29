/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.impl.attributes.models.hitpoints;

import units.api.attributes.AttributeName;
import units.impl.attributes.base.AbstractLinkedAttributesChange;
import units.api.modificators.LinkedAttributesChange;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
class LinkedAttributesChangeImpl extends AbstractLinkedAttributesChange 
        implements LinkedAttributesChange{

    public LinkedAttributesChangeImpl() {
        super.addLinkedAttributeChangeValue(AttributeName.DAMAGE, 0.75);
    }
}
