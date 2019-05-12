package com.lukebusch.controller;

import com.lukebusch.entity.User;
import com.lukebusch.persistence.GenericDao;
import com.lukebusch.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateNewUserTest {

    /**
     * The (generic) Dao.
     */
    GenericDao genericDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Creates a baseline set of data in the db for testing before each test is executed; instantiates a UserDao
     */
    @BeforeEach
    void setUp() {


        // repopulate the table I'm testing
        com.lukebusch.test.util.Database database = com.lukebusch.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao( User.class );

    }
    @Test
    @SuppressWarnings("unchecked")
    void userNameAvailableSuccess() {

        GenericDao dao = DaoFactory.createDao(User.class);

        List<User> users = dao.findByPropertyEqual("userName", "NewUserExample" );

        // if the username is available, this list should be empty (size 0)
        assertEquals(0, users.size());

    }

    @Test
    @SuppressWarnings("unchecked")
    void emailAddressAvailableSuccess() {

        GenericDao dao = DaoFactory.createDao(User.class);

        List<User> users = dao.findByPropertyEqual("email", "newuser@gmail.com" );

        // if the username is available, this list should be empty (size 0)
        assertEquals(0, users.size());

    }

    @Test
    @SuppressWarnings("unchecked")
    void userNameTaken() {

        GenericDao dao = DaoFactory.createDao(User.class);

        List<User> users = dao.findByPropertyEqual("userName", "BigAl" );

        /*
         * if the username is not available, this list's size should be not 0. Ideally, it's size will be exactly one according to
         * the business rules, but this only checks that it isn't zero. If there is more than one of this username in the
         * table, there are bigger problems to sort out than just this test failing.
         */
        assertNotEquals(0, users.size());

    }

    @Test
    @SuppressWarnings("unchecked")
    void emailAddressTaken() {

        GenericDao dao = DaoFactory.createDao(User.class);

        List<User> users = dao.findByPropertyEqual("email", "itWorks@relativity.com" );

        /*
         * if the email address is not available, this list's size should be not 0. Ideally, it's size will be exactly one according to
         * the business rules, but this only checks that it isn't zero. If there is more than one of this email address in the
         * table, there are bigger problems to sort out than just this test failing.
         */
        assertNotEquals(0, users.size());

    }
}