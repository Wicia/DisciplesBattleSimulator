package units.attributes.impl.base;

import units.attributes.api.AttributeValue;

public class TextValue implements AttributeValue<String>{

    private final String value;

    public TextValue(String text){
        this.value = text;
    }

    @Override
    public String get() {
        return value;
    }

    @Override
    public String copy() {
        return this.get();
    }
}