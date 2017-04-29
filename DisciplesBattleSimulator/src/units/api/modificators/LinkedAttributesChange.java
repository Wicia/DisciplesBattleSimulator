/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.api.modificators;

import java.util.Set;
import units.api.attributes.AttributeName;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public interface LinkedAttributesChange {

    AttributeValueChangeFactor calculateAttributeChangeFactor(
            AttributeName attributeName, AttributeValueChangeFactor mainAttributeChangeValue);
    
    Set<AttributeName> getLinkedAttributesNames();
    
    AttributeValueChangeFactor getPecentageChangeFactor(AttributeValue beforeValue, 
            AttributeValue currentValue);
}
