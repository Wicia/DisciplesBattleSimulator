/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.util.Properties;
import units.api.actions.ActionType;
import units.impl.actions.ChangeAttributesValuesAction;
import units.api.attributes.AttributeId;
import units.api.attributes.AttributeValue;
import units.impl.attributes.values.NumericValue;
import units.impl.attributes.values.RealValue;
import units.impl.attributes.models.damage.AttackAction;
import units.api.attributes.AttackSource;
import units.impl.attributes.models.armor.UnitResistanceWeapon;
import units.impl.attributes.models.hitpoints.UnitHitPoints;
import units.api.modificators.AttributeValueChangeFactor;
import units.impl.attributes.modificators.AttributeValueChangeFactorImpl;
import units.impl.base.AbstractUnit;
import units.impl.base.UnitImpl;
import units.impl.utils.PropertiesUtils;

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
        AbstractUnit loadUnit = loadUnit();
        loadUnit.applyAction(unit.createAction());
        loadUnit.test();
    }
}
