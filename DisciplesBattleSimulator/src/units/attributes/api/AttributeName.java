/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.attributes.api;

import java.util.ArrayList;
import java.util.List;
import units.attributes.impl.base.AttributesCollection;

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
         ARMOR_CLASS("armorClass");
    
    private final String code;

    private AttributeName(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    
    public static List<AttributeName> filterByDomain(AttributesCollection attributes, 
            AttributeDomain domain){
        List<AttributeName> result = new ArrayList<>();
        attributes.getAttributes().stream().filter((attribute) -> (
                domain.equals(attribute.getDomain()))).forEachOrdered((attribute) -> {
            result.add(attribute.getName());
           });
        return result;
    }
}
