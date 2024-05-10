package com.targetindia.miniproject.dao;

import com.targetindia.miniproject.model.Customer;
import com.targetindia.miniproject.utils.IdGenerator;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class CsvFileCustomerDao implements CustomerDao {

    private Map<Integer, Customer> customerMap = new LinkedHashMap<>();
    private static final String FILENAME = "customers.csv";

    public CsvFileCustomerDao() {
        loadFromFile();
    }

    private void loadFromFile() {
        try (
                FileReader file = new FileReader(FILENAME);
                BufferedReader in = new BufferedReader(file);
        ) {
            in.readLine(); // skip the first line which is header
            String line;
            while((line=in.readLine())!=null){
                Customer customer = fromCsv(line);
                customerMap.put(customer.getId(), customer);
            }
        } catch (Exception e) {
            log.warn("error while loading CSV content into customerMap");
        }
    }

    private void saveToFile() {
        try (
                FileWriter file = new FileWriter(FILENAME);
                PrintWriter out = new PrintWriter(file);
        ) {
            out.println("ID,Name,City,Email,Phone");
            customerMap.values()
                    .stream()
                    .map(this::toCsv)
                    .forEach(out::println);

        } catch (Exception e) {
            log.warn("error trying to save customer data into csv file", e);
        }

    }

    private Customer fromCsv(String line) {
        try {
            var arr = line.split(",");
            return new Customer(
                    Integer.parseInt(arr[0]),
                    arr[1],
                    arr[2],
                    arr[3],
                    arr[4]
            );
        } catch (NumberFormatException e) {
            log.warn("error trying to convert csv to Customer object", e);
            return null;
        }
    }

    private String toCsv(Customer customer) {
        if (customer == null) {
            return null;
        }
        return String.format("%s,%s,%s,%s,%s",
                customer.getId(),
                customer.getName(),
                customer.getCity(),
                customer.getEmail(),
                customer.getPhone());
    }

    @Override
    public Customer save(Customer customer) throws DaoException {
        try {
            customer.setId(IdGenerator.generate());
            customerMap.put(customer.getId(), customer);
            saveToFile();
            return customer;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getById(int id) throws DaoException {
        try {
            return customerMap.get(id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Customer customer) throws DaoException {
        try {
            if (customerMap.containsKey(customer.getId())) {
                customerMap.put(customer.getId(), customer);
                saveToFile();
                return;
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }

        throw new DaoException("customer data not found for id " + customer.getId());
    }

    @Override
    public Customer deleteById(int id) throws DaoException {
        try {
            if (customerMap.containsKey(id)) {
                var customer = customerMap.get(id);
                customerMap.remove(id);
                saveToFile();
                return customer;
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }

        throw new DaoException("customer data not found for id " + id);
    }

    @Override
    public List<Customer> getAll() throws DaoException {
        try {
            return customerMap.values().stream().toList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
        try {
            return customerMap.values()
                    .stream()
                    .filter(customer -> customer.getEmail().equals(email))
                    .findFirst()
                    .orElseThrow();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getByPhone(String phone) throws DaoException {
        try {
            return customerMap.values()
                    .stream()
                    .filter(customer -> customer.getPhone().equals(phone))
                    .findFirst()
                    .orElseThrow();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Customer> getByCity(String city) throws DaoException {
        try {
            return customerMap.values()
                    .stream()
                    .filter(customer -> customer.getCity().equals(city))
                    .toList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
