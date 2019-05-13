package com.lukebusch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lukebusch.entity.Batch;
import com.lukebusch.persistence.GenericDao;
import com.lukebusch.util.DaoFactory;
import com.lukebusch.util.DarkSkyWeatherClient;
import com.lukebusch.weather.DataItem;
import com.lukebusch.zipcodes.Response;
import com.lukebusch.zipcodes.ZipCodeClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ResponseProcessingException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Get batch.
 */
@WebServlet (name="GetBatch"
            , urlPatterns = { "/getBatch" }
            )
/**
 * A servlet to retrieve a batch from the database
 *
 * @author lbusch
 */
public class GetBatch extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        this.doGet(req, resp);
    }

    @SuppressWarnings("unchecked")
    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        logger.info("param collected: " + id);

        GenericDao<Batch> dao = DaoFactory.createDao(Batch.class);

        Batch batch = dao.getById(Integer.valueOf(id));
        logger.debug("Retrieving batch #" + id);
        logger.debug(batch);

        String batchZipCode = batch.getUser().getZipCode();

        req.setAttribute("batch", batch);

        //TODO: get the lat/lon for the user's ZIP code
        // some hard coded values for now

        req.getSession().getAttribute("loggedInUserId");

        String latitudeFromZip = "47.643";
        String longitudeFromZip = "-89.924";

        try {

        String weather = getWeatherFromApi(latitudeFromZip, longitudeFromZip, batch.getBrewDate());


        req.setAttribute("weatherData", weather);

        // weather retrieval was successful, so put that in the request
        req.setAttribute("weatherError", false);
            //TODO: build second request for bottle date if time

        } catch (ResponseProcessingException e) {
            logger.error("Error getting weather data: " + e.getMessage());

            // there was a weather retrieval error, put that in the request
            req.setAttribute("weatherError", true);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("viewBatch.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Helper method to convert a LocalDate to its Unix timestamp
     * @param date the date to convert
     * @return the Unix timestamp as a String
     */
    private String convertToMillis(LocalDate date){

        ZoneId zoneId = ZoneId.systemDefault();
        long unixTimestamp = date.atStartOfDay(zoneId).toEpochSecond();

        logger.debug("unix time: " + unixTimestamp);

        return String.valueOf(unixTimestamp);
    }

    /**
     * gets the weather based on a latitude, longitude, and a point in time
     *
     * @param latitude
     * @param longitude
     * @param weatherDate
     * @return a string of json data representing the weather for the given place and time
     * @throws ResponseProcessingException if there is a problem processing the response
     */
    private String getWeatherFromApi(String latitude, String longitude, LocalDate weatherDate) throws ResponseProcessingException {

        String weatherJson = "";
        DarkSkyWeatherClient client = new DarkSkyWeatherClient();

        weatherJson = client.getWeatherData(latitude, longitude, convertToMillis(weatherDate));

        return weatherJson;
    }

    /**
     * gets latitude and longitude for a given zipcode
     * @param zipCode
     * @return a list containing the latitude and longitude. The first value is the latitude, the second is the longitude
     */
    private List<String> getLatLonFromZip(String zipCode){

        List<String> latLon = new ArrayList<>();
        ZipCodeClient client = new ZipCodeClient();


        ObjectMapper mapper = new ObjectMapper();
        try {
            Response response = mapper.readValue(client.getInfoForZip(zipCode), Response.class);

            latLon.add(String.valueOf(response.getLat()));
            latLon.add(String.valueOf(response.getLng()));

        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return latLon;

    }
}
