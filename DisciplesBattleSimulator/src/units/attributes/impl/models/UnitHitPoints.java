package units.attributes.impl.models;

import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.impl.AttributeValueChangeImpl;
import units.attributes.modificators.api.AttributeValueChange;

public class UnitHitPoints extends AbstractAttribute implements Attribute{
    
    public static final String CODE = "hitPoints";
    public static final int DEFAULT_HIT_POINTS = 1;

    private enum DeltaFactor{
        
        ARMOR(UnitArmor.CODE, 0.6), 
        DAMAGE(UnitDamage.CODE, 1.0);
        
        private final String attributeCode;
        private final double conversionValue;

        private DeltaFactor(String attributeCode, double conversionValue) {
            this.attributeCode = attributeCode;
            this.conversionValue = conversionValue;
        }

        public String getAttributeId() {
            return attributeCode;
        }

        private AttributeValueChange getAttributeChange(double attributeChangeFactor) {
            double finalfactor = conversionValue * attributeChangeFactor;
            return new AttributeValueChangeImpl(finalfactor);
        }
    }
    
    public UnitHitPoints() {
        this(new NumericValue(DEFAULT_HIT_POINTS));
    }
    
    public UnitHitPoints(AttributeValue value) {
        super(CODE, value);
    }

    //TODO: !!! gdzie powinien byc widoczny update atrybutu w zbiorze? !!!
    @Override
    public void updateValue(AttributeValueChange change, UnitAttributes attributes) {
        AbstractAttribute result = change.apply(this);
        this.updateReferencedAttributes(attributes);
    }
    
    private void updateReferencedAttributes(UnitAttributes attributes){
        AbstractAttribute maxHpAttribute = attributes.getAttributeById(UnitMaxHitPoints.CODE);
        double hitPointsChangeFactor = getHitPointsChangeFactor(maxHpAttribute);
        for(DeltaFactor factor : DeltaFactor.values()){
            AbstractAttribute attribute = attributes.getAttributeById(factor.attributeCode);
            AttributeValueChange attributeChange = factor.getAttributeChange(hitPointsChangeFactor);
            attributeChange.apply(attribute);
        }
    }
    
    private double getHitPointsChangeFactor(AbstractAttribute attribute){
        AttributeValue<Integer> maxHpValue = attribute.getValue();
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