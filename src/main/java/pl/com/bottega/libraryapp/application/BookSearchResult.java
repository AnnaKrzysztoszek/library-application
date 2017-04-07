package pl.com.bottega.libraryapp.application;

import pl.com.bottega.libraryapp.application.dto.BookDto;

import java.util.List;

public class BookSearchResult {

    private List<BookDto> books;
    private Integer availableBooks;
    private Integer rentBooks;

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    public Integer getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(Integer availableBooks) {
        this.availableBooks = availableBooks;
    }

    public Integer getRentBooks() {
        return rentBooks;
    }

    public void setRentBooks(Integer rentBooks) {
        this.rentBooks = rentBooks;
    }
}
