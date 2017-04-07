package pl.com.bottega.libraryapp.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.libraryapp.application.RentProcess;
import pl.com.bottega.libraryapp.model.AddBookToLibraryCommand;
import pl.com.bottega.libraryapp.model.Book;
import pl.com.bottega.libraryapp.model.CreateCustomerCommand;
import pl.com.bottega.libraryapp.model.Customer;
import pl.com.bottega.libraryapp.model.bookid.BookId;
import pl.com.bottega.libraryapp.model.repository.BookRepository;
import pl.com.bottega.libraryapp.model.repository.CustomerRepository;
import pl.com.bottega.libraryapp.model.repository.RentRepository;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class RentProcessTest {

    @Autowired
    private RentProcess rentProcess;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RentRepository rentRepository;

    @Test
    public void shouldRentBook() {
        AddBookToLibraryCommand addBookToLibraryCommand = addBook();

        Book book = new Book(addBookToLibraryCommand);
        bookRepository.put(book);

        CreateCustomerCommand createCustomerCommand = new CreateCustomerCommand();
        createCustomerCommand.setFirstName("John");
        createCustomerCommand.setLastName("Snow");

        Customer customer = new Customer(createCustomerCommand);
        customerRepository.put(customer);

        rentProcess.rentBook(book.getBookId(), customer);

        assertThat(book.getBookStatus()).isEqualTo("RENT");
    }

    private AddBookToLibraryCommand addBook() {
        AddBookToLibraryCommand addBookToLibraryCommand = new AddBookToLibraryCommand();
        addBookToLibraryCommand.setBookAuthor("Jane Austen");
        addBookToLibraryCommand.setBookTitle("Pride and Prejudice");
        addBookToLibraryCommand.setPublishYear(LocalDateTime.parse("1813"));
        return addBookToLibraryCommand;
    }

    @Test
    public void shouldReturnBook() {
        //TODO
        //assertThat(book.getBookId()).isEqualTo("AVAILABLE");
    }
}
