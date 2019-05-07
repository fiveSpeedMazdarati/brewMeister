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

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        logger.info("param collected: " + id);
        GenericDao<Batch> dao = DaoFactory.createDao(Batch.class);
        Batch batch = dao.getById(Integer.valueOf(id));
        logger.debug("Retrieving batch #" + id);
        logger.debug(batch);
        req.setAttribute("batch", batch);

        // get the weather data here, put it into the request

        RequestDispatcher dispatcher = req.getRequestDispatcher("viewBatch.jsp");
        dispatcher.forward(req, resp);
    }
}
