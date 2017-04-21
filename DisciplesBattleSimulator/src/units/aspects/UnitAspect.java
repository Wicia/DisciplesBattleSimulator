package units.aspects;

import units.attributes.UnitAttribute;
import units.buffs.BuffType;
import units.buffs.BuffImpl;
import java.util.HashMap;
import java.util.Map;
import units.models.Unit;
import units.attributes.AttributeName;

public abstract class UnitAspect {

    private final Unit unitReference;
    private final Map<String, UnitAttribute> attributes;
    private final Map<AttributeName, BuffImpl> positiveBuffs;
    private final Map<AttributeName, BuffImpl> negativeBuffs;
    
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

    public BuffImpl getNegativeBuff(AttributeName attribute){
        return this.negativeBuffs.get(attribute);
    }
    
    public BuffImpl getPositiveBuff(AttributeName attribute){
        return this.positiveBuffs.get(attribute);
    }
    
    public void addBuff(BuffImpl buff){
        
    }
}