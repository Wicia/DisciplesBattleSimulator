//package unused;
//
//import java.util.Arrays;
//import java.util.Properties;
//import units.buffs.BuffImpl;
//import units.buffs.ChangeType;
//import units.models.Unit;
//import unused.UnitAspect;
//import units.attributes.impl.base.AbstractAttribute;
//import units.aspects.attack.AttackAction;
//import units.aspects.defense.ProtectionType;
//import units.attributes.api.AttributeId;
//
//public class DefensiveAspect extends UnitAspect {
//
//    public static final int DEFAULT_PROTECTION_LEVEL = 0;
//    public static final int MAX_PROTECTION_LEVEL = 100;
//    
//    public DefensiveAspect(Unit ref) {
//        super(ref);
//        initDefaultProtection();
//    }
//    
//    public DefensiveAspect(Unit ref, Properties props) {
//        this(ref);
//        loadFromProperties(props);
//    }
//    
//    private void loadFromProperties(Properties props){
//        AttributeId[] protectionTypes = ProtectionType.values();
//        Arrays.asList(protectionTypes).forEach((AttributeId name) -> {
//            String propValue = (String) props.get(name.getFullName());
//            Integer value = Integer.valueOf(propValue);
//            super.addAttribute(new AbstractAttribute(name, value));
//        });
//    }
//
//    private void initDefaultProtection() {
//        AttributeId[] protectionTypes = ProtectionType.values();
//        Arrays.asList(protectionTypes).forEach((AttributeId name) -> {
//            super.addAttribute(new AbstractAttribute(name,DEFAULT_PROTECTION_LEVEL));
//        });
//    }
//    
//    public int getReducedDamage(AttackAction attackAction) {
//        ProtectionType protectionType = ProtectionType.getByAttackSource(
//                attackAction.getSource());
//        if(isProtectedByBuffs(protectionType)){
//            return DEFAULT_PROTECTION_LEVEL;
//        }
//        int level = getProtectionLevel(protectionType);
//        if (level == DEFAULT_PROTECTION_LEVEL) {
//            return attackAction.getDamage();
//        }
//        if (level == MAX_PROTECTION_LEVEL) {
//            return 0;
//        } 
//        else {
//            return reduceDamage(attackAction, protectionType);
//        }
//    }
//    
//    private boolean isProtectedByBuffs(ProtectionType protectionType){
//        return false;
//    }
//    
//    private int reduceDamage(AttackAction action, ProtectionType type){
//        return (int) (action.getDamage() * getPecentFactor(type));
//    }
//
//    private double getPecentFactor(ProtectionType type) {
//        return (100.0 - (getProtectionLevel(type) * 1.0)) / MAX_PROTECTION_LEVEL;
//    }
//
//    public Integer getProtectionLevel(ProtectionType type) {
//        return (Integer)(super.getAttribute(type).getValue());
//    }
//}
