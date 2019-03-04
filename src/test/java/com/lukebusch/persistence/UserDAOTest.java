package com.lukebusch.persistence;

import com.lukebusch.entity.Batch;
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
        User retrievedUser = dao.getById(2);
        assertEquals("BigAl", retrievedUser.getUserName());
        assertEquals("Albert", retrievedUser.getFirstName());
        assertEquals(2, retrievedUser.getId());
        assertEquals("Einstein", retrievedUser.getLastName());
        assertEquals("11223", retrievedUser.getZipCode());
        assertEquals(LocalDate.of(1879,3,14), retrievedUser.getBirthDate());

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

        User testUser = new User(5, "tester", "password", "first name test", "last name test", "53589", LocalDate.of(1980, 6, 16));

        // grab the id of the newly added book, use it to verify the new book was created
        int newId = dao.insert(testUser);

        User anotherTestUser = dao.getById(newId);

        assertEquals(testUser.getId(), anotherTestUser.getId());
        assertEquals(testUser.getUserName(), anotherTestUser.getUserName());
        assertEquals(testUser.getFirstName(), anotherTestUser.getFirstName());


    }

    @Test
    void insertWithOrderSuccess() {

        User testUser = new User(5, "tester", "password", "first name test", "last name test", "53589", LocalDate.of(1980, 6, 16));
        Batch testBatch = new Batch(5, "White Spotted Dog", "porter", LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), 1.055, 1.043, testUser);
        // this way each of the entities know about one another!
        testUser.addBatch(testBatch);
        // grab the id of the newly added book, use it to verify the new book was created
        int newId = dao.insert(testUser);

        User anotherTestUser = dao.getById(newId);
        assertEquals(1, anotherTestUser.getBatches().size());
        assertEquals(testUser.getId(), anotherTestUser.getId());
        assertEquals(testUser.getUserName(), anotherTestUser.getUserName());
        assertEquals(testUser.getFirstName(), anotherTestUser.getFirstName());


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
        // get all the users
        // make sure there are the proper number of users
        List<User> users = dao.getAll();
        assertEquals(users.size(), 4);
    }
}