/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.configuration.spring.utils;

import common.spring.AbstractContext;
import database.configuration.spring.resources.PathUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Michał 'Wicia' Wietecha
 */
public class DatabaseContext extends AbstractContext{
    
    public static DatabaseContext get(){
        String resourcesPath = PathUtils.getResourcesPath();
        return new ClassPathXmlApplicationContext(getFullPath(resourcesPath)).
                getBean(DatabaseContext.class);
    }
}