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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllBatchesForUser"
                , urlPatterns = "/getAllBatchesForUser")
public class GetAllBatchesForUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao<User> userDao = DaoFactory.createDao( User.class );
    private GenericDao<Batch> batchDao = DaoFactory.createDao(Batch.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String loggedInUser = req.getRemoteUser();
        logger.info("Username " +loggedInUser + " successfully authenticated.");

        //TODO: refactor to getIdFromUserName()
        List<User> users = userDao.findByPropertyEqual("userName", loggedInUser);
        User user = users.get(0);
        int userId = user.getId();

        //TODO: refactor to getBatchesByUserId()
        List<Batch> batches = batchDao.findByPropertyEqual("id", userId);
        logger.info("Getting all batches from the db for user #" + userId);
        logger.debug(batches);

        // these need to be available throughout the application as long as this user is logged in
        session.setAttribute("loggedInUserName", loggedInUser);
        session.setAttribute("loggedInUserId", userId);

        // only good for this request
        req.setAttribute("batches", user.getBatches());

        // pass along the info from the update batch servlet (will be empty if the program did not come here from the UpdateBatch servlet)
        req.setAttribute("batchUpdated", req.getAttribute("batchUpdated"));
        req.setAttribute("updatedBatchTitle", req.getAttribute("updatedBatchTitle"));
        req.setAttribute("UpdatedBatchId", req.getAttribute("updatedBatchId"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/allBatches.jsp");
        dispatcher.include(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        this.doGet(req, resp);
    }
}
