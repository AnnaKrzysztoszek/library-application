package pl.com.bottega.libraryapp.model.repository;

import pl.com.bottega.libraryapp.application.BookQuery;
import pl.com.bottega.libraryapp.model.Book;
import pl.com.bottega.libraryapp.model.bookid.BookId;

import java.util.List;

public interface BookRepository {

    void put(Book book);

    Book get(BookId bookId);

    void remove(Book book);

    List<Book> listAllBooks();

    List<Book> search(BookQuery bookQuery);

}
