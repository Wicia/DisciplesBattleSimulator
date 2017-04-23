package units.attributes.impl.base;

import units.attributes.api.AttributeValue;

public class AttributeNumericValue implements AttributeValue<Integer>{

    private final Integer value;

    public AttributeNumericValue(AttributeValue value){
        this.value = (Integer)value.value();
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public Integer getCopy() {
        return this.value();
    }
}