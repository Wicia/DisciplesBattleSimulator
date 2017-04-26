package units.attributes.impl.models.armor;

import units.attributes.impl.base.*;
import units.attributes.api.Attribute;
import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public class UnitArmorClass extends AbstractAttribute implements Attribute{
    
    public static final AttributeName NAME = AttributeName.ARMOR_CLASS;
    public static final ArmorClass DEFAULT_CLASS = ArmorClass.C1;
    
    public enum ArmorClass {

        C1(0.1),
        C2(C1.factor / 2),
        C3(C2.factor / 2),
        C4(C3.factor / 2),
        C5(C4.factor / 2);

        private final double factor;

        private ArmorClass(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }
    
    public UnitArmorClass() {
        this(new TextValue(DEFAULT_CLASS.name()));
    }
    
    public UnitArmorClass(AttributeValue<String> value) {
        super(NAME, value, AttributeDomain.PROTECTION, new LinkedAttributesChangeImpl());
    }

    @Override
    public AttributeValue getSimpleValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateValue(AttributeValueChange change, AttributesCollection attributes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
