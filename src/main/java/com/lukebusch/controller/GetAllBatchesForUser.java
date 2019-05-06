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
import java.util.List;

@WebServlet(name = "GetAllBatchesForUser"
                , urlPatterns = "/getAllBatchesForUser")
public class GetAllBatchesForUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String loggedInUser = req.getRemoteUser();
        logger.info("Username " +loggedInUser + " successfully authenticated.");
        //a dao to get batches
        GenericDao<Batch> batchDao = DaoFactory.createDao(Batch.class);
        List<Batch> batches = batchDao.getAll();
        logger.debug("Getting all batches from the db");
        logger.debug(batches);

        //another dao to get the user information
        GenericDao<User> userDao = DaoFactory.createDao( User.class );

        req.setAttribute("loggedInUserName", loggedInUser);
        req.setAttribute("batches", batches);

        // pass along the info from the update batch servlet (will be empty if the program did not come here from the UpdateBatch servlet
        req.setAttribute("batchUpdated", req.getAttribute("batchUpdated"));
        req.setAttribute("updatedBatchTitle", req.getAttribute("updatedBatchTitle"));
        req.setAttribute("UpdatedBatchId", req.getAttribute("updatedBatchId"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/allBatches.jsp");
        dispatcher.forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        this.doGet(req, resp);
    }
}