package org.FEB17.utils;

import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MailConfigService {
    ConfigReader configReader = new ConfigReader();

    public String getSubject(){
        return configReader.getProperty("subject");

    }
    public String getBody(){
        return configReader.getProperty("body");
    }



}
