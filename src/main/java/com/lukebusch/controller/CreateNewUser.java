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

        HttpSession session = request.getSession();
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

        //TODO: parameterize the default role name
        Role role = new Role(newUser, "administrator", request.getParameter("username"));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        newUser.setRoles(roles);

        // a check to see if the username and email address are not already in use
        if (userNameAvailable(request.getParameter("username")) && emailAddressAvailable(request.getParameter("email"))) {

            // create the new user and put the information into the request and session
            int newUserId = dao.insert(newUser);

            request.setAttribute("newUserId", newUserId);
            request.setAttribute("username", newUser.getUserName());
            session.setAttribute("loggedInUserName", newUser.getUserName());
            session.setAttribute("loggedInUserId", newUserId);
            request.setAttribute("successfulSignUp", true);

            // forward them on to the all batches screen (which should be empty at this point)
            RequestDispatcher dispatcher = request.getRequestDispatcher("/showIndex");
            dispatcher.include(request, response);


        } else {
            // one of the username or email was in use, so go back to the sign up page and show an error
            request.setAttribute("emailInUseError", true);
            request.setAttribute("usernameInUseError", true);

            // send them off to the signup page again
            RequestDispatcher dispatcher = request.getRequestDispatcher("/showCreateNewUser");
            dispatcher.include(request, response);
        }

    }

    /**
     * checks to see if a username is available for use (i.e. not in the user table already)
     * @param username the username to look for
     * @return whether the username is available
     */
    protected boolean userNameAvailable(String username) {
        GenericDao dao = DaoFactory.createDao(User.class);

        List<User> users = dao.findByPropertyEqual("userName", username );

        return (users.size() == 0);

    }

    /**
     * Checks to see if an email address is available for use (i.e. not in the user table already)
     * @param email the email address to look for
     * @return whether the email address is available
     */
    protected boolean emailAddressAvailable(String email) {

        GenericDao dao = DaoFactory.createDao(User.class);
        List<User> users = dao.findByPropertyEqual("email", email);

        return (users.size() == 0);
    }

    /**
     * sends the user to the proper page after signup success or failure
     */
    private void routeUserToPage(String url, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    }
}
