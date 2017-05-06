/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.api.attributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author A653901
 */
public enum AttributeId {

    NOTE(AttributeDomain.DESCRIPTION, "description.note"),
    NAME(AttributeDomain.DESCRIPTION, "description.name"),
    
    HIT_POINTS(AttributeDomain.HIT_POINTS, "hitPoints.current"),
    MAX_HIT_POINTS(AttributeDomain.HIT_POINTS, "hitPoints.max"), 
    
    ARMOR_DURABILITY(AttributeDomain.RESISTANCE, "resistance.armorDurability"), 
    RESIST_WEAPON(AttributeDomain.RESISTANCE, "resistance.weapon"),
    RESIST_AIR(AttributeDomain.RESISTANCE, "resistance.air"),
    RESIST_FIRE(AttributeDomain.RESISTANCE, "resistance.fire"),
    RESIST_EARTH(AttributeDomain.RESISTANCE, "resistance.earth"),
    RESIST_WATER(AttributeDomain.RESISTANCE, "resistance.water"),
    
    DAMAGE(AttributeDomain.ATTACK, "attack.damage");
    
    private final String code;
    private final AttributeDomain domain;

    private AttributeId(AttributeDomain domain, String code) {
        this.code = code;
        this.domain = domain;
    }

    public String getCode() {
        return code;
    }

    public AttributeDomain getDomain() {
        return domain;
    }
    
    public static AttributeId getByCode(String code){
        for(AttributeId id : AttributeId.values()){
            if(code.equals(id.getCode())){
                return id;
            }
        }
        
        return null;
    }
    
    public static List<AttributeId> filterByDomain(AttributeDomain domain){
        List<AttributeId> result = new ArrayList<>();
        Arrays.asList(AttributeId.values()).stream().forEach((e) -> {
            if(e.getDomain() == domain) 
                result.add(e);
        });
        return result;
    }
}
