package pl.com.bottega.libraryapp.model.bookid;

import java.util.UUID;

public class RandomBookIdGenerator implements IdGenerator {

    @Override
    public BookId generate() {
        return new BookId("ID-random:" + UUID.randomUUID().toString());
    }

}
