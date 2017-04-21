/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.buffs;

import java.util.List;
import units.attributes.UnitAttribute;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public interface Buff {
    List<UnitAttribute> apply(List<UnitAttribute> attributes);
    int getTurnsDuration();
}
