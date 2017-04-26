package units.attributes.impl.models.armor;

import java.util.Set;
import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public class UnitArmorDurability extends AbstractAttribute implements Attribute{
    
    public static final AttributeName NAME = AttributeName.ARMOR_DURABILITY;
    public static final int DEFAULT_DURABILITY = 0;
    
    public UnitArmorDurability() {
        this(new NumericValue(DEFAULT_DURABILITY));
    }
    
    public UnitArmorDurability(AttributeValue<Integer> value) {
        super(NAME, value, AttributeDomain.PROTECTION, new LinkedAttributesChangeImpl());
    }

    @Override
    public AttributeValue getSimpleValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setValueOnly(AttributeValue value){
        double newValue = (double) value.value();
        LinkedAttributesChangeImpl change = new LinkedAttributesChangeImpl(newValue);
        super.setLinkedAttributeChange(change);
    }
    
    @Override
    public void updateValue(AttributeValueChange change, AttributesCollection attributes) {
        this.setValueOnly(change.getNewValue(this));
        //TODO: pobranie z ValueChange liczby damage
        int takenDamage = -1;
        this.updateReferencedAttributes(attributes, takenDamage);
    }
    
    private void updateReferencedAttributes(AttributesCollection attributes, int takenDamage){
        LinkedAttributesChange linkedAttributesChange = this.getLinkedAttributesChange();
        Set<AttributeName> linkedAttributesNames = linkedAttributesChange.
                getLinkedAttributesNames();
        for(AttributeName name : linkedAttributesNames){
            AttributeValueChange attributeChange = 
                    linkedAttributesChange.getAttributeChange(name, takenDamage);
            Attribute attributeByName = attributes.getAttributeByName(name);
            attributeByName.setValueOnly(attributeChange.getNewValue(attributeByName));
        }
    }
}
