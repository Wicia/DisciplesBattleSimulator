package units.aspects;

import java.util.HashMap;
import java.util.Map;
import units.models.Unit;
import units.enums.AttributeName;

public abstract class UnitAspect {

    private final Unit unitReference;
    private final Map<String, UnitAttribute> attributes;
    private final Map<AttributeName, Buff> positiveBuffs;
    private final Map<AttributeName, Buff> negativeBuffs;
    
    public UnitAspect(Unit unitReference) {
        this.attributes = new HashMap<>();
        this.unitReference = unitReference;
        this.positiveBuffs = new HashMap<>();
        this.negativeBuffs = new HashMap<>();
    }

    public Unit getUntReference() {
        return unitReference;
    }
    
    public void addAttribute(UnitAttribute attribute){
        this.attributes.put(attribute.getName().getFullName(), attribute);
    }
    
    public UnitAttribute getAttribute(AttributeName name){
        return this.attributes.get(name.getFullName());
    }

    public Buff getNegativeBuff(AttributeName attribute){
        return this.negativeBuffs.get(attribute);
    }
    
    public Buff getPositiveBuff(AttributeName attribute){
        return this.positiveBuffs.get(attribute);
    }
    
    public void addBuff(Buff buff){
        if(BuffType.POSITIVE.equals(buff.getType())){
            this.positiveBuffs.put(buff.getAttributeName(), buff);
        }
        else{
            this.negativeBuffs.put(buff.getAttributeName(), buff);
        }
    }
}