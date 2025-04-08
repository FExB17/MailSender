package org.FEB17.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    FileReader file;

    {
        try {
            file = new FileReader("src/main/resources/config.properties");
            properties.load(file);
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }


    public String getProperty(String key){
        return properties.getProperty(key);
    }


}
