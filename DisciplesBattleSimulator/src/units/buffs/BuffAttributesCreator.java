/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.buffs;

import units.attributes.AttributeName;
import units.attributes.AttributeNameImpl;
import units.attributes.UnitAttributeValue;
import units.attributes.UnitAttributeValueImpl;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class BuffAttributesCreator {
    
    private final String buffDescription;
    private final String SPLITTER = "\\/";
    
    private final int PARTS = 3;
    private final int POS_ATTRIBUTE_NAME = 0;
    private final int POS_CHANGE_NAME = 1;
    private final int POS_VALUE = 2;
    
    public BuffAttributesCreator(String buffDescription){
        this.validateInput(buffDescription);
        this.buffDescription = buffDescription;
    }
    
    public BuffProperties getAttributes(){
        String[] split = buffDescription.split(SPLITTER);
        AttributeName attributeName = getAttributeName(split);
        ChangeType changeType = getChangeType(split);
        UnitAttributeValue attributeValue = getAttributeValue(split);
        return new BuffProperties(attributeName, changeType, attributeValue);
    }
    
    private void validateInput(String buffDescription){
        if(buffDescription == null || buffDescription.isEmpty()
                || buffDescription.split(SPLITTER).length != PARTS){
            throw new IllegalArgumentException(buffDescription + " jest niepoprawny!");
        }
    }
    
    private AttributeName getAttributeName(String[] split){
        return new AttributeNameImpl(split[POS_ATTRIBUTE_NAME]);
    }
    
    private ChangeType getChangeType(String[] split){
        return ChangeType.createFromString(split[POS_CHANGE_NAME]);
    }
    
    private UnitAttributeValue getAttributeValue(String[] split){
        return new UnitAttributeValueImpl(split[POS_VALUE]);
    }
}