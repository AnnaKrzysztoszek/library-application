package pl.com.bottega.libraryapp.model;

import java.time.LocalDateTime;

public class AddBookToLibraryCommand {

    private String bookTitle;

    private LocalDateTime publishYear;

    private String bookAuthor;

    private BookStatus bookStatus;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public LocalDateTime getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(LocalDateTime publishYear) {
        this.publishYear = publishYear;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
