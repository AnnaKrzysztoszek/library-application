package pl.com.bottega.libraryapp.model.repository;

import pl.com.bottega.libraryapp.model.Customer;

public interface CustomerRepository {

    void put(Customer customer);

    Customer get(Long customerId);
}
