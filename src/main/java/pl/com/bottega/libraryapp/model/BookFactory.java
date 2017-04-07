package pl.com.bottega.libraryapp.model;

import pl.com.bottega.libraryapp.model.bookid.IdGenerator;

public class BookFactory {

    private IdGenerator idGenerator;

    public BookFactory(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Book addBook(AddBookToLibraryCommand cmd) {
        return new Book(cmd);
    }
}
