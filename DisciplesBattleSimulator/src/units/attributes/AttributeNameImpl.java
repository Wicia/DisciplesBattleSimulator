/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.attributes;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class AttributeNameImpl implements AttributeName{

    private final String name;

    public AttributeNameImpl(String name) {
        this.name = name;
    }
    
    @Override
    public String getFullName() {
        return this.name;
    }
}
