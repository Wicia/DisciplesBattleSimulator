package units.impl.attributes.models.description;

import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.Attribute;
import units.api.attributes.AttributeDomain;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.base.AbstractAttribute;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.values.TextValue;

public class UnitNote extends AbstractAttribute implements Attribute{
    
    public static final AttributeId NAME = AttributeId.NOTE;
    public static final String DEFAULT_DESC = "NaN";
    
    public UnitNote() {
        this(new TextValue(DEFAULT_DESC));
    }
    
    public UnitNote(AttributeValue value) {
        super(NAME, value, null);
    }

    @Override
    public void updateWithAction(AttributesCollection attributes, ChangeAttributesValuesAction action) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(AttributesCollection attributes, AttributeValue newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}