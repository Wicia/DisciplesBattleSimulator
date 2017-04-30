package units.impl.attributes.base;

import units.api.modificators.LinkedAttributesChange;
import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;


public abstract class AbstractAttribute {
    
    private final AttributeId id;
    private AttributeValue value;
    private LinkedAttributesChange attributeChange;
    
    public AbstractAttribute(AttributeId id, AttributeValue value, 
            LinkedAttributesChange attributeChange) {
        this.id = id;
        this.value = value;
        this.attributeChange = attributeChange;
    }

    /**
     * Ustawienie wartości dla atrybutu, bez zmian w atrybutach powiązanych.
     * @param value nowa wartość atrybutu.
     */
    public void setValueOnly(AttributeValue value){
        this.value = value;
    }

    public AttributeId getAttributeId() {
        return this.id;
    }

    public AttributeValue getAttributeValue(){
        return this.value;
    }
    
    public LinkedAttributesChange getLinkedAttributesChange(){
        return this.attributeChange;
    }
    
    public abstract void updateValue(AttributesCollection attributes, ChangeAttributesValuesAction action);
    
    public abstract void updateValue(AttributesCollection attributes, AttributeValue newValue);

    public void setLinkedAttributeChange(LinkedAttributesChange attributeChange) {
        this.attributeChange = attributeChange;
    }
}
