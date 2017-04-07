package pl.com.bottega.libraryapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RentInformation {

    @Id
    @GeneratedValue
    private Long rentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId")
    private Book book;

    private LocalDateTime rentBookDate;
    private LocalDateTime returnBookDate;

    RentInformation() {}

    public RentInformation(Customer customer, Book book) {
        this.customer = customer;
        this.book = book;
        this.rentBookDate = LocalDateTime.now();
    }

    public Long getRentId() {
        return rentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public LocalDateTime getRentBookDate() {
        return rentBookDate;
    }

    public LocalDateTime getReturnBookDate() {
        return returnBookDate;
    }
}
