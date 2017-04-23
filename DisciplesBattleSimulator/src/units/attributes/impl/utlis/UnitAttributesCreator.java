/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.attributes.impl.utlis;

import java.util.HashMap;
import java.util.Map;
import units.attributes.impl.base.AbstractAttribute;
import units.attributes.impl.base.UnitAttributes;
import units.attributes.impl.models.UnitArmor;
import units.attributes.impl.models.UnitDescription;
import units.attributes.impl.models.UnitHitPoints;
import units.attributes.impl.models.UnitName;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class UnitAttributesCreator {
    
    private Map<String, AbstractAttribute> possibleAttributes;

    public UnitAttributesCreator() {
        this.initProperties();
        this.saveDefaultImplementations();
    }
    
    private void initProperties(){
        this.possibleAttributes = new HashMap<>();
    }
    
    private void saveDefaultImplementations() {
        UnitAttributes attributes = new UnitAttributes();
        this.addDefaultAttribute(new UnitName());
        this.addDefaultAttribute(new UnitArmor());
        this.addDefaultAttribute(new UnitDescription());
        this.addDefaultAttribute(new UnitHitPoints());
    }
    
    private void addDefaultAttribute(AbstractAttribute attribute){
        //this.possibleAttributes.put(attribute.getId(), attribute);
    }
}
