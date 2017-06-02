/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units.api.attributes;

import units.impl.attributes.base.AttributesCollection;

public interface AttributeValueChangeGenerator {
    double getNewAttributeValueChange(AttributesCollection attributes);
}
