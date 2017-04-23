/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.models;

import units.attributes.impl.base.UnitAttributes;

public abstract class AbstractUnit {
    
    private final UnitAttributes attributes;
    
    public AbstractUnit(UnitAttributes attributes) {
        this.attributes = attributes;
    }

    public UnitAttributes getAttributes() {
        return attributes;
    }
}
