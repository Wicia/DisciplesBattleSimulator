package units.impl.attributes.values;

import units.api.attributes.AttributeValue;

public class TextValue implements AttributeValue<String>{

    private final String value;

    public TextValue(String value){
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }

    @Override
    public String copy() {
        return this.get();
    }

    @Override
    public String getMinValue() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getMaxValue() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
}