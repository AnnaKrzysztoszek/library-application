package pl.com.bottega.libraryapp.application.impl;

import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.libraryapp.application.RentProcess;
import pl.com.bottega.libraryapp.model.Book;
import pl.com.bottega.libraryapp.model.RentInformation;
import pl.com.bottega.libraryapp.model.repository.BookRepository;
import pl.com.bottega.libraryapp.model.Customer;
import pl.com.bottega.libraryapp.model.bookid.BookId;
import pl.com.bottega.libraryapp.model.repository.CustomerRepository;
import pl.com.bottega.libraryapp.model.repository.RentRepository;

@Transactional
public class StandardRentProcess implements RentProcess {

    private BookRepository bookRepository;
    private CustomerRepository customerRepository;
    private RentRepository rentRepository;

    public StandardRentProcess(BookRepository bookRepository, CustomerRepository customerRepository, RentRepository rentRepository) {
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.rentRepository = rentRepository;
    }

    @Override
    public void rentBook(BookId bookId, Customer customer) {
        RentInformation rentInformation = new RentInformation(
                customerRepository.get(customer.getCustomerId()),
                bookRepository.get(bookId));
        rentRepository.put(rentInformation);
        bookRepository.get(bookId).rentBook();
    }

    @Override
    public void returnBook(BookId bookId, Customer customer) {
        bookRepository.get(bookId).returnBook();
        //TODO
    }
}
