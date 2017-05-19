package units.impl.attributes.models.hitpoints;

import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;

public class UnitMaxHitPoints extends AbstractAttribute implements Attribute{
    
    public static final AttributeId NAME = AttributeId.MAX_HIT_POINTS;
    public static final int DEFAULT_VALUE = 1;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 3000;
    
    public UnitMaxHitPoints(UnitHitPoints hitPoints) {
        super(NAME, hitPoints.getAttributeValue());
    }

    public AttributeValue getCurrentHitPoints(){
        return super.getAttributeValue();
    }

    @Override
    public void updateWithAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(AttributesCollection attributes, AttributeValue newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
