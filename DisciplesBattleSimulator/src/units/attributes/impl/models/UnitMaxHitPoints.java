package units.attributes.impl.models;

import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;


public class UnitMaxHitPoints extends AbstractAttribute implements Attribute{
    
    public static final String CODE = "maxHitPoints";
    
    public UnitMaxHitPoints() {
        this(null);
    }
    
    public UnitMaxHitPoints(AttributeValue value) {
        super(CODE, value);
    }

    public AttributeValue getCurrentHitPoints(){
        return super.getValue();
    }

    @Override
    public void setValue(AttributeValue value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AttributeValue getSimpleValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateValue(AttributeValueChange change, UnitAttributes attributes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
