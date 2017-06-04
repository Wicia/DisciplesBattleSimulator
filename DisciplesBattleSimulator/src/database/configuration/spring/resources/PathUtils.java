/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.configuration.spring.resources;

/**
 * @author Michał 'Wicia' Wietecha
 */
public class PathUtils {
    public static String getResourcesPath(){
        return PathUtils.class.getPackage().getName().replace(".", "\\");
    }
}
