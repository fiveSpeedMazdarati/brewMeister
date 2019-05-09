package com.lukebusch.persistence;

import com.lukebusch.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;
/**
 * A client to access the Dark Sky weather API
 * https://darksky.net/dev
 *
 * @author lbusch
 */
public class DarkSkyWeatherClient {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private PropertiesLoader loader;
    private Properties properties;
    private String uri;
    private String apiKey;
    private String excludeParams;

    /**
     * Zero parameter constructor
     */
    public DarkSkyWeatherClient() {

        loader = new PropertiesLoader();
        properties = loader.loadWebserviceProperties();

        uri = properties.getProperty("darksky.uri");
        apiKey = properties.getProperty("darksky.api.key");
        excludeParams = properties.getProperty("darksky.param.exclude");

    }

    /**
     * @param latitude the latitude for the location expressed as a String. Positive numbers for North, negative for South e.g. -79.342
     * @param longitude the longitude for the location expressed as a String. Positive numbers for East, negative for West e.g. 56.224
     * @param time the date and time to retrieve expressed as a Unix timestamp
     * @return a string containing the weather information in JSON format
     * @throws Exception in case there is an error contacting the web service
     */
    public String getWeatherData(String latitude, String longitude, String time) throws ResponseProcessingException {
        String response;

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(uri + apiKey + "/" + latitude + "," + longitude + "," + time + excludeParams);

        logger.debug(target);

        response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        return response;
    }
}
