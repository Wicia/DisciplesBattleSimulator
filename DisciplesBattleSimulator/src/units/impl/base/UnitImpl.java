package units.impl.base;

import java.io.File;
import java.util.Properties;
import units.impl.attributes.base.AttributesCollection;
import units.impl.attributes.utlis.UnitAttributesCreator;

public class UnitImpl extends AbstractUnit{

    public static UnitImpl create(File file) {
        UnitAttributesCreator creator = new UnitAttributesCreator();
        AttributesCollection attributes = creator.load(file);
        return new UnitImpl(attributes);
    }
    
    private UnitImpl(AttributesCollection attributes) {
        super(attributes);
    }
}
