package units.impl.attributes.base;

import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;

public class SimpleTextAttribute extends AbstractSimpleAttribute 
        implements Attribute{

    public SimpleTextAttribute(AttributeId id, AttributeValue value, 
            AttributeValue minValue, AttributeValue maxValue) {
        super(id, value, minValue, maxValue);
    }
    
    public SimpleTextAttribute(AttributeId id) {
        super(id, new TextValue(DEFAULT_TXT));
    }
}
