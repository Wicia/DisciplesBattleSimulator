package units.impl.attributes.models.damage;

import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeDomain;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.NumericValue;

public class UnitDamage extends AbstractAttribute implements Attribute{
    
    public static final AttributeId NAME = AttributeId.DAMAGE;
    public static final int DEFAULT_DAMAGE = 0;
    
    public UnitDamage() {
        this(new NumericValue(DEFAULT_DAMAGE));
    }
    
    public UnitDamage(AttributeValue value) {
        super(NAME, value, null);
    }

    @Override
    public void updateWithAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        AttributeValueChangeFactor attributeChange = action.getAttributeChange(NAME);
        this.setValue(attributeChange.getNewValue(getAttributeValue()));
    }

    @Override
    public void update(AttributesCollection attributes, AttributeValue newValue) {
        this.setValue(newValue);
    }
}
