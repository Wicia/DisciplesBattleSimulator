/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.api.modificators;

import java.util.List;
import java.util.Set;
import units.api.attributes.AttributeId;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public interface LinkedAttributes {

    AttributeValueChangeFactor calculateAttributeChangeFactor(
            AttributeId attributeName, AttributeValueChangeFactor mainAttributeChangeValue);
    
    Set<AttributeId> geAttributesNames();
    
    void addChangeValue(List<AttributeId> names, double factor);
    
    void addChangeValue(AttributeId name, double factor);
    
    boolean containsFactor(AttributeId attributeId);
}
