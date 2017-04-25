package units.models;

import java.util.Properties;
import units.attributes.impl.base.UnitAttributes;
import units.attributes.impl.utlis.UnitAttributesCreator;

public class UnitImpl extends AbstractUnit{

    public static AbstractUnit create(Properties props) {
        UnitAttributesCreator creator = new UnitAttributesCreator();
        UnitAttributes attributes = creator.load(props);
        return new UnitImpl(attributes);
    }
    
    private UnitImpl(UnitAttributes attributes) {
        super(attributes);
    }
}
