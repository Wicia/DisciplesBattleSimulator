/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.impl.attributes.models.resistances;

import units.api.attributes.Attribute;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.models.resistances.base.AbstractResistance;
import units.impl.attributes.values.NumericValue;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class UnitMindResistance extends AbstractResistance implements Attribute{

    public UnitMindResistance() {
        this(new NumericValue(DEFAULT_RESISTANCE));
    }
    
    public UnitMindResistance(AttributeValue value) {
        super(AttributeId.RESIST_MIND, value);
    }
}
