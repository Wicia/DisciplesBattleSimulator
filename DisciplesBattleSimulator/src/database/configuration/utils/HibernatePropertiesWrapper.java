/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.configuration.utils;

import java.util.Properties;

/**
 * Class wrapping hibernate properties specified in spring-config.xml.
 * 
 * @author Michał 'Wicia' Wietecha
 */
public class HibernatePropertiesWrapper {
    
    private Properties props;
    
    // Properties names
    private static final String batchSize = "hibernate.jdbc.batch_size";
    
    private static final String DATABASE_URL_PREFIX = "jdbc:h2:file:";
    private static final String DATABASE_LOCALIZATION = "/db/game_db";
    private static final String PROPERTY_PROJECT_DIR = "user.dir";
    private static final String ENCODING = "?characterEncoding=UTF-8";

    public HibernatePropertiesWrapper(Properties properties) {
        this.props = properties;
    }
    
    public int getBatchSize(){
        return Integer.valueOf(props.getProperty(batchSize));
    }
    
    public String getDatabaseUrl(){
        String instalationPath = System.getProperty(PROPERTY_PROJECT_DIR);
        return DATABASE_URL_PREFIX + instalationPath 
                + DATABASE_LOCALIZATION + ENCODING;
    }
}