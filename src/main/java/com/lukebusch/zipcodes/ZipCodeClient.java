package com.lukebusch.zipcodes;

import com.lukebusch.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

/**
 * The type Zip code client.
 */
public class ZipCodeClient {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private PropertiesLoader loader;
    private Properties properties;
    private String uri;
    private String apiKey;
    private String dataFormat;
    private String units;

    /**
     * Instantiates a new Zip code client.
     */
    public ZipCodeClient() {
        loader = new PropertiesLoader();
        properties = loader.loadWebserviceProperties();

        uri = properties.getProperty("zipcode.api.uri");
        apiKey = properties.getProperty("zipcode.api.key");
        dataFormat = properties.getProperty("zipcode.api.data.format");
        units = properties.getProperty("zipcode.api.units");

    }

    /**
     * Gets a response from www.zipcodeapi.com/api based on the provided zip code
     *
     * @param zipCode the zip code
     * @return info for zip
     */
    public String getInfoForZip(String zipCode) {

        String response;
        String requestString = uri + "/" + apiKey + "/" + dataFormat + "/" + zipCode + "/" + units;
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(requestString);

        logger.debug(target);

        response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.debug(response);

        return response;
    }
}
