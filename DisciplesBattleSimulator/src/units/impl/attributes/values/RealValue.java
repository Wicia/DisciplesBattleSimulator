package units.impl.attributes.values;

import units.api.attributes.AttributeValue;

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