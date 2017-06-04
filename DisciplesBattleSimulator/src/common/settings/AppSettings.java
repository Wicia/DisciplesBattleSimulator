/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common.settings;

import java.util.Properties;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class AppSettings {
    
    private Properties properties;
    
    public AppSettings(){
        this.properties = new Properties();
    }
    
    public void addProperty(String name, Object value){
        this.properties.put(name.toString(), value);
    }
    
    public Object getPropertyValue(String name){
        return this.properties.get(name.toString());
    }
}