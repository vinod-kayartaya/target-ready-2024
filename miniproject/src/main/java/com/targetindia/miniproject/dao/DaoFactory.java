package com.targetindia.miniproject.dao;

import java.util.ResourceBundle;

public final class DaoFactory {

    private DaoFactory() {
    }

    private static final String CUSTOMER_DAO_IMPL;

    static {
        // read the dao-config.properties
        ResourceBundle rb = ResourceBundle.getBundle("dao-config");
        // store the name of the implementation clas in a static variable
        CUSTOMER_DAO_IMPL = rb.getString("com.targetindia.miniproject.dao.customer-dao.impl");
    }
    public static CustomerDao getCustomerDao() throws DaoException {
        try {
            return (CustomerDao) Class.forName(CUSTOMER_DAO_IMPL)
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
