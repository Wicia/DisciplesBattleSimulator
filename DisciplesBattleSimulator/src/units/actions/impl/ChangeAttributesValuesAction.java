/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.actions.impl;

import java.util.HashMap;
import java.util.Map;
import units.actions.api.ActionType;
import units.attributes.api.AttributeName;
import units.attributes.impl.modificators.api.AttributeValueChange;

/**
 *
 * @author A653901
 */
public class ChangeAttributesValuesAction {
    
    private final ActionType type;
            
    private Map<AttributeName, AttributeValueChange> changes;
    
    public ChangeAttributesValuesAction(ActionType type) {
        this.type = type;
        this.changes = new HashMap<>();
    }

    public ActionType getType() {
        return type;
    }
    
    public void addAttributeValueChange(AttributeName name, AttributeValueChange change){
        this.changes.put(name, change);
    }
    
    public AttributeValueChange getAttributeChange(AttributeName name){
        return this.changes.getOrDefault(name, null);
    }
}
