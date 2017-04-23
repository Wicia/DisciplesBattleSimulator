/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.modificators.api;

import units.attributes.impl.base.AbstractAttribute;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public interface AttributeValueChange<Value> {
    
    AbstractAttribute apply(AbstractAttribute attribute);

    <Value> Value getModificatorValue();
    
    default double asPecentage(double value){
        return (100 + value) / 100;
    }
}
