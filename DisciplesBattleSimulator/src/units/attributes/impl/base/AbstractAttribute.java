package units.attributes.impl.base;

import java.util.ArrayList;
import java.util.List;
import units.attributes.api.AttributeName;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public abstract class AbstractAttribute {
    
    private final AttributeName name;
    private AttributeValue value;
    
    private List<AttributeValueChange> positiveBuffs;
    private List<AttributeValueChange> negativeBuffs;

    private void initProperties(){
        this.positiveBuffs = new ArrayList<>();
        this.negativeBuffs = new ArrayList<>();
    }
    
    public AbstractAttribute(AttributeName name, AttributeValue value) {
        initProperties();
        this.name = name;
        this.value = value;
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
    
    public abstract void updateValue(AttributeValueChange change, 
            AttributesCollection attributes);
}
