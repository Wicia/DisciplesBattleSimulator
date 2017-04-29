/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.impl.attributes.models.armor;

import java.util.List;
import units.api.attributes.AttributeDomain;
import units.api.attributes.AttributeName;
import units.impl.attributes.base.AbstractLinkedAttributesChange;
import units.api.modificators.LinkedAttributesChange;

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
