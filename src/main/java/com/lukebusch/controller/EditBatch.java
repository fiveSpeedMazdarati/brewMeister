package com.lukebusch.controller;

import com.lukebusch.entity.Batch;
import com.lukebusch.persistence.GenericDao;
import com.lukebusch.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * The type Edit batch.
 */
@WebServlet (name="EditBatch"
        , urlPatterns = { "/editBatch" }
)
/**
 * A servlet to get a batch from the database for the user to edit
 *
 * @author lbusch
 */
public class EditBatch extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.handleRequest(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        this.doGet(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Batch> dao = DaoFactory.createDao(Batch.class);

        String id = req.getParameter("id");
        logger.debug("param collected: " + id);

        Batch batch = dao.getById(Integer.valueOf(id));

        req.setAttribute("batch", batch);

        // get the weather data here, put it into the request
        //see if either of the important dates are populated. get the weather info for the dates that exist.
        LocalDate brewDate = batch.getBrewDate();
        logger.debug("brew date: " + batch.getBrewDate());
        if ( brewDate != null ) {
            // get the brew date weather, add it to the request and send it along
            req.setAttribute("brewDate", brewDate);
        }

        LocalDate bottleDate = batch.getBottleDate();
        logger.debug("bottle date: " + bottleDate);
        if ( bottleDate != null ) {
            // get the bottle date weather, add it to the request and send it along
            req.setAttribute("bottleDate", bottleDate);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("editBatch.jsp");
        dispatcher.forward(req, resp);
    }
}