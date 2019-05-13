package com.lukebusch.util;

import com.lukebusch.persistence.GenericDao;

/**
 * A class to create Generic Dao objects
 *
 * @author lbusch - with a nod to Paula Waite
 */
public class DaoFactory {

    private DaoFactory() {

    }

    /**
     * Create dao generic dao.
     *
     * @param type the type
     * @return the generic dao
     */
    public static GenericDao createDao(Class type) {
        return new GenericDao(type);
    }
}
