/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.impl.base;

import java.util.Set;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.impl.modificators.api.AttributeValueChangeFactor;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public interface LinkedAttributesChange {

    AttributeValueChangeFactor calculateAttributeChangeFactor(
            AttributeName attributeName, AttributeValue value);
    
    Set<AttributeName> getLinkedAttributesNames();
}
