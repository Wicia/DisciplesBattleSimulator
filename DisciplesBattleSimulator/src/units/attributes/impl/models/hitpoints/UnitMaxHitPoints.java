package units.attributes.impl.models.hitpoints;

import units.actions.impl.ChangeAttributesValuesAction;
import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;

public class UnitMaxHitPoints extends AbstractAttribute implements Attribute{
    
    public static final AttributeName NAME = AttributeName.MAX_HIT_POINTS;
    public static final int DEFAULT_MAX_HIT_POINTS = 1;
    
    public UnitMaxHitPoints() {
        this(new NumericValue(DEFAULT_MAX_HIT_POINTS));
    }
    
    public UnitMaxHitPoints(AttributeValue value) {
        super(NAME, value, AttributeDomain.HIT_POINTS, null);
    }

    public AttributeValue getCurrentHitPoints(){
        return super.getAttributeValue();
    }

    @Override
    public void updateValue(ChangeAttributesValuesAction action) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
