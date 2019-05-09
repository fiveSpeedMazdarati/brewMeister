package com.lukebusch.controller;

import com.lukebusch.entity.User;
import com.lukebusch.persistence.GenericDao;
import com.lukebusch.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

/**
 * A servlet to create a new user
 * @author lbusch
 */
public class CreateNewUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        GenericDao dao = DaoFactory.createDao( User.class );

        User newUser = new User(
            request.getParameter("username")
            , request.getParameter("password")
            , request.getParameter("first-name")
            , request.getParameter("last-name")
            , request.getParameter("email")
            , request.getParameter("zip-code")
            , LocalDate.parse(request.getParameter("birthdate"))
        );

        dao.insert(newUser);



    }
}
