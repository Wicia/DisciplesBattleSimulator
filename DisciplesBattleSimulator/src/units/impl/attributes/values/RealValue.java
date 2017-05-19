package units.impl.attributes.values;

import units.api.attributes.AttributeValue;

public class RealValue implements AttributeValue<Double>{

    private final Double value;
    private final Double maxValue;
    private final Double minValue;

    public RealValue(Double value){
        this.value = value;
	this.minValue = null;
	this.maxValue = null;
    }
    
    public RealValue(Double value, Double minValue, Double maxValue){
        this.value = value;
	this.minValue = minValue;
	this.maxValue = maxValue;
    }

    @Override
    public Double get() {
        return value;
    }

    @Override
    public Double copy() {
        return this.get();
    }

    @Override
    public Double getMinValue(){
	return this.minValue;
    }
    
    @Override
    public Double getMaxValue(){
	return this.maxValue;
    }
}