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
public class deleteBatch extends HttpServlet {
    // just a logger, nothing to see here...
    private final Logger logger = LogManager.getLogger(this.getClass());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // stuff to delete the selected batch here
    }


}
