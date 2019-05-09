package com.lukebusch.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());

    Properties properties;

    /**
     * Gets the properties for the webservices from the properties file
     * @return a Properties object with the web services' API information
     */
    public Properties loadWebserviceProperties() {

        properties = new Properties();

        try {
            properties.load (this.getClass().getResourceAsStream("/webservices.properties"));
        } catch (IOException ioe) {
            logger.error("PropertiesLoader.loadWebserviceProperties()...Cannot load the properties file");
            logger.error(ioe);
        } catch (Exception e) {
            logger.error("PropertiesLoader.loadWebserviceProperties()..." + e);
        }
        return properties;

    }
}
