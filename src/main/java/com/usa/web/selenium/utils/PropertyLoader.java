package com.usa.web.selenium.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static Properties properties = loadProperties();
    private static Logger LOG = Logger.getLogger(PropertyLoader.class.getName());

    private static String getProperty(String key) {
        return properties.getProperty(key);

    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }

    public static String getLoginUrl() {
        return getProperty("login.url");
    }

    public static int getDefaultWait() {
        return Integer.parseInt(getProperty("default.wait"));
    }


    private static Properties loadProperties() {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("application.properties")) {
            prop.load(input);
        } catch (IOException e) {
            LOG.info(e.getMessage());
        }

        return prop;
    }
}
