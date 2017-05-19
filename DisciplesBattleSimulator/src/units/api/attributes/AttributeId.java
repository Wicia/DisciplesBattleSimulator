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
    TYPE(AttributeDomain.DESCRIPTION, "description.type"),
    RACE(AttributeDomain.DESCRIPTION, "description.race"),
    
    HIT_POINTS(AttributeDomain.HIT_POINTS, "resistance.hitPoints"),
    MAX_HIT_POINTS(AttributeDomain.HIT_POINTS, "resistance.maxHitPoints"), 
    RESIST_MEELE(AttributeDomain.RESISTANCE, "resistance.meele"),
    RESIST_ELEMENTAL(AttributeDomain.RESISTANCE, "resistance.elemental"),
    RESIST_PROJECTILE(AttributeDomain.RESISTANCE, "resistance.projectile"),
    RESIST_MIND(AttributeDomain.RESISTANCE, "resistance.mind"),
    
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
