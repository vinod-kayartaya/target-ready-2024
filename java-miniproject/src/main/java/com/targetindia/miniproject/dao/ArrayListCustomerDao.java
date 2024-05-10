package com.targetindia.miniproject.dao;

import com.targetindia.miniproject.model.Customer;
import com.targetindia.miniproject.utils.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCustomerDao implements CustomerDao {

    private List<Customer> customers = new ArrayList<>();

    public ArrayListCustomerDao() {
        customers.add(new Customer(1, "Vinod Kumar", "Bangalore", "vinod@vinod.co", "9731424784"));
        customers.add(new Customer(2, "John Doe", "Dallas", "jd@xmpl.com", "5567424784"));
    }

    @Override
    public Customer save(Customer customer) throws DaoException {
//        int maxId = 0;
//        for (Customer c : customers) {
//            if (c.getId() > maxId) {
//                maxId = c.getId();
//            }
//        }
//        maxId++;
        int maxId = customers // list of customers
                .stream() // stream of customers
                .map(c -> c.getId()) // stream of integers (ids)
                .max(Integer::compareTo)
                .get() + 1;

        customer.setId(maxId);
        customers.add(customer);

        return customer;
    }

    @Override
    public Customer getById(int id) throws DaoException {
//        for (Customer c : customers) {
//            if (c.getId() == id) {
//                return c;
//            }
//        }
        return customers
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Customer customer) throws DaoException {
        boolean found = false;
        for (int i = 0, j = customers.size(); i < j; i++) {
            Customer c = customers.get(i);
            if (c.getId() == customer.getId()) {
                customers.set(i, customer);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new DaoException("customer data not found for id " + customer.getId());
        }
    }

    @Override
    public Customer deleteById(int id) throws DaoException {
        Customer customer = this.getById(id);
        if (customer == null) {
            throw new DaoException("No customer found for id " + id);
        }

        this.customers = this.customers.stream()
                .filter(c -> c.getId() != id)
                .toList();

        return customer;
    }

    @Override
    public List<Customer> getAll() throws DaoException {
        return this.customers;
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
        return customers
                .stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer getByPhone(String phone) throws DaoException {
        return customers
                .stream()
                .filter(c -> c.getPhone().equals(phone))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> getByCity(String city) throws DaoException {
        return customers
                .stream()
                .filter(c -> c.getCity().equals(city))
                .toList();
    }
}
