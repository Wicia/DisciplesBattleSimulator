/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.impl.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import units.api.actions.ActionType;
import units.api.attributes.AttributeName;
import units.impl.attributes.base.AttributesCollection;
import units.api.modificators.AttributeValueChangeFactor;
import common.api.validators.Validatable;

/**
 *
 * @author A653901
 */
public class ChangeAttributesValuesAction implements Validatable{
    
    private final ActionType type;
    
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
    
    @Override
    public void validate(){
        if(attributes == null || attributes.isEmpty()){
            throw new IllegalStateException("Brak atrybutów!");
        }
        if(changes == null || changes.isEmpty()){
            throw new IllegalStateException("Brak zmian wartości atrybutów!");
        }
    }
}
