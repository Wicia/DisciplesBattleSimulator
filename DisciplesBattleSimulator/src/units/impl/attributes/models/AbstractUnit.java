/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.impl.attributes.models;

import units.api.actions.ActionType;
import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.NumericValue;
import units.api.modificators.AttributeValueChangeFactor;
import units.impl.attributes.modificators.AttributeValueChangeFactorImpl;

//TODO: czy to jest potrzebne?
public abstract class AbstractUnit {
    
    private final AttributesCollection attributes;
    
    public AbstractUnit(AttributesCollection attributes) {
        this.attributes = attributes;
    }
    
    public void test(){
        
    }
    
    public void applyAction(ChangeAttributesValuesAction action){
        for(AttributeId name : action.getChangedAttributesNames()){
            Attribute attribute = attributes.getAttributeByName(name);
            attribute.updateValue(attributes, action);
        }
    }
    
    public ChangeAttributesValuesAction createAction(){
        ChangeAttributesValuesAction action = new ChangeAttributesValuesAction(ActionType.ATTACK);
        AttributeValueChangeFactor factor = new AttributeValueChangeFactorImpl(new NumericValue(-100));
        action.addAttributeValueChange(AttributeId.HIT_POINTS, factor);
        return action;
    }
}
