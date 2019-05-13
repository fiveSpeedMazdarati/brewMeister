package com.lukebusch.zipcodes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeClientTest {

    @Test
    void getInfoForZip() {

        ZipCodeClient service = new ZipCodeClient();
        String results = service.getInfoForZip("53589");

        assertEquals("{\"zip_code\":\"53589\",\"lat\":42.924566,\"lng\":-89.212967,\"city\":\"Stoughton\",\"state\":\"WI\",\"timezone\":{\"timezone_identifier\":\"America\\/Chicago\",\"timezone_abbr\":\"CDT\",\"utc_offset_sec\":-18000,\"is_dst\":\"T\"},\"acceptable_city_names\":[]}", results);

    }

    @Test
    void convertToObject() throws Exception {

        String json = "{\"zip_code\":\"53589\",\"lat\":42.924566,\"lng\":-89.212967,\"city\":\"Stoughton\",\"state\":\"WI\",\"timezone\":{\"timezone_identifier\":\"America\\/Chicago\",\"timezone_abbr\":\"CDT\",\"utc_offset_sec\":-18000,\"is_dst\":\"T\"},\"acceptable_city_names\":[]}";
        ObjectMapper mapper = new ObjectMapper();
        Response responseObject = mapper.readValue(json, Response.class);


        assertNotNull(responseObject);
        assertEquals("42.924566", String.valueOf(responseObject.getLat()));
        assertEquals("-89.212967", String.valueOf(responseObject.getLng()));
    }
}