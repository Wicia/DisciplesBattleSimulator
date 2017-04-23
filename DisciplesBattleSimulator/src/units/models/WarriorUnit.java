package units.models;

import java.util.Properties;
import units.attributes.impl.base.UnitAttributes;
import units.attributes.impl.utlis.UnitAttributesCreator;

public class WarriorUnit extends AbstractUnit{

    public static AbstractUnit create(Properties props) {
        UnitAttributesCreator creator = new UnitAttributesCreator();
        UnitAttributes attributes = creator.load(props);
        return new WarriorUnit(attributes);
    }
    
    private WarriorUnit(UnitAttributes attributes) {
        super(attributes);
    }
}
