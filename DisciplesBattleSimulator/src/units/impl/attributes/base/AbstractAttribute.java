package units.impl.attributes.base;

import java.util.Set;
import units.api.attributes.Attribute;
import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;
import units.impl.attributes.modificators.LinkedAttributesImpl;
import units.api.modificators.LinkedAttributes;


public abstract class AbstractAttribute {
    
    private final AttributeId id;
    private AttributeValue value;
    private LinkedAttributes linkedAttributes;
    
    public AbstractAttribute(AttributeId id, AttributeValue value) {
        this.id = id;
        this.value = value;
        this.linkedAttributes = new LinkedAttributesImpl();
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
    
    public LinkedAttributes getLinkedAttributes(){
        return this.linkedAttributes;
    }
    
    public void update(AttributesCollection attributes, AttributeValue newValue){
        this.setValue(newValue);
    }
    
    public void updateWithAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        AttributeValueChangeFactor attributeChangeFactor = action.getAttributeChange(id);
        this.setValue(attributeChangeFactor.getNewValue(getAttributeValue()));
    }
    
    public void updateReferencedAttributes(AttributesCollection attributes, AttributeValueChangeFactor mainAttributeChangeFactor){
        LinkedAttributes linkedAttributesChange = getLinkedAttributes();
        Set<AttributeId> linkedAttributesNames = linkedAttributesChange.geAttributesNames();
        linkedAttributesNames.stream().forEach((name) -> {
            AttributeValueChangeFactor linkedAttributeChangeFactor = 
                linkedAttributesChange.calculateAttributeChangeFactor(name, mainAttributeChangeFactor);
            Attribute linkedAttribute = attributes.getAttributeByName(name);
            AttributeValue attributeValue = linkedAttribute.getAttributeValue();
            AttributeValue newValue = linkedAttributeChangeFactor.getNewValue(attributeValue);
            linkedAttribute.update(attributes, newValue);
        });
    }
}
