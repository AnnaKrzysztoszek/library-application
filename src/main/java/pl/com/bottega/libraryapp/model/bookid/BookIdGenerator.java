package pl.com.bottega.libraryapp.model.bookid;

public class BookIdGenerator implements IdGenerator {

    private IdGenerator idGenerator;

    public BookIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public BookId generate() {
        BookId bookId = idGenerator.generate();

        String id = bookId.getBookId();
        return new BookId("ID:" + id);
    }

}
