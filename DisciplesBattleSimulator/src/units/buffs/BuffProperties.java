/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.buffs;

import units.attributes.AttributeName;
import units.attributes.UnitAttributeValue;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class BuffProperties {
    
    private UnitAttributeValue value;
    private AttributeName attributeName;
    private ChangeType changeType;

    public BuffProperties(AttributeName attributeName, 
            ChangeType changeType, UnitAttributeValue value) {
        this.value = value;
        this.attributeName = attributeName;
        this.changeType = changeType;
    }

    public UnitAttributeValue getValue() {
        return value;
    }

    public AttributeName getAttributeName() {
        return attributeName;
    }

    public ChangeType getChangeType() {
        return changeType;
    }
}
