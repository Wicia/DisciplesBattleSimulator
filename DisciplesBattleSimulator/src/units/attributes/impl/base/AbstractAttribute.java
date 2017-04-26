package units.attributes.impl.base;

import units.attributes.api.AttributeDomain;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public abstract class AbstractAttribute {
    
    private final AttributeName name;
    private AttributeValue value;
    private final LinkedAttributesChange delta;
    private final AttributeDomain domain;
    
    public AbstractAttribute(AttributeName name, AttributeValue value, 
            AttributeDomain domain, LinkedAttributesChange delta) {
        this.name = name;
        this.value = value;
        this.domain = domain;
        this.delta = delta;
    }

    public void setValue(AttributeValue value){
        this.value = value;
    }

    public AttributeName getName() {
        return name;
    }

    public AttributeValue getValue(){
        return this.value;
    }
    
    public LinkedAttributesChange getLinkedAttributesChange(){
        return this.delta;
    }

    public AttributeDomain getDomain() {
        return domain;
    }
    
    public abstract void updateValue(AttributeValueChange change, 
            AttributesCollection attributes);
}
