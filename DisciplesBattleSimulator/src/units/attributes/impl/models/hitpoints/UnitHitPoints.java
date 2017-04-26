package units.attributes.impl.models.hitpoints;

import java.util.Set;
import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

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
    public void updateValue(AttributeValueChange change, AttributesCollection attributes) {
        AttributeValue newValue = change.getNewValue(this);
        this.setValue(newValue);
        this.updateReferencedAttributes(attributes);
    }
    
    private void updateReferencedAttributes(AttributesCollection attributes){
        AbstractAttribute maxHpAttribute = attributes.getAttributeByName(UnitMaxHitPoints.NAME);
        double hitPointsChangeFactor = getHitPointsChangeFactor(maxHpAttribute);
        LinkedAttributesChange linkedAttributesChange = super.getLinkedAttributesChange();
        Set<AttributeName> linkedAttributesNames = linkedAttributesChange.getLinkedAttributesNames();
        linkedAttributesNames.stream().forEach((name) -> {
            AbstractAttribute attribute = attributes.getAttributeByName(name);
            AttributeValueChange attributeChange = linkedAttributesChange.getAttributeChange(name, hitPointsChangeFactor);
            AttributeValue newValue = attributeChange.getNewValue(attribute);
            attribute.setValue(newValue);
        });
    }
    
    private double getHitPointsChangeFactor(AbstractAttribute maxHitPointsAttribute){
        AttributeValue<Integer> maxHpValue = maxHitPointsAttribute.getValue();
        int maxHp = maxHpValue.value();
        int curentHitPoints = this.getSimpleValue();
        double factor = (curentHitPoints * 100.0) / (maxHp * 1.0);
        if(curentHitPoints < maxHp){
            factor *= (-1.0);
        }
        
        return factor;
    }

    @Override
    public Integer getSimpleValue() {
        return (Integer) super.getValue().value();
    }
}