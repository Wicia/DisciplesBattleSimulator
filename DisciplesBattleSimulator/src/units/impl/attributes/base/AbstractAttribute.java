package units.impl.attributes.base;

import units.api.modificators.LinkedAttributesChange;
import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeDomain;
import units.api.attributes.AttributeName;
import units.api.attributes.AttributeValue;


public abstract class AbstractAttribute {
    
    private final AttributeName name;
    private AttributeValue value;
    private LinkedAttributesChange attributeChange;
    private final AttributeDomain domain; // TODO: bedzie to po cos potrzebne???
    
    public AbstractAttribute(AttributeName name, AttributeValue value, 
            AttributeDomain domain, LinkedAttributesChange attributeChange) {
        this.name = name;
        this.value = value;
        this.domain = domain;
        this.attributeChange = attributeChange;
    }

    /**
     * Ustawienie wartości dla atrybutu, bez zmian w atrybutach powiązanych.
     * @param value nowa wartość atrybutu.
     */
    public void setValueOnly(AttributeValue value){
        this.value = value;
    }

    public AttributeName getAttributeName() {
        return name;
    }

    public AttributeValue getAttributeValue(){
        return this.value;
    }
    
    public LinkedAttributesChange getLinkedAttributesChange(){
        return this.attributeChange;
    }

    public AttributeDomain getDomain() {
        return domain;
    }
    
    /**
     * Zmiana wartości atrybutu wraz ze zmianami atrybutów powiązanych.
     * @param action akcja zmiany wartości atrybutu.
     * @param attributes lista atrybutów jednostki.
     */
    public abstract void updateValue(ChangeAttributesValuesAction action);
    
    public abstract void updateValue(AttributesCollection attributes, AttributeValue newValue);

    public void setLinkedAttributeChange(LinkedAttributesChange attributeChange) {
        this.attributeChange = attributeChange;
    }
}
