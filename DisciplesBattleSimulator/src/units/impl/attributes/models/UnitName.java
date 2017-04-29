package units.impl.attributes.models;

import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeDomain;
import units.api.attributes.AttributeName;
import units.api.attributes.AttributeValue;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.TextValue;


public class UnitName extends AbstractAttribute implements Attribute{
    
    public static final AttributeName NAME = AttributeName.NAME;
    public static final String DEFAULT_NAME = "NaN";
    
    public UnitName() {
        this(new TextValue(DEFAULT_NAME));
    }
    
    public UnitName(AttributeValue value) {
        super(NAME, value, AttributeDomain.DESCRIPTION, null);
    }

    @Override
    public void updateValue(ChangeAttributesValuesAction action) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateValue(AttributesCollection attributes, AttributeValue newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
