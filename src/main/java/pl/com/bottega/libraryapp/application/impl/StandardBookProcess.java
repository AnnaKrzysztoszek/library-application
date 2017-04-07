package pl.com.bottega.libraryapp.application.impl;

import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.libraryapp.application.BookProcess;
import pl.com.bottega.libraryapp.application.BookSearchResult;
import pl.com.bottega.libraryapp.model.AddBookToLibraryCommand;
import pl.com.bottega.libraryapp.model.Book;
import pl.com.bottega.libraryapp.model.BookFactory;
import pl.com.bottega.libraryapp.model.Customer;
import pl.com.bottega.libraryapp.model.bookid.BookId;
import pl.com.bottega.libraryapp.model.repository.BookRepository;
import pl.com.bottega.libraryapp.model.repository.CustomerRepository;

@Transactional
public class StandardBookProcess implements BookProcess {

    private BookFactory bookFactory;
    private BookRepository bookRepository;
    private CustomerRepository customerRepository;

    public StandardBookProcess(BookFactory bookFactory, BookRepository bookRepository, CustomerRepository customerRepository) {
        this.bookFactory = bookFactory;
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Book addBookToLibrary(AddBookToLibraryCommand cmd) {
        Book book = bookFactory.addBook(cmd);
        bookRepository.put(book);
        return book;
    }

    @Override
    public void removeBookFromLibrary(Book book) {
        bookRepository.remove(book);
    }

    @Override
    public BookSearchResult listAllBooks() {
        return null;
    }
}
