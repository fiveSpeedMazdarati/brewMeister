package com.lukebusch.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lukebusch.entity.Batch;
import com.lukebusch.entity.DarkSkyResponse;
import com.lukebusch.persistence.GenericDao;
import com.lukebusch.util.DaoFactory;
import com.lukebusch.util.DarkSkyWeatherClient;
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
        req.setAttribute("batch", batch);

        //TODO: get the lat/lon for the user's ZIP code
        // some hard coded values for now
        String latitudeFromZip = "47.643";
        String longitudeFromZip = "-89.924";

        DarkSkyResponse darkSkyResponse;

        try {

            darkSkyResponse = getWeatherFromApi(latitudeFromZip, longitudeFromZip, batch.getBrewDate());

            // weather retrieval was successful, so put the weather in the request and set the weather error flag to false
            req.setAttribute("weather", darkSkyResponse);
            req.setAttribute("weatherError", false);

            //TODO: build second request for bottle date if time

        } catch (ResponseProcessingException e) {
            logger.error("Error getting weather data: " + e.getMessage());

            // there was a weather retrieval error, set the weather error flag to true
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

    private DarkSkyResponse getWeatherFromApi(String latitude, String longitude, LocalDate weatherDate) throws ResponseProcessingException {

        String weatherJson = "";
        DarkSkyWeatherClient client = new DarkSkyWeatherClient();

        //TODO: replace the hard coded values with info from the user profile and batch date
        weatherJson = client.getWeatherData(latitude, longitude, convertToMillis(weatherDate));

        ObjectMapper mapper = new ObjectMapper();
        DarkSkyResponse weatherResponse= null;

        try {
            weatherResponse = mapper.readValue(weatherJson, DarkSkyResponse.class);

        } catch (JsonParseException exception) {

        } catch (JsonMappingException exception) {

        } catch (IOException exception) {

        }
        return weatherResponse;
    }
}
