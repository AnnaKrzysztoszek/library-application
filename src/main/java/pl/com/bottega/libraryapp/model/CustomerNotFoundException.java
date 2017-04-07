package pl.com.bottega.libraryapp.model;

/**
 * Created by anna on 06.04.2017.
 */
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super(String.format("Customer with ID %s does not exist", id));
    }
}
