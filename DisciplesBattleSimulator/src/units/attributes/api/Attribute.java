package units.attributes.api;

import units.actions.impl.ChangeAttributesValuesAction;
import units.attributes.impl.base.LinkedAttributesChange;

public interface Attribute<V> {

    void setValueOnly(AttributeValue value);
    
    void updateValue(ChangeAttributesValuesAction action);

    AttributeName getAttributeName();
    
    AttributeValue getAttributeValue();
    
    AttributeDomain getDomain();
    
    LinkedAttributesChange getLinkedAttributesChange();
}
