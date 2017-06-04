/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.services.impl;

import java.util.Collection;
import java.util.List;
import database.entities.impl.models.UnitSetupModel;

/**
 * Class storing operations on UNITS_SETUP table.
 * 
 * @author Michał 'Wicia' Wietecha
 */
public class UnitSetupService{
    
    private UnitSetupDAO dao;
    
    public UnitSetupService(UnitSetupDAO dao){
        this.dao = dao;
    }
    
    public void addUnit(UnitSetupModel entity){
        this.dao.add(entity);
    }
    
    public UnitSetupModel getUnitByName(String name){
        return this.dao.getByName(name);
    }
    
    public UnitSetupModel getUnitByID(Long id){
        return this.dao.getByID(id);
    }
    
    public List<UnitSetupModel> getAllUnits(Long id){
        return this.dao.getAll();
    }
    
    public void deleteUnit(UnitSetupModel entity){
        this.dao.delete(entity);
    }
    
    public void updateUnit(UnitSetupModel entity){
        this.dao.update(entity);
    }

    public void updateCollectionUnits(Collection<UnitSetupModel> collection) {
        this.dao.updateCollection(collection);
    }
    
    public void deleteCollectionUnits(Collection<UnitSetupModel> collection){
        this.dao.deleteCollection(collection);
    }

    public void addCollectionUnits(Collection<UnitSetupModel> collection) {
        this.dao.addCollection(collection);
    }
}