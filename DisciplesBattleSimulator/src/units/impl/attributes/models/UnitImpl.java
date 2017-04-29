package units.impl.attributes.models;

import java.util.Properties;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.utlis.UnitAttributesCreator;

public class UnitImpl extends AbstractUnit{

    public static UnitImpl create(Properties props) {
        UnitAttributesCreator creator = new UnitAttributesCreator();
        AttributesCollection attributes = creator.load(props);
        return new UnitImpl(attributes);
    }
    
    private UnitImpl(AttributesCollection attributes) {
        super(attributes);
    }
}
