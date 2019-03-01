package com.lukebusch.persistence;

import com.lukebusch.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
// TODO add unit tests to achieve 100% code coverage of your dao.

class UserDAOTest {

    /**
     * The Dao.
     */
    UserDAO dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Creates a baseline set of data in the db for testing before each test is executed; instantiates a UserDao
     */
    @BeforeEach
    void setUp() {

        // database code of some sort
        // repopulate the table I'm testing
        com.lukebusch.test.util.Database database = com.lukebusch.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDAO();
    }

    /**
     * Verifies that getById works as expected
     */
    @Test
    void getByIdSuccess() {
        logger.info("running getByID test");
        User retrievedUser = dao.getById(1);
        assertEquals("BigAl", retrievedUser.getUserName());
        assertEquals("Albert", retrievedUser.getFirstName());
        assertEquals(1, retrievedUser.getId());
        assertEquals("Einstein", retrievedUser.getLastName());
        assertEquals("10021", retrievedUser.getZipCode());
        assertEquals(LocalDate.of(1885,4,1), retrievedUser.getBirthDate());

    }

    /**
     * Verifies update functions
     */
    @Test
    void saveOrUpdateSuccess() {
        // get a book, change its value, save it back to the database
        User userToModify = dao.getById(1);
        String originalFirstName = userToModify.getFirstName();

        userToModify.setFirstName("Jose");
        dao.saveOrUpdate(userToModify);

        // get the same book, verify that the author field has changed
        User modifiedUser = dao.getById(1);
        logger.debug(modifiedUser.getFirstName());

        assertNotEquals(originalFirstName, modifiedUser.getFirstName());
    }

    /**
     * verifies insert function
     */
    @Test
    void insertSuccess() {

        User testUser = new User();

        // grab the id of the newly added book, use it to verify the new book was created
        int newId = dao.insert(testUser);

        User anotherTestUser = dao.getById(newId);

        assertTrue(testUser.equals(anotherTestUser));

    }

    /**
     * Verifies delete function
     */
    @Test
    void deleteSuccess() {
        /*
            -create a book, give it an id that exists in the database
            -remove that book, then try to retrieve it from the database
            -verify no book was retrieved
         */
        User bookToDelete = new User();
        bookToDelete.setId(2);

        dao.delete(bookToDelete);

        User deletedUser = dao.getById(2);

        assertTrue(Objects.isNull(deletedUser));
    }

    /**
     * tests getAll feature of DAO
     */
    @Test
    void getAllSuccess() {
        // get all the books
        // make sure there are the proper number of books
        List<User> books = dao.getAll();
        assertEquals(books.size(), 3);
    }
}