/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.services.impl;

import java.util.Collection;
import org.hibernate.SessionFactory;
import database.services.common.INameDAO;
import database.entities.impl.models.UnitSetupModel;
import database.services.common.Batcher;
import database.services.common.DAOBase;

/**
 * @author Michał 'Wicia' Wietecha
 */
public class UnitSetupDAO extends DAOBase<UnitSetupModel> 
        implements INameDAO<Long, UnitSetupModel> {

    public UnitSetupDAO(SessionFactory factory, Batcher batcher) {
        super(factory, UnitSetupModel.class, batcher);
    }

    @Override
    public UnitSetupModel getByID(Long id) {
        return super.get(id, "findDescriptionByID");
    }

    @Override
    public UnitSetupModel getByName(String name){
        return super.getByName(name, "name", "findDescriptionByName");
    }

    @Override
    public Collection<UnitSetupModel> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}