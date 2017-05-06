package units.impl.attributes.models.resistances;

import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.modificators.AttributeValueChangeFactorImpl;
import units.impl.attributes.values.NumericValue;


public class UnitArmorDurability extends AbstractAttribute implements Attribute{
    
    public static final AttributeId NAME = AttributeId.ARMOR_DURABILITY;
    public static final int DEFAULT_DURABILITY = 0;
    
    public UnitArmorDurability() {
        this(new NumericValue(DEFAULT_DURABILITY));
    }
    
    public UnitArmorDurability(AttributeValue value) {
        super(NAME, value);
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