package com.lukebusch.persistence;

import com.lukebusch.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {

    /**
     * The Dao.
     */
    GenericDao genericDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {

        com.lukebusch.test.util.Database database = com.lukebusch.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao( Role.class );
    }


    @Test
    void getById() {

        Role role = (Role) genericDao.getById(2);
        assertEquals("registered_user", role.getRoleName());
    }

    @Test
    @Ignore("Insert is working, but cleandb script is not behaving properly.")
    void insert() {

        Role newRole = new Role(null, "administrator", "lbusch");
        int newId = genericDao.insert(newRole);

        assertEquals(4, newId);
    }

    @Test
    void getByProperty() {


    }
}