package units.aspects.defense;

import java.util.Arrays;
import java.util.Properties;
import units.aspects.Buff;
import units.aspects.ChangeType;
import units.models.Unit;
import units.aspects.UnitAspect;
import units.aspects.UnitAttribute;
import units.aspects.attack.AttackAction;
import units.enums.AttributeName;

public class DefensiveAspect extends UnitAspect {

    public static final int DEFAULT_PROTECTION_LEVEL = 0;
    public static final int MAX_PROTECTION_LEVEL = 100;
    
    public DefensiveAspect(Unit ref) {
        super(ref);
        initDefaultProtection();
    }
    
    public DefensiveAspect(Unit ref, Properties props) {
        this(ref);
        loadFromProperties(props);
    }
    
    private void loadFromProperties(Properties props){
        AttributeName[] protectionTypes = ProtectionType.values();
        Arrays.asList(protectionTypes).forEach((AttributeName name) -> {
            String propValue = (String) props.get(name.getFullName());
            Integer value = Integer.valueOf(propValue);
            super.addAttribute(new UnitAttribute(name, value));
        });
    }

    private void initDefaultProtection() {
        AttributeName[] protectionTypes = ProtectionType.values();
        Arrays.asList(protectionTypes).forEach((AttributeName name) -> {
            super.addAttribute(new UnitAttribute(name,DEFAULT_PROTECTION_LEVEL));
        });
    }
    
    public int getReducedDamage(AttackAction attackAction) {
        ProtectionType protectionType = ProtectionType.getByAttackSource(
                attackAction.getSource());
        if(isProtectedByBuffs(protectionType)){
            return DEFAULT_PROTECTION_LEVEL;
        }
        int level = getProtectionLevel(protectionType);
        if (level == DEFAULT_PROTECTION_LEVEL) {
            return attackAction.getDamage();
        }
        if (level == MAX_PROTECTION_LEVEL) {
            return 0;
        } 
        else {
            return reduceDamage(attackAction, protectionType);
        }
    }
    
    private boolean isProtectedByBuffs(ProtectionType protectionType){
        Buff positiveBuff = super.getPositiveBuff(protectionType);
        return(positiveBuff != null 
                && ChangeType.WARD.equals(positiveBuff.getChangeType()));
        //TODO: usuwanie buffa
    }
    
    private int reduceDamage(AttackAction action, ProtectionType type){
        return (int) (action.getDamage() * getPecentFactor(type));
    }

    private double getPecentFactor(ProtectionType type) {
        return (100.0 - (getProtectionLevel(type) * 1.0)) / MAX_PROTECTION_LEVEL;
    }

    public Integer getProtectionLevel(ProtectionType type) {
        return (Integer)(super.getAttribute(type).getValue());
    }
}
