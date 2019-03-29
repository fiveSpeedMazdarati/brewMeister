package com.lukebusch.controller;

import com.lukebusch.entity.Batch;
import com.lukebusch.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name="GetBatch"
            , urlPatterns = { "/getBatch"}
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

        GenericDao<Batch> dao = new GenericDao<>(Batch.class);
        Batch batch = dao.getById(2); // TODO: change this to a variable once everything is working with a hardcoded value
        req.setAttribute("batch", batch);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewBatch.jsp");
        dispatcher.forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }
}
