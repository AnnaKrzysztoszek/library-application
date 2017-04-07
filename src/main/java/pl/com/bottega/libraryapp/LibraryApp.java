package pl.com.bottega.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LibraryApp {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(LibraryApp.class, args);
    }
}
