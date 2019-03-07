package com.lukebusch.persistence;

import com.lukebusch.entity.Batch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BatchDAOTest {

    /**
     * The Dao.
     */
    GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {

        com.lukebusch.test.util.Database database = com.lukebusch.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao( Batch.class );
    }

    /**
     * Verifies that getById works as expected
     */
    @Test
    void getByIdSuccess() {

        Batch retrievedBatch = (Batch)genericDao.getById(1);
        Batch shouldBeIdenticalBatch = new Batch("batch title", "recipe name"
                    , LocalDate.of(2019, 3, 1)
                    , LocalDate.of(2019,3,6)
                    , LocalDate.of(2019,4,20)
                    , LocalDate.of(2019, 10, 20)
                    , 1.105
                    , 1.055
        );
        // Don't forget to set the id!
        shouldBeIdenticalBatch.setId(1);

        assertEquals(retrievedBatch, shouldBeIdenticalBatch);
    }

    /**
     * Verifies update functions
     */
    @Test
    void saveOrUpdateSuccess() {
        // get a batch, change its value, save it back to the database
        Batch batchToModify = (Batch) genericDao.getById(1);
        String originalBatchTitle = batchToModify.getTitle();

        batchToModify.setTitle("Jose");
        genericDao.saveOrUpdate(batchToModify);

        // get the same batch, verify that the author field has changed
        Batch modifiedBatch = (Batch) genericDao.getById(1);

        assertNotEquals(originalBatchTitle, modifiedBatch.getTitle());
    }

    /**
     * verifies insert function
     */
    @Test
    void insertSuccess() {

        Batch testBatch = new Batch("White Spotted Dog", "porter", LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 1), 1.055, 1.043);

        // grab the id of the newly added batch, use it to verify the new batch was created
        int newId = genericDao.insert(testBatch);

        Batch anotherTestBatch = (Batch) genericDao.getById(newId);
        assertEquals(testBatch, anotherTestBatch);
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

        genericDao.delete(batchToDelete);

        Batch deletedBatch = (Batch) genericDao.getById(1);

        assertNull(deletedBatch);
    }

    /**
     * tests getAll feature of DAO
     */
    @Test
    void getAllSuccess() {
        // get all the batches
        // make sure there are the proper number of batches
        List<Batch> batches = genericDao.getAll();
        assertEquals(batches.size(), 3);
    }

}
