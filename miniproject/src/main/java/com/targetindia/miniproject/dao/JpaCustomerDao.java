package com.targetindia.miniproject.dao;

import com.targetindia.miniproject.model.Customer;
import com.targetindia.miniproject.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class JpaCustomerDao implements CustomerDao {
    @Override
    public Customer save(Customer customer) throws DaoException {
        try (var em = JpaUtil.createEntityManager()) {
            var tx = em.getTransaction();
            tx.begin();
            try {
                em.persist(customer);
                tx.commit();
                return customer;
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getById(int id) throws DaoException {
        return null;
    }

    @Override
    public void update(Customer customer) throws DaoException {

    }

    @Override
    public Customer deleteById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<Customer> getAll() throws DaoException {
        try (var em = JpaUtil.createEntityManager()) {
            return em.createQuery("from Customer", Customer.class)
                    .getResultList();
        } catch (Exception e) {
            log.warn("error while calling JpaCustomerDao.getAll()", e);
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
        return null;
    }

    @Override
    public Customer getByPhone(String phone) throws DaoException {
        return null;
    }

    @Override
    public List<Customer> getByCity(String city) throws DaoException {
        return null;
    }
}
