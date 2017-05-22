/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.services.descriptions;

import java.util.Collection;
import java.util.List;
import database.entities.description.Unit;

/**
 * Class storing operations on UNITS table.
 * 
 * @author Michał 'Wicia' Wietecha
 */
public class UnitService{
    
    private UnitDAO dao;
    
    public UnitService(UnitDAO dao){
        this.dao = dao;
    }
    
    public void addUnit(Unit entity){
        this.dao.add(entity);
    }
    
    public Unit getUnitByName(String name){
        return this.dao.getByName(name);
    }
    
    public Unit getUnitByID(Long id){
        return this.dao.getByID(id);
    }
    
    public List<Unit> getAllUnits(Long id){
        return this.dao.getAll();
    }
    
    public void deleteUnit(Unit entity){
        this.dao.delete(entity);
    }
    
    public void updateUnit(Unit entity){
        this.dao.update(entity);
    }

    public void updateCollectionUnits(Collection<Unit> collection) {
        this.dao.updateCollection(collection);
    }
    
    public void deleteCollectionUnits(Collection<Unit> collection){
        this.dao.deleteCollection(collection);
    }

    public void addCollectionUnits(Collection<Unit> collection) {
        this.dao.addCollection(collection);
    }
}