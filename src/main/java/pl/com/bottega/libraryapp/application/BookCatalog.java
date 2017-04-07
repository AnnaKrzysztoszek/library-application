package pl.com.bottega.libraryapp.application;

import pl.com.bottega.libraryapp.application.dto.BookDto;
import pl.com.bottega.libraryapp.model.bookid.BookId;

public interface BookCatalog {

    BookSearchResult find(BookQuery bookQuery);

    BookDto get(BookId bookId);

}
