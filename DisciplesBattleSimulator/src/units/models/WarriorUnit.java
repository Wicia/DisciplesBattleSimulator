package units.models;

import java.util.Properties;

public class WarriorUnit extends AbstractUnit{

    public static WarriorUnit create(Properties properties){
        return new WarriorUnit(properties);
    }

    private WarriorUnit(Properties properties){
        super(properties);
    }
}
