package units.attributes.api;

import units.attributes.impl.base.LinkedAttributesChange;

public interface Attribute<V> {

    void setValue(AttributeValue value);

    AttributeName getName();

    <V> V getSimpleValue();
    
    AttributeDomain getDomain();
    
    LinkedAttributesChange getLinkedAttributesChange();
}
