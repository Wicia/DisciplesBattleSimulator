/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.buffs;

public enum ChangeType {

    INCREASE_PECENT("+%"),
    DECREASE_PECENT("-%"),
    INCREASE("++"),
    DECREASE("--"), //ADD("+x"), 
    //REMOVE("-x");
    ;

    private final String symbol;

    private ChangeType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static ChangeType createFromString(String text) {
        for (ChangeType enumType : ChangeType.values()) {
            if (enumType.symbol.equalsIgnoreCase(text)) {
                return enumType;
            }
        }
        return null;
    }
}
