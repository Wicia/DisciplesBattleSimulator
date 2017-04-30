package units.impl.attributes.models.armor;

import java.util.Set;
import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeDomain;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;
import units.api.modificators.LinkedAttributesChange;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.NumericValue;


public class UnitArmorDurability extends AbstractAttribute implements Attribute{
    
    public static final AttributeId NAME = AttributeId.ARMOR_DURABILITY;
    public static final int DEFAULT_DURABILITY = 0;
    
    public UnitArmorDurability() {
        this(new NumericValue(DEFAULT_DURABILITY));
    }
    
    public UnitArmorDurability(AttributeValue<Integer> value) {
        super(NAME, value, new LinkedAttributesChangeImpl());
    }

    @Override
    public void setValueOnly(AttributeValue value){
        int newValue = (int) value.get();
        super.setValueOnly(value);
        LinkedAttributesChangeImpl change = new LinkedAttributesChangeImpl(newValue);
        super.setLinkedAttributeChange(change);
    }
    
    @Override
    public void updateValue(AttributesCollection attributes, ChangeAttributesValuesAction action) {      
        AttributeValueChangeFactor attributeChange = action.getAttributeChange(NAME);
        AttributeValue newValue = attributeChange.getNewValue(getAttributeValue());
        AttributeValueChangeFactor hpChangeFactor = super.getLinkedAttributesChange().
                getPecentageChangeFactor(getAttributeValue(), newValue);
        this.setValueOnly(attributeChange.getNewValue(getAttributeValue()));
        this.updateReferencedAttributes(attributes, hpChangeFactor);
    }
    
    private void updateReferencedAttributes(AttributesCollection attributes, AttributeValueChangeFactor hpChangeFactor){
        LinkedAttributesChange linkedAttributesChange = super.getLinkedAttributesChange();
        Set<AttributeId> linkedAttributesNames = linkedAttributesChange.getLinkedAttributesNames();
        linkedAttributesNames.stream().forEach((name) -> {
            AttributeValueChangeFactor linkedAttributeChangeFactor = 
                linkedAttributesChange.calculateAttributeChangeFactor(name, hpChangeFactor);
            Attribute linkedAttribute = attributes.getAttributeByName(name);
            AttributeValue attributeValue = linkedAttribute.getAttributeValue();
            AttributeValue newValue = linkedAttributeChangeFactor.getNewValue(attributeValue);
            linkedAttribute.updateValue(attributes, newValue);
        });
    }

    @Override
    public void updateValue(AttributesCollection attributes, AttributeValue newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
