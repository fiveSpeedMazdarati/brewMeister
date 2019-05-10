package com.lukebusch.controller;

import com.lukebusch.entity.Role;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A servlet to create a new user
 * @author lbusch
 */
@WebServlet(name = "CreateNewUser", urlPatterns = "/createNewUser")
public class CreateNewUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        Role role = new Role(newUser, "administrator", request.getParameter("username"));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        newUser.setRoles(roles);

        // logger.info(dao.getByProperty("email"));

        int newUserId = dao.insert(newUser);

        HttpSession session = request.getSession();
        request.setAttribute("newUserId", newUserId);
        request.setAttribute("username", newUser.getUserName());

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.include(request, response);

    }
}
