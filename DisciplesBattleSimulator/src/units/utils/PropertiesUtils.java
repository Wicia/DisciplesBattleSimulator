package units.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//TODO: pomysl - kazda jednostka = plik property zakodowany i zapisany w bazie
public class PropertiesUtils {

    public static Properties read(File file) {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(file);
            prop.load(input);
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        } 
        finally {
            close(input);
        }

        return prop;
    }

    private static void close(InputStream input) {
        if (input != null) {
            try {
                input.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
