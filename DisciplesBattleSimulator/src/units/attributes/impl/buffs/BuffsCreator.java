package units.attributes.impl.buffs;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package units.buffs;
//
//import units.attributes.impl.base.AttributeIdImpl;
//import units.attributes.impl.base.AttributeNumericValue;
//import units.attributes.api.AttributeValue;
//import units.attributes.api.String;
//
///**
// * @TODO: Add description to: class, fields, methods
// * @author Michał 'Wicia' Wietecha
// */
//public class BuffsCreator {
//    
//    private final String buffDescription;
//    private final String SPLITTER = "\\/";
//    
//    private final int PARTS = 3;
//    private final int POS_ATTRIBUTE_NAME = 0;
//    private final int POS_CHANGE_NAME = 1;
//    private final int POS_VALUE = 2;
//    
//    public BuffsCreator(String buffDescription){
//        this.validateInput(buffDescription);
//        this.buffDescription = buffDescription;
//    }
//    
//    public BuffProperties getAttributes(){
//        String[] split = buffDescription.split(SPLITTER);
//        String attributeName = getAttributeName(split);
//        ChangeType changeType = getChangeType(split);
//        AttributeValue attributeValue = getAttributeValue(split);
//        return new BuffProperties(attributeName, changeType, attributeValue);
//    }
//    
//    private void validateInput(String buffDescription){
//        if(buffDescription == null || buffDescription.isEmpty()
//                || buffDescription.split(SPLITTER).length != PARTS){
//            throw new IllegalArgumentException(buffDescription + " jest niepoprawny!");
//        }
//    }
//    
//    private String getAttributeName(String[] split){
//        return new AttributeIdImpl(split[POS_ATTRIBUTE_NAME]);
//    }
//    
//    private ChangeType getChangeType(String[] split){
//        return ChangeType.createFromString(split[POS_CHANGE_NAME]);
//    }
//    
//    private AttributeValue getAttributeValue(String[] split){
//        return null;//
//                // new AttributeNumericValue(split[POS_VALUE]);
//    }
//}