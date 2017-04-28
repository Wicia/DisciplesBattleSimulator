package units.attributes.impl.models.armor;

import java.util.Set;
import units.actions.impl.ChangeAttributesValuesAction;
import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.impl.modificators.api.AttributeValueChangeFactor;


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
    public void setValueOnly(AttributeValue value){
        int newValue = (int) value.get();
        super.setValueOnly(value);
        LinkedAttributesChangeImpl change = new LinkedAttributesChangeImpl(newValue);
        super.setLinkedAttributeChange(change);
    }
    
    @Override
    public void updateValue(ChangeAttributesValuesAction action) {      
        //TODO: ustaw nowa wartosc tylko gdy test to negatywny buff 
        //this.setValueOnly(attributeChange.getNewValue(this));
        //TODO: pobranie z ValueChange liczby damage
        this.updateReferencedAttributes(action);
    }
    
    private void updateReferencedAttributes(ChangeAttributesValuesAction action){
        LinkedAttributesChange linkedAttributesChange = this.getLinkedAttributesChange();
        Set<AttributeName> linkedAttributesNames = linkedAttributesChange.
                getLinkedAttributesNames();
        for(AttributeName name : linkedAttributesNames){
            AttributeValueChangeFactor changeFactor = action.getAttributeChange(name);
            AttributeValueChangeFactor newChangeFactor = 
                    linkedAttributesChange.calculateAttributeChangeFactor(name, changeFactor.getModificatorValue());
            Attribute attributeToUpdate = action.getAttributes().getAttributeByName(name);
            attributeToUpdate.setValueOnly(newChangeFactor.getNewValue(attributeToUpdate.getAttributeValue()));
        }
    }
}
