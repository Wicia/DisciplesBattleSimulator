package units.impl.attributes.values;

import units.api.attributes.AttributeValue;

public class NumericValue implements AttributeValue<Integer>{

    private final Integer value;

    public NumericValue(Integer value){
        this.value = value;
    }

    @Override
    public Integer get() {
        return value;
    }

    @Override
    public Integer copy() {
        return this.get();
    }
}