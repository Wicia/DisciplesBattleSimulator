package units.impl.attributes.models.resistances;

import units.impl.attributes.models.resistances.base.AbstractResistance;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.values.RealValue;


public class UnitResistanceAir extends AbstractResistance implements Attribute{
    
    public static final AttributeId NAME = AttributeId.RESIST_AIR;
    
    public UnitResistanceAir() {
        this(new RealValue(DEFAULT_RESISTANCE));
    }
    
    public UnitResistanceAir(AttributeValue value) {
        super(NAME, value);
    }
}