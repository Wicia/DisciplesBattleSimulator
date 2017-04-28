/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.actions.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import units.actions.api.ActionType;
import units.attributes.api.AttributeName;
import units.attributes.impl.base.AttributesCollection;
import units.attributes.impl.modificators.api.AttributeValueChangeFactor;

/**
 *
 * @author A653901
 */
public class ChangeAttributesValuesAction {
    
    private final ActionType type;
    
    //TODO: czy nie jest tak ze zawsze bedzie tylko 1 zmiana?
    private Map<AttributeName, AttributeValueChangeFactor> changes;
    private AttributesCollection attributes;
    
    public ChangeAttributesValuesAction(AttributesCollection attributes, ActionType type) {
        this.type = type;
        this.changes = new HashMap<>();
        this.attributes = attributes;
    }

    public ActionType getType() {
        return type;
    }
    
    public void addAttributeValueChange(AttributeName name, AttributeValueChangeFactor change){
        this.changes.put(name, change);
    }
    
    public AttributeValueChangeFactor getAttributeChange(AttributeName name){
        return this.changes.getOrDefault(name, null);
    }
    
    public Set<AttributeName> getChangedAttributesNames(){
        return this.changes.keySet();
    }

    public AttributesCollection getAttributes() {
        return attributes;
    }
}
