/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.api.modificators;

import units.api.attributes.AttributeValue;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public interface AttributeValueChangeFactor {
    
    AttributeValue getNewValue(AttributeValue value);
    
    AttributeValue getModificatorValue();
}
