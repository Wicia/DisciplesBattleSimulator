package units.attributes.impl.models.hitpoints;

import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;


public class UnitMaxHitPoints extends AbstractAttribute implements Attribute{
    
    public static final AttributeName NAME = AttributeName.HIT_POINTS;
    public static final int DEFAULT_MAX_HIT_POINTS = 1;
    
    public UnitMaxHitPoints() {
        this(new NumericValue(DEFAULT_MAX_HIT_POINTS));
    }
    
    public UnitMaxHitPoints(AttributeValue value) {
        super(NAME, value);
    }

    public AttributeValue getCurrentHitPoints(){
        return super.getValue();
    }

    @Override
    public AttributeValue getSimpleValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateValue(AttributeValueChange change, AttributesCollection attributes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
