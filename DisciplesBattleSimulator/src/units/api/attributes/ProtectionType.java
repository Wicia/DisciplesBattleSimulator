package units.api.attributes;

public enum ProtectionType {

    ARMOR, 
    FIRE, 
    WATER, 
    AIR, 
    DEATH, 
    POISON, 
    MIND, 
    LIFE, 
    EARTH;

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