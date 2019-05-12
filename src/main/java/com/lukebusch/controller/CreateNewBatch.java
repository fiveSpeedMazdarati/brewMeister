package com.lukebusch.controller;

import com.lukebusch.entity.Batch;
import com.lukebusch.entity.User;
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
@WebServlet(name = "CreateNewBatch", urlPatterns = "/createNewBatch")
public class CreateNewBatch extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the logged in user by id
        String loggedInUserId = String.valueOf(request.getSession().getAttribute("loggedInUserId"));
        int userId = Integer.parseInt(loggedInUserId);

        GenericDao dao = DaoFactory.createDao( Batch.class );
        GenericDao dao2 = DaoFactory.createDao( User.class );
        Batch newBatch = new Batch();
        User loggedInUser = (User) dao2.getById(userId);
        //loggedInUser =


        // TODO: build up the new Batch here with the info from the form
        newBatch.setUser(loggedInUser);
        newBatch.setTitle(request.getParameter("title"));
        newBatch.setBrewDate(LocalDate.parse((request.getParameter("brew-date"))));
        newBatch.setBottleDate(LocalDate.parse((request.getParameter("bottle-date"))));
        newBatch.setInitialSpecificGravity(Double.valueOf(request.getParameter("initial-specific-gravity")));
        newBatch.setNotes(request.getParameter("tinymce"));

        logger.debug("new batch: " + newBatch);

        int newBatchId = dao.insert(newBatch);

        // stuff for the jsp to use after a new batch is created
        request.setAttribute("newBatchId", newBatchId);
        request.setAttribute("newBatchName", newBatch.getTitle());
        request.setAttribute("newBatchAdded", true);

        RequestDispatcher dispatcher = request.getRequestDispatcher("getAllBatchesForUser");
        dispatcher.include(request, response);
    }
}
