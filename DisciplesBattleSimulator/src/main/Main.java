/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.configuration.spring.utils.DatabaseContext;
import database.entities.impl.models.UnitSetupModel;
import database.entities.impl.models.UnitSetupDescriptionModel;
import database.services.impl.UnitSetupService;
import java.io.File;
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
        
        UnitSetupService service = (UnitSetupService) DatabaseContext.get().getBean(UnitSetupService.class);
        service.addUnit(setup);
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
