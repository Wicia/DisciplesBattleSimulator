/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.api.modificators;

import java.util.Set;
import units.api.attributes.AttributeId;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public interface LinkedAttributesChange {

    AttributeValueChangeFactor calculateAttributeChangeFactor(
            AttributeId attributeName, AttributeValueChangeFactor mainAttributeChangeValue);
    
    Set<AttributeId> getLinkedAttributesNames();
}
