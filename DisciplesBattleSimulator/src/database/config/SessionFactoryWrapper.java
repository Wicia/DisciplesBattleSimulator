/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.config;

import java.io.File;
import org.hibernate.cfg.AnnotationConfiguration;
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
    
    static {
        try {
            Configuration configuration = new Configuration();
            initDatabaseUrl(configuration);
            configuration.configure(new File("src/database/config/data/hibernate.cfg.xml"));
            
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            FACTORY = configuration.buildSessionFactory(ssrb.build());
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    private static void initDatabaseUrl(Configuration configuration){
        String instalationPath = System.getProperty("user.dir");
        String fullPath = "jdbc:h2:file:D:\\db"; // + instalationPath + "/db";
        configuration.setProperty("connection.url", "jdbc:h2:file:D:/db");
        
        // <property name="connection.url">jdbc:h2:file:D:/db</property> <!-- ;IFEXISTS=TRUE -->
    }
    
    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }
}