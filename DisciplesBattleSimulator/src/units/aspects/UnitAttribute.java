package units.aspects;

import units.enums.AttributeName;

public class UnitAttribute<AttributeValue> {

    private final AttributeName name;
    private final AttributeValue value;

    public UnitAttribute(AttributeName name, AttributeValue value) {
        super();
        this.name = name;
        this.value = value;
    }

    public AttributeName getName() {
        return name;
    }

    public AttributeValue getValue() {
        return value;
    }
}
