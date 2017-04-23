/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.util.Properties;
import units.models.AbstractUnit;
import units.models.WarriorUnit;
import utils.PropertiesUtils;

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
        AbstractUnit unit = WarriorUnit.create(props);
    }
}
