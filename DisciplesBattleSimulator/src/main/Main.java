/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import utils.PropertiesUtils;
import java.io.File;
import java.util.Properties;
import units.aspects.Buff;
import units.aspects.defense.ProtectionType;
import units.aspects.attack.AttackAction;
import units.aspects.attack.AttackSource;
import units.enums.AttributeName;
import units.models.AspectType;
import units.models.Unit;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Properties props = PropertiesUtils.read(new File("src/data/DarkLord.properties"));
//        Unit mrocznyWladca = Unit.create(props);
//        AttackAction action = new AttackAction(120, AttackSource.MEELE);
//        AttributeName armorAttribute = mrocznyWladca.getDefensive().getAttribute(ProtectionType.ARMOR).getName();
//        Buff buff = Buff.createWardBuff(armorAttribute);
//        mrocznyWladca.getAspect(AspectType.ATTACK).addBuff(buff);
//        int reducedDamage = mrocznyWladca.getDefensive().getReducedDamage(action);
    }
}
