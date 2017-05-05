package units.api.attributes;

import units.impl.actions.ChangeAttributesValuesAction;
import units.impl.attributes.base.AttributesCollection;
import units.api.modificators.LinkedAttributes;

public interface Attribute<V> {

    void setValue(AttributeValue value);
    
    /**
     * Dla zmiany wartości atrybutu z poziomu aplikowania akcji na atrybut.
     * @param attributes
     * @param action 
     */
    void updateWithAction(AttributesCollection attributes, ChangeAttributesValuesAction action);
    
    /**
     * Dla zmiany wartości atrybutu z poziomu aktualizacji powiązanych atrybutów.
     * @param attributes
     * @param newValue 
     */
    void update(AttributesCollection attributes, AttributeValue newValue);

    AttributeId getAttributeId();
    
    AttributeValue getAttributeValue();
    
    LinkedAttributes getLinkedAttributes();
}
