/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.impl.models.armor;

import units.attributes.api.AttributeName;
import units.attributes.impl.base.AbstractAttributesChange;
import units.attributes.impl.base.LinkedAttributesChange;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
class LinkedAttributesChangeImpl extends AbstractAttributesChange
        implements LinkedAttributesChange {

    public LinkedAttributesChangeImpl() {
        super.addLinkedAttributeChangeValue(AttributeName.RESIST_WEAPON, 0.6);
    }
}
