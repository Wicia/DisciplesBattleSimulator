package units.models;

import units.aspects.AspectType;
import java.util.Map;
import java.util.Properties;
import units.aspects.UnitAspect;

public class Unit extends UnitCore{

    public static Unit create(Properties properties){
        Unit unit = new Unit();
        //unit.defensive = new DefensiveAspect(unit, properties);
        return unit;
    }
    
    private Map<AspectType, UnitAspect> aspects;

    private Unit(){}

    public UnitAspect getAspect(AspectType type) {
        return aspects.get(type);
    }
}
