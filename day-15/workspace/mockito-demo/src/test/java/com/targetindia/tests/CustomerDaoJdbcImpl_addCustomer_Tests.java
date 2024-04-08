package com.targetindia.tests;

import com.targetindia.dao.CustomerDaoJdbcImpl;
import com.targetindia.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerDaoJdbcImpl_addCustomer_Tests {

    @Mock
    DataSource dataSource;
    @Mock
    Connection conn;
    @Mock
    PreparedStatement stmt;

    @InjectMocks
    CustomerDaoJdbcImpl dao = new CustomerDaoJdbcImpl();


    @Test
    void testAddCustomerWithNullId() throws Exception {

        Customer c = new Customer();
        c.setId(null);
        c.setName("Vinod");
        c.setEmail("vinod@vinod.co");
        c.setCity("Bangalore");
        Assertions.assertThrows(RuntimeException.class, () -> {
            dao.addCustomer(c);
        });
    }


    @Test
    void testAddCustomerWithEmptyName() throws Exception {

        Customer c = new Customer();
        c.setId(12312);
        c.setName("   ");
        c.setEmail("vinod@vinod.co");
        c.setCity("Bangalore");

        Assertions.assertThrows(RuntimeException.class, () -> {
            dao.addCustomer(c);
        });

    }

    @Test
    void testAddValidCustomer() throws Exception {

        Customer c = new Customer();
        c.setId(12312);
        c.setName("Vinod");
        c.setEmail("vinod@vinod.co");
        c.setCity("Bangalore");
        String sql = "insert into customers values (?, ?, ?, ?)";
        when(dataSource.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(sql)).thenReturn(stmt);
        try {
            dao.addCustomer(c);
        } catch (RuntimeException e) {
            e.printStackTrace();

            Assertions.fail("was not expecting any exception");
        }
    }

    @Test
    void testAddCustomerWithDuplicateEmail() throws Exception {

        Customer c = new Customer();
        c.setId(12312);
        c.setName("Vinod");
        c.setEmail("vinod@vinod.co"); // duplicate email
        c.setCity("Bangalore");
        String sql = "insert into customers values (?, ?, ?, ?)";
        when(dataSource.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(sql)).thenReturn(stmt);
        when(stmt.executeUpdate()).thenThrow(new SQLException("duplicate email"));

        try {
            dao.addCustomer(c);
        } catch (RuntimeException e) {
            Assertions.assertEquals("duplicate email", e.getCause().getMessage());
        }
    }


}
