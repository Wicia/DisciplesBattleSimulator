package units.impl.attributes.base;

import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.values.TextValue;


public class SimpleTextAttribute extends AbstractSimpleAttribute 
        implements Attribute{

    private static final String DEFAULT_TXT = "";
    
    public SimpleTextAttribute(AttributeId id, 
            AttributeValue<String> value) {
        super(id, value);
    }
    
    public SimpleTextAttribute(AttributeId id) {
        super(id, new TextValue(DEFAULT_TXT));
    }
}
