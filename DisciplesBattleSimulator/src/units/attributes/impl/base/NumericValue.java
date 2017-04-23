package units.attributes.impl.base;

import units.attributes.api.AttributeValue;

public class NumericValue implements AttributeValue<Integer>{

    private final Integer value;

    public NumericValue(Integer value){
        this.value = value;
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