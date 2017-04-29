package units.impl.attributes.models.hitpoints;

import java.util.Set;
import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeDomain;
import units.api.attributes.AttributeName;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;
import units.api.modificators.LinkedAttributesChange;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.NumericValue;


public class UnitHitPoints extends AbstractAttribute implements Attribute{
    
    public static final AttributeName NAME = AttributeName.HIT_POINTS;
    public static final int DEFAULT_HIT_POINTS = 1;
    
    public UnitHitPoints() {
        this(new NumericValue(DEFAULT_HIT_POINTS));
    }
    
    public UnitHitPoints(AttributeValue value) {
        super(NAME, value, AttributeDomain.HIT_POINTS, new LinkedAttributesChangeImpl());
    }

    @Override
    public void updateValue(AttributesCollection attributes, AttributeValue newValue){
        
    }
    
    @Override
    public void updateValue(ChangeAttributesValuesAction action) {
        AttributeValueChangeFactor attributeChange = action.getAttributeChange(NAME);
        AttributeValue newValue = attributeChange.getNewValue(getAttributeValue());
        AttributeValueChangeFactor hpChangeFactor = super.getLinkedAttributesChange().
                getPecentageChangeFactor(getAttributeValue(), newValue);
        this.setValueOnly(attributeChange.getNewValue(getAttributeValue()));
        this.updateReferencedAttributes(action.getAttributes(), hpChangeFactor);
    }
    
    private void updateReferencedAttributes(AttributesCollection attributes, AttributeValueChangeFactor hpChangeFactor){
        LinkedAttributesChange linkedAttributesChange = super.getLinkedAttributesChange();
        Set<AttributeName> linkedAttributesNames = linkedAttributesChange.getLinkedAttributesNames();
        linkedAttributesNames.stream().forEach((name) -> {
            AttributeValueChangeFactor linkedAttributeChangeFactor = 
                linkedAttributesChange.calculateAttributeChangeFactor(name, hpChangeFactor);
            Attribute linkedAttribute = attributes.getAttributeByName(name);
            AttributeValue attributeValue = linkedAttribute.getAttributeValue();
            AttributeValue newValue = linkedAttributeChangeFactor.getNewValue(attributeValue);
            linkedAttribute.updateValue(attributes, newValue);
        });
    }
}