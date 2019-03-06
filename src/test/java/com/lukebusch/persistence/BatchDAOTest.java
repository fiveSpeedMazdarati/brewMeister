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

public class BatchDAOTest {

    /**
     * The Dao.
     */
    BatchDAO dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {

        com.lukebusch.test.util.Database database = com.lukebusch.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new BatchDAO();
    }

    /**
     * Verifies that getById works as expected
     */
    @Test
    void getByIdSuccess() {
        logger.info("running getByID test");
        Batch retrievedBatch = dao.getById(1);
        assertEquals("batch title", retrievedBatch.getTitle());
        assertEquals("recipe name", retrievedBatch.getRecipe());
        assertEquals(1, retrievedBatch.getId());
        assertEquals(LocalDate.of(2019,3,1), retrievedBatch.getBrewDate());
        assertEquals(LocalDate.of(2019,3,6), retrievedBatch.getBottleDate());
        assertEquals(LocalDate.of(2019,4,20), retrievedBatch.getReadyDate());
        assertEquals(LocalDate.of(2019,10,20), retrievedBatch.getExpirationDate());
        assertEquals(1.105, retrievedBatch.getInitalSpecificGravity());
        assertEquals(1.055, retrievedBatch.getFinalSpecificGravity());

    }

    /**
     * Verifies update functions
     */
    @Test
    void saveOrUpdateSuccess() {
        // get a batch, change its value, save it back to the database
        Batch batchToModify = dao.getById(1);
        String originalBatchTitle = batchToModify.getTitle();

        batchToModify.setTitle("Jose");
        dao.saveOrUpdate(batchToModify);

        // get the same batch, verify that the author field has changed
        Batch modifiedBatch = dao.getById(1);

        assertNotEquals(originalBatchTitle, modifiedBatch.getTitle());
    }

    /**
     * verifies insert function
     */
    @Test
    void insertSuccess() {

        Batch testBatch = new Batch("White Spotted Dog", "porter", LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), 1.055, 1.043);

        // grab the id of the newly added batch, use it to verify the new batch was created
        int newId = dao.insert(testBatch);

        Batch anotherTestBatch = dao.getById(newId);

        assertEquals(testBatch.getId(), anotherTestBatch.getId());
        assertEquals(testBatch.getTitle(), anotherTestBatch.getTitle());
        assertEquals(testBatch.getRecipe(), anotherTestBatch.getRecipe());


    }

    /**
     * Verifies delete function
     */
    @Test
    void deleteSuccess() {
        /*
            -create a batch, give it an id that exists in the database
            -remove that batch, then try to retrieve it from the database
            -verify no batch was retrieved
         */
        Batch batchToDelete = new Batch();
        batchToDelete.setId(1);

        dao.delete(batchToDelete);

        Batch deletedBatch = dao.getById(1);

        assertTrue(Objects.isNull(deletedBatch));
    }

    /**
     * tests getAll feature of DAO
     */
    @Test
    void getAllSuccess() {
        // get all the batches
        // make sure there are the proper number of batches
        List<Batch> batches = dao.getAll();
        assertEquals(batches.size(), 3);
    }

}
