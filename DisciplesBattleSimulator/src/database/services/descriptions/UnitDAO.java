/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.services.descriptions;

import java.util.Collection;
import org.hibernate.SessionFactory;
import database.common.INameDAO;
import database.entities.description.Unit;
import database.services.common.Batcher;
import database.services.common.DAOBase;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class UnitDAO extends DAOBase<Unit> implements INameDAO<Long, Unit> {

    public UnitDAO(SessionFactory factory, Class clazz, Batcher batcher) {
        super(factory, clazz, batcher);
    }

    @Override
    public Unit getByID(Long id) {
        return super.get(id, "findDescriptionByID");
    }

    @Override
    public Unit getByName(String name){
        return super.getByName(name, "name", "findDescriptionByName");
    }

    @Override
    public Collection<Unit> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}