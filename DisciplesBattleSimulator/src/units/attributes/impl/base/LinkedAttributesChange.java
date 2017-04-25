/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.impl.base;

import java.util.Set;
import units.attributes.api.AttributeName;
import units.attributes.modificators.api.AttributeValueChange;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public interface LinkedAttributesChange {

    AttributeValueChange getAttributeChange(AttributeName attributeName, double attributeChangeFactor);
    
    void addLinkedAttributeChangeValue(AttributeName name, double factor);
    
    Set<AttributeName> getLinkedAttributesNames();
}
