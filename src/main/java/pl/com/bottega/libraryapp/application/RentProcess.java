package pl.com.bottega.libraryapp.application;

import pl.com.bottega.libraryapp.model.Customer;
import pl.com.bottega.libraryapp.model.bookid.BookId;

public interface RentProcess {

    void rentBook(BookId bookId, Customer customer);

    void returnBook(BookId bookId, Customer customer);
}
