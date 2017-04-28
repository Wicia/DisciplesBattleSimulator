/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.models;

import units.actions.impl.ChangeAttributesValuesAction;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeName;
import units.attributes.impl.base.AttributesCollection;

//TODO: czy to jest potrzebne?
public abstract class AbstractUnit {
    
    private final AttributesCollection attributes;
    
    public AbstractUnit(AttributesCollection attributes) {
        this.attributes = attributes;
    }
    
    public void applyAction(ChangeAttributesValuesAction action){
        for(AttributeName name : action.getChangedAttributesNames()){
            Attribute attribute = attributes.getAttributeByName(name);
            attribute.updateValue(action);
        }
    }
}
