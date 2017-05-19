package units.impl.attributes.values;

import units.api.attributes.AttributeValue;

public class NumericValue implements AttributeValue<Integer>{

    private final Integer value;
    private final Integer maxValue;
    private final Integer minValue;

    public NumericValue(Integer value){
        this.value = value;
	this.minValue = null;
	this.maxValue = null;
    }
    
    public NumericValue(Integer value, Integer minValue, Integer maxValue){
        this.value = value;
	this.minValue = minValue;
	this.maxValue = maxValue;
    }

    @Override
    public Integer get() {
        return value;
    }

    @Override
    public Integer copy() {
        return this.get();
    }
    
    @Override
    public Integer getMinValue(){
	return this.minValue;
    }
    
    @Override
    public Integer getMaxValue(){
	return this.maxValue;
    }
}