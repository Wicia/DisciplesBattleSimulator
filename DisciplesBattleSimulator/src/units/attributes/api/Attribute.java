package units.attributes.api;

import units.attributes.impl.base.LinkedAttributesChange;

public interface Attribute<V> {

    void setValueOnly(AttributeValue value);

    AttributeName getName();
    
    AttributeValue<V> getValue();
    
    AttributeDomain getDomain();
    
    LinkedAttributesChange getLinkedAttributesChange();
}
