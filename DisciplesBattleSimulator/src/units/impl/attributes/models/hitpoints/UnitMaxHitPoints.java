package units.impl.attributes.models.hitpoints;

import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeDomain;
import units.api.attributes.AttributeName;
import units.api.attributes.AttributeValue;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.NumericValue;

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

    @Override
    public void updateValue(AttributesCollection attributes, AttributeValue newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
