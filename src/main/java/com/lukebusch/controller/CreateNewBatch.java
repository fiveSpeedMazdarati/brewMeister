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
 * a class to create a new batch with the given information
 * @author lbusch
 */
@WebServlet(name = "ShowCreateNewBatch", urlPatterns = "/showCreateNewBatch")
public class CreateNewBatch extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao dao = DaoFactory.createDao( Batch.class );
        Batch newBatch = new Batch();

        // TODO: build up the new Batch here with the info from the form
        newBatch.setTitle(request.getParameter("title"));
        newBatch.setBrewDate(LocalDate.parse((request.getParameter("brew-date"))));
        newBatch.setBottleDate(LocalDate.parse((request.getParameter("bottle-date"))));
        newBatch.setInitalSpecificGravity(Double.valueOf(request.getParameter("initial-specific-gravity")));

        logger.debug("new batch: " + newBatch);

        // int newBatchId = dao.insert(newBatch);
        // request.setAttribute("newBatchId", newBatchId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("getAllBatchesForUser.jsp");
        dispatcher.include(request, response);
    }
}
