/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.entities.impl.models;

import database.entities.api.Entity;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class UnitSetupModel implements java.io.Serializable, Entity<Long>{

    private static final long serialVersionUID = 1L;

    private long id;
    private UnitSetupDescriptionModel description;

    public UnitSetupModel() {}

    public UnitSetupModel(long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UnitSetupDescriptionModel getDescription() {
        return description;
    }

    public void setDescription(UnitSetupDescriptionModel description) {
        this.description = description;
    }
}