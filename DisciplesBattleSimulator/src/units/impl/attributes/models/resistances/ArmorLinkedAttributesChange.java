/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.impl.attributes.models.resistances;

import java.util.List;
import units.api.attributes.AttributeDomain;
import units.api.attributes.AttributeId;
import units.impl.attributes.base.AbstractLinkedAttributesChange;
import units.api.modificators.LinkedAttributesChange;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
class ArmorLinkedAttributesChange extends AbstractLinkedAttributesChange
        implements LinkedAttributesChange {

    public ArmorLinkedAttributesChange() {
        this(0.1);
    }
    
    public ArmorLinkedAttributesChange(double factor) {
        List<AttributeId> filterByDomain = AttributeId.filterByDomain(
                AttributeDomain.RESISTANCE);
        filterByDomain.remove(AttributeId.ARMOR);
        filterByDomain.stream().forEach((id) -> {
            super.addLinkedAttributeChangeValue(id, factor);
        });
    }
}
