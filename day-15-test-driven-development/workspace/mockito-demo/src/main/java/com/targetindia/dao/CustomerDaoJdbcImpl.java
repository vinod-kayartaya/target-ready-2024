package com.targetindia.dao;

import com.targetindia.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDaoJdbcImpl {
    // dependency
    private DataSource dataSource; // represents a connection pool

    public CustomerDaoJdbcImpl() {
    }

    // can be used for dependency injection
    public CustomerDaoJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // needed (if constructor is not there) for dependency injection
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addCustomer(Customer customer) {
        // basic validations:
        // 1. id/name/email are mandatory
        // 2. email is unique (should check in the db)

        if (customer.getId() == null ||
                customer.getName() == null ||
                customer.getName().isBlank() ||
                customer.getEmail() == null ||
                customer.getEmail().isBlank()) {
            throw new RuntimeException("id/name/email are mandatory fields");
        }

        String sql = "insert into customers values (?, ?, ?, ?)";
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1, customer.getId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getCity());

            stmt.executeUpdate();
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
