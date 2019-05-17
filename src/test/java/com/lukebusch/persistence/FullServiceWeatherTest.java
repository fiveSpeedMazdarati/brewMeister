package com.lukebusch.persistence;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FullServiceWeatherTest {

    @Test
    public void getLocationFromZipSuccess() {

        FullServiceWeather weatherService = new FullServiceWeather();
    }

    @Test
    public void getWeatherFromLatLonAndTime() {

        FullServiceWeather weatherService = new FullServiceWeather();

    }

    @Test
    public void getWeatherFromZip() {
        FullServiceWeather weatherService = new FullServiceWeather("53589", "577687234");
        Map<String, String> weatherInfo = new HashMap<String, String>();

        weatherInfo.put("summary", "Mostly cloudy throughout the day.");
        weatherInfo.put("tempLow", "33.14");
        weatherInfo.put("icon", "partly-cloudy-day");
        weatherInfo.put("humidity", "0.56");
        weatherInfo.put("pressure", "1010.19");
        weatherInfo.put("tempHigh", "50.06");


        assertEquals(weatherInfo, weatherService.getWeatherFromZip("53589"));

    }
}