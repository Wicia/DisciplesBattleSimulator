package units.api.attributes;

public enum UnitType {
    
    WARRIOR("W"),
    RANGER("R"),
    MAGE("M"),
    SUPPORT("S");
    
    private final String description;

    private UnitType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
