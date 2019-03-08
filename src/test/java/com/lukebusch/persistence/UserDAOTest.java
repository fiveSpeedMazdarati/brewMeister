package com.lukebusch.persistence;

import com.lukebusch.entity.Batch;
import com.lukebusch.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDAOTest {

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

    /**
     * Verifies that getById works as expected
     */
    @Test
    void getByIdSuccess() {
        logger.info("running getByID test");
        User retrievedUser = (User)genericDao.getById(2);
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
        // get a batch, change its value, save it back to the database
        User userToModify = (User) genericDao.getById(2);
        String originalFirstName = userToModify.getFirstName();
        logger.debug("This user: " + userToModify.toString());
        logger.debug("User's original first name: " + originalFirstName);
        logger.debug("User's batches: " + userToModify.getBatches());
        userToModify.setFirstName("Jose");
        genericDao.saveOrUpdate(userToModify);

        // get the same user, verify that the first name field has changed
        User modifiedUser = (User) genericDao.getById(2);
        logger.debug("first name from database: " + modifiedUser.getFirstName());

        assertNotEquals(originalFirstName, modifiedUser.getFirstName());
    }

    /**
     * verifies insert function
     */
    @Test
    void insertSuccess() {

        User testUser = new User("tester", "password", "first name test", "last name test", "53589", LocalDate.of(1980, 6, 16));

        // grab the id of the newly added user, use it to verify the new user was created
        int newId = genericDao.insert(testUser);

        User anotherTestUser = (User) genericDao.getById(newId);

        assertEquals(testUser, anotherTestUser);
    }

    /**
     * Verifies insert function when User has associated Batches
     */

    @Test
    void insertWithBatchSuccess() {

        User testUser = new User("tester", "password", "first name test", "last name test", "53589", LocalDate.of(1980, 6, 16));
        Batch testBatch = new Batch("White Spotted Dog", "porter", LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), 1.055, 1.043);
        // this way each of the entities know about one another!
        testUser.addBatch(testBatch);
        // grab the id of the newly added user, use it to verify the new user was created
        int newId = genericDao.insert(testUser);

        User anotherTestUser = (User) genericDao.getById(newId);
        assertEquals(testUser, anotherTestUser);



    }

    /**
     * Verifies delete function
     */
    @Test
    void deleteSuccess() {
        /*
            -create a user, give it an id that exists in the database
            -remove that user, then try to retrieve it from the database
            -verify no user was retrieved
         */
        User userToDelete = new User();
        userToDelete.setId(2);

        genericDao.delete(userToDelete);

        User deletedUser = (User) genericDao.getById(2);

        assertNull(deletedUser);
    }
    /**
     * Verifies delete user when user has at least one batch associated
     *
     * When the user is deleted, the batches associated with that user should
     * continue to exist
     *
     * This preserves system usage history (total batches created, etc),
     * and allows the batch to be reassigned to someone else.
     */
    @Test
    void deleteUserBatchesRemainSuccess() {
        GenericDao anotherDao = new GenericDao( Batch.class );
        /* user id 2 in the test database has two associated batches */
        User userWithBatch = (User) genericDao.getById(2);
        /* store the associated batches for this user */
        Set<Batch> batches = (Set<Batch>) userWithBatch.getBatches();
        logger.debug("The user's batches: "  + batches);

        /*
        * -disassociate the batches (this is the only way I can see to not delete the orphan records)
        * -delete the user
        * -confirm deletion
        */
        userWithBatch.setBatches(null);

        genericDao.delete(userWithBatch);

        assertNull(genericDao.getById(2));

        /*
        * try to retrieve the batches based on id
        * confirm they have not been removed from the database
        */
        for (Batch batch : batches) {
            logger.debug("test batch id: " + batch.getId());
            Batch testBatch = (Batch) anotherDao.getById(batch.getId());
            logger.debug("Test batch retrieved from db: " + testBatch);
            assertNotNull(testBatch);
        }
    }

    /**
     * tests getAll feature of DAO
     */
    @Test
    void getAllSuccess() {
        // get all the users
        // make sure there are the proper number of users
        List<User> users = genericDao.getAll();
        assertEquals(users.size(), 4);
    }
}