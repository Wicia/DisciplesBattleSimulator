package units.impl.attributes.base;

import java.util.Set;
import units.api.attributes.Attribute;
import units.api.modificators.LinkedAttributesChange;
import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;


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
    
    public void updateValue(AttributesCollection attributes, AttributeValue newValue){
        this.setValueOnly(newValue);
    }
    
    public void updateValueForAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        AttributeValueChangeFactor attributeChange = action.getAttributeChange(id);
        this.setValueOnly(attributeChange.getNewValue(getAttributeValue()));
    }
    
    public void updateReferencedAttributes(AttributesCollection attributes, AttributeValueChangeFactor hpChangeFactor){
        LinkedAttributesChange linkedAttributesChange = getLinkedAttributesChange();
        Set<AttributeId> linkedAttributesNames = linkedAttributesChange.getLinkedAttributesNames();
        linkedAttributesNames.stream().forEach((name) -> {
            AttributeValueChangeFactor linkedAttributeChangeFactor = 
                linkedAttributesChange.calculateAttributeChangeFactor(name, hpChangeFactor);
            Attribute linkedAttribute = attributes.getAttributeByName(name);
            AttributeValue attributeValue = linkedAttribute.getAttributeValue();
            AttributeValue newValue = linkedAttributeChangeFactor.getNewValue(attributeValue);
            linkedAttribute.updateValue(attributes, newValue);
        });
    }

    public void setLinkedAttributeChange(LinkedAttributesChange attributeChange) {
        this.attributeChange = attributeChange;
    }
}
