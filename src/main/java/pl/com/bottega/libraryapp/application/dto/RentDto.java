package pl.com.bottega.libraryapp.application.dto;

import pl.com.bottega.libraryapp.model.Book;
import pl.com.bottega.libraryapp.model.Customer;

import java.time.LocalDateTime;

public class RentDto {

    private Long rentId;
    private Customer customer;
    private Book book;
    private LocalDateTime rentBookDate;
    private LocalDateTime returnBookDate;

    public Long getRentId() {
        return rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getRentBookDate() {
        return rentBookDate;
    }

    public void setRentBookDate(LocalDateTime rentBookDate) {
        this.rentBookDate = rentBookDate;
    }

    public LocalDateTime getReturnBookDate() {
        return returnBookDate;
    }

    public void setReturnBookDate(LocalDateTime returnBookDate) {
        this.returnBookDate = returnBookDate;
    }
}
