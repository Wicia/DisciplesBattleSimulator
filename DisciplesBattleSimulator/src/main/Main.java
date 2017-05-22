/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.config.SessionFactoryWrapper;
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
        SessionFactory sessionFactory = SessionFactoryWrapper.getSessionFactory();
        
        //UnitImpl unit = loadUnit();
        //getAction(unit);
        
        sessionFactory.close();
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
