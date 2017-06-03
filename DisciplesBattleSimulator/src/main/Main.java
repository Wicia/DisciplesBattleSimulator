/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.config.SessionFactoryUtils;
import database.entities.impl.models.UnitSetupModel;
import database.entities.impl.models.UnitSetupDescriptionModel;
import database.services.descriptions.UnitSetupService;
import java.io.File;
import org.hibernate.SessionFactory;
import units.impl.base.AbstractUnit;
import units.impl.base.UnitImpl;

/**
 *
 * @author Michał 'Wicia' Wietecha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UnitSetupModel setup = new UnitSetupModel();
        UnitSetupDescriptionModel desc = new UnitSetupDescriptionModel();
        desc.setName("Mroczny Władca");
        desc.setNote("W nagrodę za dobrą służbę, Mortis daje swoim Mrocznym Władcom moc kontrolowania żywiołów");
        desc.setRace("U");
        desc.setType("W");
        setup.setDescription(desc);
        UnitSetupService.getService().addUnit(setup);
    }
    
    private static UnitImpl loadUnit(){
        return UnitImpl.create(new File("src/units/data/DarkLord.properties"));
    }
    
    private static void getAction(UnitImpl unit){
        AbstractUnit loadUnit = loadUnit();
        loadUnit.applyAction(unit.createAction());
        loadUnit.test();
    }
}
