package com.lukebusch.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * a class to update a given batch in the database
 *
 * @author lbusch
 */
@WebServlet(name = "ShowCreateNewBatch", urlPatterns = "/showCreateNewBatch")
public class ShowCreateNewBatch extends HttpServlet {


    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // send them off to the new batch page
        RequestDispatcher dispatcher = req.getRequestDispatcher("newBatch.jsp");
        dispatcher.forward(req, resp);

    }
}
