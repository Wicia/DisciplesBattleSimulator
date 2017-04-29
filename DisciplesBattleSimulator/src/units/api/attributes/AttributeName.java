/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.api.attributes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A653901
 */
public enum AttributeName {
    
       RESIST_WEAPON("resistanceWeapon"), 
              DAMAGE("damage"), 
         DESCRIPTION("description"), 
                NAME("name"), 
          HIT_POINTS("hitPoints"), 
      MAX_HIT_POINTS("maxHitPoints"), 
    ARMOR_DURABILITY("armorDurability");
    
    private final String code;

    private AttributeName(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    
    public static List<AttributeName> filterByDomain(AttributeDomain domain){
        List<AttributeName> result = new ArrayList<>();
        // #TODO: zrobić to bardziej elegancko
        // 
        result.add(AttributeName.RESIST_WEAPON);
        return result;
    }
}
