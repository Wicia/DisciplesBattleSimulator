/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import utils.PropertiesUtils;
import java.io.File;
import java.util.Properties;
import units.buffs.BuffImpl;
import units.aspects.defense.ProtectionType;
import units.aspects.attack.AttackAction;
import units.aspects.attack.AttackSource;
import units.attributes.AttributeName;
import units.aspects.AspectType;
import units.buffs.Buff;
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
        String buffDescription = "armor/++/50";
        Buff buff = new BuffImpl(buffDescription);
    }
}
