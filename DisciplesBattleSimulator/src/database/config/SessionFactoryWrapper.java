/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.config;

import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Michał 'Wicia' Wietecha
 */
public class SessionFactoryWrapper {

    private static final SessionFactory FACTORY;
    
    private static final String CONFIGURATION_PATH = "src/database/config/data/hibernate.cfg.xml";
    private static final String DATABASE_URL_PREFIX = "jdbc:h2:file:";
    private static final String DATABASE_LOCALIZATION = "/db/game_db";
    private static final String PROPERTY_PROJECT_DIR = "user.dir";
    private static final String PROPERTY_CONNECTION_URL = "hibernate.connection.url";
    
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure(new File(CONFIGURATION_PATH));
	    updateDatabaseUrl(configuration);
            StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
            FACTORY = configuration.buildSessionFactory(registry.build());
        }
        catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    private static void updateDatabaseUrl(Configuration configuration){
        String instalationPath = System.getProperty(PROPERTY_PROJECT_DIR);
        String fullPath = DATABASE_URL_PREFIX + instalationPath + DATABASE_LOCALIZATION;
        configuration.setProperty(PROPERTY_CONNECTION_URL, fullPath);
    }
    
    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }
}