/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.impl.models.armor;

import java.util.List;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.impl.base.AbstractLinkedAttributesChange;
import units.attributes.impl.base.LinkedAttributesChange;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
class LinkedAttributesChangeImpl extends AbstractLinkedAttributesChange
        implements LinkedAttributesChange {

    public LinkedAttributesChangeImpl() {
        this(UnitArmorDurability.DEFAULT_DURABILITY * 1.0);
    }
    
    public LinkedAttributesChangeImpl(double factor) {
        super.addLinkedAttributeChangeValue(AttributeName.RESIST_WEAPON, factor);
        List<AttributeName> filterByDomain = AttributeName.filterByDomain(
                AttributeDomain.PROTECTION);
        super.addLinkedAttributeChangeValue(filterByDomain, factor);
    }
}
