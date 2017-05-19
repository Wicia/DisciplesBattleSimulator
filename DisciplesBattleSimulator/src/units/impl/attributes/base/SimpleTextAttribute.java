package units.impl.attributes.base;

import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.values.TextValue;

public class SimpleTextAttribute extends AbstractSimpleAttribute 
        implements Attribute{

    private final static String DEFAULT_VALUE = "???";
    
    public SimpleTextAttribute(AttributeId id, AttributeValue value) {
        super(id, value);
    }
    
    public SimpleTextAttribute(AttributeId id) {
        super(id, new TextValue(DEFAULT_VALUE));
    }
}
