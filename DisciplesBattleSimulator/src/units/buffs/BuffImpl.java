/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.buffs;

import java.util.List;
import units.attributes.UnitAttribute;
import units.attributes.AttributeName;

public class BuffImpl implements Buff{
    
    private final BuffProperties attributes;

    public BuffImpl(String buffDescription){
        BuffAttributesCreator creator = new BuffAttributesCreator(buffDescription);
        this.attributes = creator.getAttributes();
    }
    
    @Override
    public List<UnitAttribute> apply(List<UnitAttribute> attributes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getTurnsDuration() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
