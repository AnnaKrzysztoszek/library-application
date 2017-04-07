package pl.com.bottega.libraryapp.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import pl.com.bottega.libraryapp.application.BookProcess;
import pl.com.bottega.libraryapp.application.RentProcess;
import pl.com.bottega.libraryapp.application.impl.StandardBookProcess;
import pl.com.bottega.libraryapp.application.impl.StandardRentProcess;
import pl.com.bottega.libraryapp.model.BookFactory;
import pl.com.bottega.libraryapp.model.Customer;
import pl.com.bottega.libraryapp.model.bookid.BookIdGenerator;
import pl.com.bottega.libraryapp.model.bookid.IdGenerator;
import pl.com.bottega.libraryapp.model.bookid.RandomBookIdGenerator;
import pl.com.bottega.libraryapp.model.repository.BookRepository;
import pl.com.bottega.libraryapp.model.repository.CustomerRepository;
import pl.com.bottega.libraryapp.model.repository.RentRepository;

@org.springframework.context.annotation.Configuration
@EnableAsync
public class Configuration extends AsyncConfigurerSupport {

    @Bean
    public BookProcess bookProcess(BookFactory bookFactory,
                                   BookRepository bookRepository,
                                   CustomerRepository customerRepository) {
        return new StandardBookProcess(bookFactory, bookRepository, customerRepository);
    }

    @Bean
    public RentProcess rentProcess(BookRepository bookRepository,
                                   CustomerRepository customerRepository,
                                   RentRepository rentRepository) {
        return new StandardRentProcess(bookRepository, customerRepository, rentRepository);
    }

    @Bean
    public BookFactory bookFactory(IdGenerator idGenerator) {
        return new BookFactory(idGenerator);
    }

    @Bean
    public IdGenerator idGenerator(
            @Value("${lms.qualitySystem}") String qualitySystem,
            Environment env
    ) {
        IdGenerator base;

        if (qualitySystem.equals("ID-random")) {
            base = new RandomBookIdGenerator();
        }
        else {
            throw new IllegalArgumentException("Uknown quality system");
        }

        if (hasProfile("ID", env)) {
            base = new BookIdGenerator(base);
        }

        return base;
    }

    private boolean hasProfile(String profile, Environment env) {
        for (String activeProfile : env.getActiveProfiles())
            if (activeProfile.equals(profile))
                return true;
        return false;
    }

    @Bean
    public BookRepository bookRepository() {
        return new JPABookRepository();
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new JPACustomerRepository();
    }

    @Bean
    public RentRepository rentRepository() {
        return new JPARentRepository();
    }
}
