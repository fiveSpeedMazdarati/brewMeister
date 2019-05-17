package com.lukebusch.persistence;

import com.fasterxml.jackson.core.JsonParseException;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public FullServiceWeather(String zipCode, String timestamp) {
        this();

        this.zipCode = zipCode;
        this.timestamp = timestamp;
    }

    public Map<String, String> getWeatherFromZip(String zipCode) {

        Map<String, String> weatherData;

        Map<String, String> latLon = getLocationFromZip(zipCode);

        weatherData = getWeatherForLatLon(latLon.get("latitude"), latLon.get("longitude"));

        return weatherData;
    }

    public Map<String, String> getLocationFromZip(String zipCode) {

        Map<String, String> results = new HashMap<>();

        String zipJson = zipCodeClient.getInfoForZip(zipCode);
        ObjectMapper mapper = new ObjectMapper();
        try {

            Response response = mapper.readValue(zipJson, Response.class);

            results.put("latitude", String.valueOf(response.getLat()));
            results.put("longitude", String.valueOf(response.getLng()));

        } catch (IOException e) {

            logger.error("There was a problem parsing the json from the Zip Code service");
        }

        return results;
    }
    /**
     * gets the weather based on the given information
     *
     * @param zipCode the zip code for the weather report
     * @param timeStamp the time of the weather report
     * @return the weather report with pertinent information
     */
    public static Map<String, String> getWeather(String zipCode, String timeStamp) {

        return new HashMap<>();
    }
    /**
     * Gets the weather report for a given latitude and longitude at a point in time
     * @return a map of the weather report containing key information
     */
    protected Map<String, String> getWeatherForLatLon(String latitude, String longitude) {

        ObjectMapper mapper = new ObjectMapper();
        //at worst case the method returns an empty map
        Map<String, String> weatherReport = new HashMap<>();
        String weatherJson = weatherClient.getWeatherData(latitude, longitude, timestamp);

        try {

            com.lukebusch.weather.Response response = mapper.readValue(weatherJson, com.lukebusch.weather.Response.class);
            List<DataItem> dataItems = response.getDaily().getData();
            DataItem dataItem = dataItems.get(0);

            weatherReport = buildWeatherReport(dataItem, weatherReport);


        } catch(JsonParseException exception) {
            logger.error("There was a problem parsing the JSON from the API");
        }
        catch (IOException e) {
            logger.error("There was a problem with the weather data API");
        }

        return weatherReport;

    }

    private Map<String, String> buildWeatherReport(DataItem dataItem, Map<String, String> weatherReport) {

        // add the information from the DataItem to the weatherReport map
        weatherReport.put("pressure", String.valueOf(dataItem.getPressure()));
        weatherReport.put("summary", dataItem.getSummary());
        weatherReport.put("icon", dataItem.getIcon());
        weatherReport.put("tempHigh", String.valueOf(dataItem.getTemperatureHigh()));
        weatherReport.put("tempLow", String.valueOf(dataItem.getTemperatureLow()));
        weatherReport.put("humidity", String.valueOf(dataItem.getHumidity()));

        return weatherReport;
    }
}
