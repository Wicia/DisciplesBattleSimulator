package units.impl.attributes.base;

import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.api.modificators.AttributeValueChangeFactor;
import units.api.modificators.LinkedAttributes;
import units.impl.attributes.modificators.LinkedAttributesImpl;


public abstract class AbstractSimpleAttribute extends AbstractAttribute{

    public AbstractSimpleAttribute(AttributeId id, AttributeValue value) {
        super(id, value);
    }
    
    @Override
    public LinkedAttributes getLinkedAttributes(){
        return new LinkedAttributesImpl();
    }
    
    public void updateReferencedAttributes(AttributesCollection attributes, 
            AttributeValueChangeFactor mainAttributeChangeFactor){
        // DO NOTHING
    }
}
