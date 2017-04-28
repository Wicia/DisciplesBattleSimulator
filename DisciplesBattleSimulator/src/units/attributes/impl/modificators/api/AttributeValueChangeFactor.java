/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.impl.modificators.api;

import units.attributes.api.AttributeValue;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public interface AttributeValueChangeFactor {
    
    AttributeValue getNewValue(AttributeValue value);
    
    AttributeValue getModificatorValue();
    
    default double asPecentage(double value){
        return (100 + value) / 100;
    }
}
