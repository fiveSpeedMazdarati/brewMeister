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
        handleRequest(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        this.doGet(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Batch> dao = DaoFactory.createDao(Batch.class);

        String id = req.getParameter("id");
        logger.debug("param collected: " + id);


        Batch batch = dao.getById(Integer.valueOf(id)); // TODO: change this to a variable once everything is working with a hardcoded value
        // update the batch using the values from the request

        // save the updated object to the database using the same id number so the batch is replaced

        req.setAttribute("batch", batch);

        // get the weather data here, put it into the request

        RequestDispatcher dispatcher = req.getRequestDispatcher("editBatch.jsp");
        dispatcher.forward(req, resp);
    }
}