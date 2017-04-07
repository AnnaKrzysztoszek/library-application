package pl.com.bottega.libraryapp.model;

import pl.com.bottega.libraryapp.model.bookid.BookId;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(BookId bookId) {
        super(String.format("Book with ID %s does not exist", bookId.getBookId()));
    }
}
