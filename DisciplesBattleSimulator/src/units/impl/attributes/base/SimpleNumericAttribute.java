package units.impl.attributes.base;

import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.values.NumericValue;


public class SimpleNumericAttribute extends AbstractSimpleAttribute 
        implements Attribute{

    private static final int DEFAULT_VALUE = 0;
    
    public SimpleNumericAttribute(AttributeId id, 
            AttributeValue<Integer> value) {
        super(id, value);
    }
    
    public SimpleNumericAttribute(AttributeId id) {
        super(id, new NumericValue(DEFAULT_VALUE));
    }
}
