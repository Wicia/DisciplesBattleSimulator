package units.attributes.impl.base;

import java.util.ArrayList;
import java.util.List;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public abstract class AbstractAttribute {
    
    private final AttributeName name;
    private AttributeValue value;
    private final LinkedAttributesChange delta;
    
    private List<AttributeValueChange> positiveBuffs;
    private List<AttributeValueChange> negativeBuffs;

    private void initProperties(){
        this.positiveBuffs = new ArrayList<>();
        this.negativeBuffs = new ArrayList<>();
    }
    
    public AbstractAttribute(AttributeName name, AttributeValue value, 
            LinkedAttributesChange delta) {
        initProperties();
        this.name = name;
        this.value = value;
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
    
    public abstract void updateValue(AttributeValueChange change, 
            AttributesCollection attributes);
}
