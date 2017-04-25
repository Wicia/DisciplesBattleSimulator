/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.models;

import units.attributes.impl.base.AttributesCollection;

public abstract class AbstractUnit {
    
    private final AttributesCollection attributes;
    
    public AbstractUnit(AttributesCollection attributes) {
        this.attributes = attributes;
    }

    public AttributesCollection getAttributes() {
        return attributes;
    }
}
