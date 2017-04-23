package units.attributes.impl.models.hitpoints;

import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public class UnitHitPoints extends AbstractAttribute implements Attribute{
    
    public static final String CODE = "hitPoints";
    public static final int DEFAULT_HIT_POINTS = 1;
    
    public UnitHitPoints() {
        this(new NumericValue(DEFAULT_HIT_POINTS));
    }
    
    public UnitHitPoints(AttributeValue value) {
        super(CODE, value);
    }

    @Override
    public void updateValue(AttributeValueChange change, UnitAttributes attributes) {
        AttributeValue newValue = change.getNewValue(this);
        this.setValue(newValue);
        this.updateReferencedAttributes(attributes);
    }
    
    private void updateReferencedAttributes(UnitAttributes attributes){
        AbstractAttribute maxHpAttribute = attributes.getAttributeById(UnitMaxHitPoints.CODE);
        double hitPointsChangeFactor = getHitPointsChangeFactor(maxHpAttribute);
        for(LinkedAttributesDelta factor : LinkedAttributesDelta.values()){
            AbstractAttribute attribute = attributes.getAttributeById(factor.getAttributeId());
            AttributeValueChange attributeChange = factor.getAttributeChange(hitPointsChangeFactor);
            AttributeValue newValue = attributeChange.getNewValue(attribute);
            attribute.setValue(newValue);
        }
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