package pl.com.bottega.libraryapp.infrastructure;

import pl.com.bottega.libraryapp.model.Customer;
import pl.com.bottega.libraryapp.model.CustomerNotFoundException;
import pl.com.bottega.libraryapp.model.repository.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPACustomerRepository implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void put(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer get(Long customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        if (customer == null)
            throw new CustomerNotFoundException(customer.getCustomerId());
        return customer;
    }
}
