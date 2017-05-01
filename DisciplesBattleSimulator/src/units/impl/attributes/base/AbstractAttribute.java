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
    
    public AbstractAttribute(AttributeId id, AttributeValue value) {
        this.id = id;
        this.value = value;
        this.attributeChange = null;
    }

    /**
     * Ustawienie wartości dla atrybutu, bez zmian w atrybutach powiązanych.
     * @param value nowa wartość atrybutu.
     */
    public void setValue(AttributeValue value){
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
    
    public void update(AttributesCollection attributes, AttributeValue newValue){
        this.setValue(newValue);
    }
    
    public void updateWithAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        AttributeValueChangeFactor attributeChange = action.getAttributeChange(id);
        this.setValue(attributeChange.getNewValue(getAttributeValue()));
    }
    
    public void updateReferencedAttributes(AttributesCollection attributes, AttributeValueChangeFactor mainAttributeChangeFactor){
        LinkedAttributesChange linkedAttributesChange = getLinkedAttributesChange();
        Set<AttributeId> linkedAttributesNames = linkedAttributesChange.getLinkedAttributesNames();
        linkedAttributesNames.stream().forEach((name) -> {
            AttributeValueChangeFactor linkedAttributeChangeFactor = 
                linkedAttributesChange.calculateAttributeChangeFactor(name, mainAttributeChangeFactor);
            Attribute linkedAttribute = attributes.getAttributeByName(name);
            AttributeValue attributeValue = linkedAttribute.getAttributeValue();
            AttributeValue newValue = linkedAttributeChangeFactor.getNewValue(attributeValue);
            linkedAttribute.update(attributes, newValue);
        });
    }

    public void setLinkedAttributeChange(LinkedAttributesChange attributeChange) {
        this.attributeChange = attributeChange;
    }
}
