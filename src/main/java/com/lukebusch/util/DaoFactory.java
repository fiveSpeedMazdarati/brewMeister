package com.lukebusch.util;

import com.lukebusch.persistence.GenericDao;
/**
 * A class to create Generic Dao objects
 * @author lbusch  - with a nod to Paula Waite
 */
public class DaoFactory {

    private DaoFactory() {

    }

    public static GenericDao createDao(Class type) {
        return new GenericDao(type);
    }
}
