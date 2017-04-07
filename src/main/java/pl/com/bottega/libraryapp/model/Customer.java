package pl.com.bottega.libraryapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;
    private String firstName;
    private String lastName;

    Customer() {}

    public Customer(CreateCustomerCommand cmd) {
        this.customerId = cmd.getCustomerId();
        this.firstName = cmd.getFirstName();
        this.lastName = cmd.getLastName();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
