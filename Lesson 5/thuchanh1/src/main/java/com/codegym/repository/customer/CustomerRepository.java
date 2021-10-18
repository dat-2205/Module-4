package com.codegym.repository.customer;

import com.codegym.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        String queryStr = "select c from Customer as c";
        TypedQuery<Customer> query = em.createQuery(queryStr,Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer find(Long id) {
        String queryStr = "select c from Customer as c where c.id = ?1";
        TypedQuery<Customer> query = em.createQuery(queryStr,Customer.class);
        query.setParameter(1,id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        if(customer.getId()!=null) {
            em.merge(customer);
        }else {
            em.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = find(id);
        if (customer != null) {
            em.remove(customer);
        }
    }
}
