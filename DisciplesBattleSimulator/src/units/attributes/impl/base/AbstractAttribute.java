package units.attributes.impl.base;

import java.util.ArrayList;
import java.util.List;
import units.attributes.api.AttributeValue;
import units.attributes.modificators.api.AttributeValueChange;

public abstract class AbstractAttribute {
    
    private final String id;
    private AttributeValue value;
    
    private List<AttributeValueChange> positiveBuffs;
    private List<AttributeValueChange> negativeBuffs;

    private void initProperties(){
        this.positiveBuffs = new ArrayList<>();
        this.negativeBuffs = new ArrayList<>();
    }
    
    public AbstractAttribute(String id, AttributeValue value) {
        initProperties();
        this.id = id;
        this.value = value;
    }

    public void setValue(AttributeValue value){
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public AttributeValue getValue(){
        return this.value;
    }
    
    public abstract void updateValue(AttributeValueChange change, 
            UnitAttributes attributes);
}
