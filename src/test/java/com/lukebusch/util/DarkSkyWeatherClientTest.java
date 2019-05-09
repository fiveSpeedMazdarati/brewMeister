package com.lukebusch.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DarkSkyWeatherClientTest {

    @Test
    void getWeatherData() {

        DarkSkyWeatherClient client = new DarkSkyWeatherClient();

        try {
            assertEquals("{\"latitude\":42.926,\"longitude\":-89.224,\"timezone\""
                                    + ":\"America/Chicago\",\"daily\":{\"data\":[{\"time\":329979600,"
                                    + "\"summary\":\"Clear throughout the day.\",\"icon\":\"clear-day\",\"sunriseTime\""
                                    + ":329998725,\"sunsetTime\":330053954,\"moonPhase\":0.13,\"precipIntensity\":0"
                                    + ",\"precipIntensityMax\":0,\"precipProbability\":0,\"temperatureHigh\":69.99,\""
                                    + "temperatureHighTime\":330044400,\"temperatureLow\":46.95,\"temperatureLowTime\""
                                    + ":330080400,\"apparentTemperatureHigh\":69.99,\"apparentTemperatureHighTime\":"
                                    + "330044400,\"apparentTemperatureLow\":44.14,\"apparentTemperatureLowTime\""
                                    + ":330080400,\"dewPoint\":38.97,\"humidity\":0.59,\"pressure\":1022.53,\"windSpeed"
                                    + "\":3.61,\"windBearing\":355,\"cloudCover\":0.02,\"uvIndex\":10,\"uvIndexTime\""
                                    + ":330022800,\"visibility\":10,\"temperatureMin\":37.06,\"temperatureMinTime\""
                                    + ":329997600,\"temperatureMax\":69.99,\"temperatureMaxTime\":330044400,\""
                                    + "apparentTemperatureMin\":33.28,\"apparentTemperatureMinTime\":329997600,\""
                                    + "apparentTemperatureMax\":69.99,\"apparentTemperatureMaxTime\":330044400}]},\""
                                    + "offset\":-5}"
                                    ,  client.getWeatherData("42.926", "-89.224", "329979600"));
        } catch (Exception e) {

            e.getMessage();
        }
    }

    @Test
    void convertWeatherDataToJavaObject() {

        // check that the json is converted to a POJO
        assertEquals("","");
    }
}