package units.impl.attributes.models.hitpoints;

import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.modificators.AttributeValueChangeFactorImpl;
import units.impl.attributes.values.NumericValue;


public class UnitHitPoints extends AbstractAttribute implements Attribute{
    
    public static final AttributeId NAME = AttributeId.HIT_POINTS;
    public static final int DEFAULT_HIT_POINTS = 1;
    public static final int MIN_HIT_POINTS = 1;
    public static final int MAX_HIT_POINTS = 3000;
    
    public UnitHitPoints() {
        this(new NumericValue(DEFAULT_HIT_POINTS), new NumericValue(DEFAULT_HIT_POINTS));
    }
    
    public UnitHitPoints(AttributeValue value, AttributeValue maxHitPoints) {
        super(NAME, value, new NumericValue(MIN_HIT_POINTS), new NumericValue(MAX_HIT_POINTS));
    }

    @Override
    public void update(AttributesCollection attributes, AttributeValue newValue){
        AttributeValueChangeFactor pecentageChangeFactor = 
                new AttributeValueChangeFactorImpl(getAttributeValue(), newValue);
        super.update(attributes, newValue);
        super.updateReferencedAttributes(attributes, pecentageChangeFactor);
    }
    
    @Override
    public void updateWithAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        AttributeValue oldValue = super.getAttributeValue();
        super.updateWithAction(attributes, action);
        AttributeValue newValue = super.getAttributeValue();
        AttributeValueChangeFactorImpl hpChangeFactor = 
                new AttributeValueChangeFactorImpl(oldValue, newValue);
        super.updateReferencedAttributes(attributes, hpChangeFactor);
    }
}