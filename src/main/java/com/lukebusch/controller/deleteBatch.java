package com.lukebusch.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteBatch", urlPatterns = "/deleteBatch")
/**
 * A servlet to handle a delete request
 *
 * @author lbusch
 */
public class deleteBatch extends HttpServlet {
    // just a logger, nothing to see here...
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Handles POST requests
     *
     * @param request the request
     * @param response the response
     * @throws ServletException if there is an exception, this contains the information
     * @throws IOException if there is an exception, this contains the needed information
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // stuff to delete the selected batch here
    }


}
