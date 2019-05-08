package com.lukebusch.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class DarkSkyWeatherClient {

    public String getWeatherData() throws Exception {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.darksky.net/forecast/6994d6b06e66e1182c61e65746e771ad/42.926,-89.224,329979600?exclude=currently,flags,hourly,flags");

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        return response;
    }
}
