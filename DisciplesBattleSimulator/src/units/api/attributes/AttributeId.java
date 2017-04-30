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

    RESIST_WEAPON(AttributeDomain.RESISTANCE, "resistance.weapon"),
    DAMAGE(AttributeDomain.ATTACK, "attack.damage"),
    NOTE(AttributeDomain.DESCRIPTION, "description.note"),
    NAME(AttributeDomain.DESCRIPTION, "description.name"),
    HIT_POINTS(AttributeDomain.HIT_POINTS, "hitPoints.current"),
    MAX_HIT_POINTS(AttributeDomain.HIT_POINTS, "hitPoints.max"), 
    ARMOR(AttributeDomain.RESISTANCE, "resistance.armor");
    
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
    
    public static List<AttributeId> filterByDomain(AttributeDomain domain){
        List<AttributeId> result = new ArrayList<>();
        Arrays.asList(AttributeId.values()).stream().forEach((e) -> {
            if(e.getDomain() == domain) 
                result.add(e);
        });
        return result;
    }
}
