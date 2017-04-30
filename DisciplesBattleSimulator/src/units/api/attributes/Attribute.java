package units.api.attributes;

import units.impl.actions.ChangeAttributesValuesAction;
import units.impl.attributes.base.AttributesCollection;
import units.api.modificators.LinkedAttributesChange;

public interface Attribute<V> {

    void setValueOnly(AttributeValue value);
    
    /**
     * Dla zmiany wartości atrybutu z poziomu aplikowania akcji na atrybut.
     * @param attributes
     * @param action 
     */
    void updateValueForAction(AttributesCollection attributes, ChangeAttributesValuesAction action);
    
    /**
     * Dla zmiany wartości atrybutu z poziomu aktualizacji powiązanych atrybutów.
     * @param attributes
     * @param newValue 
     */
    void updateValue(AttributesCollection attributes, AttributeValue newValue);

    AttributeId getAttributeId();
    
    AttributeValue getAttributeValue();
    
    LinkedAttributesChange getLinkedAttributesChange();
}
