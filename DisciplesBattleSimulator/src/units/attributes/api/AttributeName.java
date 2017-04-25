/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.api;

/**
 *
 * @author A653901
 */
public enum AttributeName {
    
     RESIST_WEAPON("armor"), 
            DAMAGE("damage"), 
       DESCRIPTION("description"), 
              NAME("name"), 
        HIT_POINTS("hitPoints"), 
    MAX_HIT_POINTS("maxHitPoints");
    
    private final String code;

    private AttributeName(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
