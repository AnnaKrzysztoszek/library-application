package pl.com.bottega.libraryapp.application;

import pl.com.bottega.libraryapp.model.AddBookToLibraryCommand;
import pl.com.bottega.libraryapp.model.Book;
import pl.com.bottega.libraryapp.model.bookid.BookId;

import java.util.List;

public interface BookProcess {

    Book addBookToLibrary(AddBookToLibraryCommand cmd);

    void removeBookFromLibrary(Book book);

    BookSearchResult listAllBooks();
}
