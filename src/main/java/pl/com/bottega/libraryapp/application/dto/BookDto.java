package pl.com.bottega.libraryapp.application.dto;

import java.time.LocalDateTime;

public class BookDto {

    private String bookId;
    private String bookTitle;
    private LocalDateTime publishYear;
    private String bookAuthor;
    private String bookStatus;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

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

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
}
