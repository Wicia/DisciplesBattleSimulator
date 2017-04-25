/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.util.Properties;
import units.attributes.impl.models.damage.AttackAction;
import units.attributes.impl.models.damage.AttackSource;
import units.attributes.impl.models.armor.UnitArmor;
import units.attributes.impl.models.hitpoints.UnitHitPoints;
import units.attributes.modificators.impl.AttributeValueChangeImpl;
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
        Properties props = PropertiesUtils.read(new File("src/data/DarkLord.properties"));
        AbstractUnit unit = UnitImpl.create(props);
        UnitArmor armor = (UnitArmor) unit.getAttributes().getAttributeByName(UnitArmor.NAME);
        armor.getReducedDamage(new AttackAction(10, AttackSource.MEELE));
        UnitHitPoints hitPoints = unit.getAttributes().getAttributeByName(UnitHitPoints.NAME);
        AttributeValueChangeImpl<Integer> change = new AttributeValueChangeImpl<>(-100);
        hitPoints.updateValue(change, unit.getAttributes());
    }
}
