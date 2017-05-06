package units.api.attributes;

public enum UnitRace {
    
    IMPERIUM("I"), 
    ELVES("E"),
    UNDEAD("U"),
    LEGIONS("L"),
    CLANS("C");
    
    private final String description;

    private UnitRace(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
