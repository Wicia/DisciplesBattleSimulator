/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.entities.impl.models;

/**
 * @TODO: Add description to: class, fields, methods
 * @author Michał 'Wicia' Wietecha
 */
public class UnitSetupDescriptionModel {
    
    private long id;
    private String name;
    private String note;
    private String race;
    private String type;
    
    private UnitSetupModel unit;

    public UnitSetupDescriptionModel(){}
    
    public UnitSetupDescriptionModel(String name, String note, String race, String type) {
        this.name = name;
        this.note = note;
        this.race = race;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UnitSetupModel getUnit() {
        return unit;
    }

    public void setUnit(UnitSetupModel unit) {
        this.unit = unit;
    }
}
