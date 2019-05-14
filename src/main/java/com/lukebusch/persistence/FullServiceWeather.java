package com.lukebusch.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lukebusch.util.DarkSkyWeatherClient;
import com.lukebusch.weather.DataItem;
import com.lukebusch.zipcodes.Response;
import com.lukebusch.zipcodes.ZipCodeClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A utility to combine two webservices into one process
 * @author lbusch
 */
public class FullServiceWeather {

    private final Logger logger = LogManager.getLogger(this.getClass());

    ZipCodeClient zipCodeClient;
    DarkSkyWeatherClient weatherClient;
    String zipCode;
    String latitude;
    String longitude;
    String timestamp;


    public FullServiceWeather() {

        zipCodeClient = new ZipCodeClient();
        weatherClient = new DarkSkyWeatherClient();
    }

    public FullServiceWeather(String zipCode) {
        this();
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public FullServiceWeather(String zipCode, String latitude, String longitude, String timestamp) {
        this();

        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    protected Map getLocationFromZip() {

        Map<String, Double> results = new HashMap<>();

        String zipJson = zipCodeClient.getInfoForZip(zipCode);
        ObjectMapper mapper = new ObjectMapper();
        try {

            Response response = mapper.readValue(zipJson, Response.class);

            results.put("latitude",response.getLat());
            results.put("longitude", response.getLng());

        } catch (IOException e) {

            logger.error("There was a problem parsing the json from the Zip Code service");
        }

        return new HashMap<String, String>();
    }

    /**
     * Gets the weather report for a given latitude and longitude at a point in time
     * @return a map of the weather report containing key information
     */
    protected Map<String, String> getWeatherForLatLon() {

        Map<String, String> weatherReport = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();

        String weatherJson = weatherClient.getWeatherData(latitude, longitude, timestamp);

        try {
            com.lukebusch.weather.Response response = mapper.readValue(weatherJson, com.lukebusch.weather.Response.class);
            List<DataItem> dataItems = response.getDaily().getData();
            DataItem dataItem = dataItems.get(0);

            //TODO: add the important stuff from the weather report here
            //        HighTemp, LowTemp, Humidity, Atmospheric Pressure, Pollen Count (if available)

            weatherReport.put("pressure", String.valueOf(dataItem.getPressure()));

        } catch (IOException e) {
            logger.error("There was a problem parsing the weather data from the API response");
        }

        return weatherReport;

    }
}
