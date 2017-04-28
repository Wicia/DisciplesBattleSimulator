/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.util.Properties;
import units.actions.api.ActionType;
import units.actions.impl.ChangeAttributesValuesAction;
import units.attributes.api.AttributeName;
import units.attributes.impl.models.damage.AttackAction;
import units.attributes.impl.models.damage.AttackSource;
import units.attributes.impl.models.armor.UnitResistanceWeapon;
import units.attributes.impl.models.hitpoints.UnitHitPoints;
import units.attributes.impl.modificators.impl.AttributeValueChangeFactorImpl;
import units.models.AbstractUnit;
import units.models.UnitImpl;
import units.utils.PropertiesUtils;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UnitImpl unit = loadUnit();
        getAction(unit);
    }
    
    private static UnitImpl loadUnit(){
        Properties props = PropertiesUtils.read(new File("src/units/data/DarkLord.properties"));
        return UnitImpl.create(props);
    }
    
    private static void getAction(UnitImpl unit){
        
    }
}
