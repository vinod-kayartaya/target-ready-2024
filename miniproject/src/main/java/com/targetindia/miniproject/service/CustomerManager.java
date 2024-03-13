package com.targetindia.miniproject.service;

import com.targetindia.miniproject.dao.ArrayListCustomerDao;
import com.targetindia.miniproject.dao.CustomerDao;
import com.targetindia.miniproject.dao.DaoException;
import com.targetindia.miniproject.model.Customer;

import java.util.List;

public class CustomerManager {

    // this class has a dependency on an object of CustomerDao
    private CustomerDao dao;

    public CustomerManager() {
        // tight coupling of dependency
        // must be converted to a loose coupling
        this.dao = new ArrayListCustomerDao();
    }

    public List<Customer> getAll() throws ServiceException {
        try {
            return dao.getAll();
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}
