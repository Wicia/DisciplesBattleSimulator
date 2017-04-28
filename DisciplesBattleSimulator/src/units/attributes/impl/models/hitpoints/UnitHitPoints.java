package units.attributes.impl.models.hitpoints;

import java.util.Set;
import units.actions.impl.ChangeAttributesValuesAction;
import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.impl.modificators.api.AttributeValueChangeFactor;


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
    public void updateValue(ChangeAttributesValuesAction action) {
        this.setValueOnly(action.getAttributeChange(NAME).getNewValue(getAttributeValue()));
        this.updateReferencedAttributes(action);
    }
    
    private void updateReferencedAttributes(ChangeAttributesValuesAction action){
        LinkedAttributesChange linkedAttributesChange = super.getLinkedAttributesChange();
        Set<AttributeName> linkedAttributesNames = linkedAttributesChange.getLinkedAttributesNames();
        linkedAttributesNames.stream().forEach((name) -> {
            AttributeValueChangeFactor changeFactor = action.getAttributeChange(name);
            //TODO
        });
    }
    
    private AttributeValue getHitPointsChangeFactor(Attribute maxHitPointsAttribute){
        AttributeValue<Integer> maxHpValue = maxHitPointsAttribute.getAttributeValue();
        int maxHp = maxHpValue.get();
        int curentHitPoints = (int) getAttributeValue().get();
        double factor = (curentHitPoints * 100.0) / (maxHp * 1.0);
        if(curentHitPoints < maxHp){
            factor *= (-1.0);
        }
        
        return new RealValue(factor);
    }
}