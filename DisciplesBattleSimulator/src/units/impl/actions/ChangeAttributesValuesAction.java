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
import units.api.attributes.AttributeId;
import units.impl.attributes.base.AttributesCollection;
import units.api.modificators.AttributeValueChangeFactor;
import common.api.validators.Validatable;

/**
 *
 * @author A653901
 */
public class ChangeAttributesValuesAction implements Validatable{
    
    private final ActionType type;
    
    private Map<AttributeId, AttributeValueChangeFactor> changes;
    
    public ChangeAttributesValuesAction(ActionType type) {
        this.type = type;
        this.changes = new HashMap<>();
    }

    public ActionType getType() {
        return type;
    }
    
    public void addAttributeValueChange(AttributeId name, AttributeValueChangeFactor change){
        this.changes.put(name, change);
    }
    
    public AttributeValueChangeFactor getAttributeChange(AttributeId name){
        return this.changes.getOrDefault(name, null);
    }
    
    public Set<AttributeId> getChangedAttributesNames(){
        return this.changes.keySet();
    }
    
    @Override
    public void validate(){
        if(changes == null || changes.isEmpty()){
            throw new IllegalStateException("Brak zmian wartości atrybutów!");
        }
    }
}
