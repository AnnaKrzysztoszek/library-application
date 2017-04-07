package pl.com.bottega.libraryapp.model;

import pl.com.bottega.libraryapp.model.bookid.BookId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Entity
public class Book {

    @EmbeddedId
    private BookId bookId;

    private String bookTitle;

    private LocalDateTime publishYear;

    private String bookAuthor;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    private Customer customer;

    Book() {}

    public Book(AddBookToLibraryCommand cmd) {
        this.bookId = new BookId(bookId.getBookId());
        this.bookTitle = cmd.getBookTitle();
        this.publishYear = cmd.getPublishYear();
        this.bookAuthor = cmd.getBookAuthor();
        this.bookStatus = BookStatus.AVAILABLE;
    }

    public void rentBook() {
        this.bookStatus = BookStatus.RENTED;
        this.customer = new Customer(new CreateCustomerCommand());
    }

    public void returnBook() {
        this.bookStatus = BookStatus.AVAILABLE;
        this.customer = null;
    }

    public BookId getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public LocalDateTime getPublishYear() {
        return publishYear;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public Customer getCustomer() {
        return customer;
    }
}
