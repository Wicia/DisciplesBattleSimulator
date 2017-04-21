package units.aspects.defense;

import java.util.Arrays;
import java.util.List;
import units.aspects.attack.AttackSource;
import units.attributes.AttributeName;

public enum ProtectionType implements AttributeName{

    ARMOR, 
    FIRE, 
    WATER, 
    AIR, 
    DEATH, 
    POISON, 
    MIND, 
    LIFE, 
    EARTH;
    
    private final String PREFIX = "protection."; 
    
    @Override
    public String getFullName() {
        return PREFIX + this.name();
    }
    
    public static List<AttributeName> getNames() {
        return Arrays.asList(ProtectionType.values());
    }

    public static ProtectionType getByAttackSource(AttackSource source) {
        switch (source) {
            case AIR:
                return ProtectionType.AIR;
            case DEATH:
                return ProtectionType.DEATH;
            case FIRE:
                return ProtectionType.FIRE;
            case MIND:
                return ProtectionType.MIND;
            case LIFE:
                return ProtectionType.LIFE;
            case POISON:
                return ProtectionType.POISON;
            case WATER:
                return ProtectionType.WATER;
            case MEELE:
                return ProtectionType.ARMOR;
            case PROJECTILE:
                return ProtectionType.ARMOR;
            case EARTH:
                return ProtectionType.EARTH;
            default:
                return ARMOR;
        }
    }
}