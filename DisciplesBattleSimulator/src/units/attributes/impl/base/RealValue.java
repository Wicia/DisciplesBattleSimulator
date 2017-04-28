package units.attributes.impl.base;

import units.attributes.api.AttributeValue;

public class RealValue implements AttributeValue<Double>{

    private final Double value;

    public RealValue(Double value){
        this.value = value;
    }

    @Override
    public Double get() {
        return value;
    }

    @Override
    public Double copy() {
        return this.get();
    }
}