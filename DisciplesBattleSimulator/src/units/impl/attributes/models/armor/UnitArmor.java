package units.impl.attributes.models.armor;

import java.util.Set;
import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;
import units.api.modificators.LinkedAttributesChange;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.NumericValue;


public class UnitArmor extends AbstractAttribute implements Attribute{
    
    public static final AttributeId NAME = AttributeId.ARMOR;
    public static final int DEFAULT_ARMOR = 0;
    
    public UnitArmor() {
        this(new NumericValue(DEFAULT_ARMOR));
    }
    
    public UnitArmor(AttributeValue value) {
        super(NAME, value, new ArmorLinkedAttributesChange());
    }

    @Override
    public void updateValue(AttributesCollection attributes, AttributeValue newValue){
        
    }
    
    @Override
    public void updateValueForAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        
    }
}