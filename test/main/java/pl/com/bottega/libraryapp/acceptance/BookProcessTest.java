package pl.com.bottega.libraryapp.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.libraryapp.application.BookCatalog;
import pl.com.bottega.libraryapp.application.BookProcess;
import pl.com.bottega.libraryapp.application.dto.BookDto;
import pl.com.bottega.libraryapp.model.AddBookToLibraryCommand;
import pl.com.bottega.libraryapp.model.Book;
import pl.com.bottega.libraryapp.model.BookStatus;
import pl.com.bottega.libraryapp.model.bookid.BookId;
import pl.com.bottega.libraryapp.model.repository.BookRepository;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class BookProcessTest {

    @Autowired
    BookProcess bookProcess;

    @Autowired
    BookCatalog bookCatalog;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void shouldAddBookToLibrary() {
        Book book = addBook();

        BookDto dto = bookCatalog.get(book.getBookId());
        assertThat(dto.getBookId()).isEqualTo(book.getBookId());
        assertThat(dto.getBookAuthor()).isEqualTo("Jane Austen");
        assertThat(dto.getBookTitle()).isEqualTo("Pride and Prejudice");
        assertThat(dto.getPublishYear()).isEqualTo(LocalDateTime.parse("1813"));
        assertThat(dto.getBookStatus()).isEqualTo(BookStatus.AVAILABLE);
    }

    @Test
    public void shouldRemoveBookFromLibrary() {
        Book book = addBook();

        bookProcess.removeBookFromLibrary(book);
        assertThat(bookRepository.get(book.getBookId())).isNull();
    }

    @Test
    public void shouldListAllBooks(){
        //TODO
    }

    private Book addBook() {
        AddBookToLibraryCommand addBookToLibraryCommand = new AddBookToLibraryCommand();
        addBookToLibraryCommand.setBookAuthor("Jane Austen");
        addBookToLibraryCommand.setBookTitle("Pride and Prejudice");
        addBookToLibraryCommand.setPublishYear(LocalDateTime.parse("1813"));
        addBookToLibraryCommand.setBookStatus(BookStatus.AVAILABLE);
        return bookProcess.addBookToLibrary(addBookToLibraryCommand);
    }
}
