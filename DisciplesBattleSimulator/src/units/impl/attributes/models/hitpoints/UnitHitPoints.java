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
    
    public UnitHitPoints() {
        this(new NumericValue(DEFAULT_HIT_POINTS));
    }
    
    public UnitHitPoints(AttributeValue value) {
        super(NAME, value, new HitPointsLinkedAttributesChange());
    }

    @Override
    public void updateValue(AttributesCollection attributes, AttributeValue newValue){
        AttributeValueChangeFactor pecentageChangeFactor = 
                new AttributeValueChangeFactorImpl(getAttributeValue(), newValue);
        super.updateValue(attributes, newValue);
        super.updateReferencedAttributes(attributes, pecentageChangeFactor);
    }
    
    @Override
    public void updateValueForAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        AttributeValueChangeFactor attributeChange = action.getAttributeChange(NAME);
        super.updateValueForAction(attributes, action);
        //super.updateReferencedAttributes(attributes, hpChangeFactor);
    }
}