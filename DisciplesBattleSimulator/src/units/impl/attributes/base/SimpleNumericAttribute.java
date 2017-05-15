package units.impl.attributes.base;

import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.values.NumericValue;


public class SimpleNumericAttribute extends AbstractSimpleAttribute 
        implements Attribute{

    private final static int DEFAULT_VALUE = 0;
    
    public SimpleNumericAttribute(AttributeId id, AttributeValue value, 
            AttributeValue minValue, AttributeValue maxValue) {
        super(id, value, minValue, maxValue);
    }
    
    public SimpleNumericAttribute(AttributeId id) {
        super(id, new NumericValue(DEFAULT_VALUE));
    }
}
