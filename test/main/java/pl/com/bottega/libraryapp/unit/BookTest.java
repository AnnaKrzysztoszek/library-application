package pl.com.bottega.libraryapp.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pl.com.bottega.libraryapp.model.AddBookToLibraryCommand;
import pl.com.bottega.libraryapp.model.Book;
import pl.com.bottega.libraryapp.model.BookStatus;
import pl.com.bottega.libraryapp.model.bookid.BookId;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BookTest {

    @Test
    public void shouldBeAvailableAfterAddToLibrary() {
        Book book = given().newBook();

        assertEquals(BookStatus.AVAILABLE, book.getBookStatus());
    }

    @Test
    public void shouldHaveStatusRentedAfterRent() {
        //TODO
        //Book book =
        //assertEquals(BookStatus.RENTED, book.getBookStatus());
    }

    @Test
    public void shouldGenerateIdOnAdd() {
        Book book = given().newBook();

        assertEquals(new BookId("1"), book.getBookId());
    }

    private DocumentAssembler given() {
        return new DocumentAssembler();
    }

    class DocumentAssembler {

        public Book newBook() {
            AddBookToLibraryCommand addBookToLibraryCommand = new AddBookToLibraryCommand();
            addBookToLibraryCommand.setBookAuthor("Jane Austen");
            addBookToLibraryCommand.setBookTitle("Pride and Prejudice");
            addBookToLibraryCommand.setPublishYear(LocalDateTime.parse("1813"));
            addBookToLibraryCommand.setBookStatus(BookStatus.AVAILABLE);
            return new Book(addBookToLibraryCommand);
        }

    }
}
