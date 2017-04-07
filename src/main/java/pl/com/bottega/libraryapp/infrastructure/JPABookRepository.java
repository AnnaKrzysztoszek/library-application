package pl.com.bottega.libraryapp.infrastructure;

import pl.com.bottega.libraryapp.application.BookQuery;
import pl.com.bottega.libraryapp.model.Book;
import pl.com.bottega.libraryapp.model.BookNotFoundException;
import pl.com.bottega.libraryapp.model.repository.BookRepository;
import pl.com.bottega.libraryapp.model.bookid.BookId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JPABookRepository implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void put(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book get(BookId bookId) {
        Book book = entityManager.find(Book.class, bookId);
        if (book == null)
            throw new BookNotFoundException(bookId);
        return book;
    }

    @Override
    public void remove(Book book) {
        Query query = entityManager.createQuery("DELETE FROM Book b WHERE b.bookId = :bookId");
        query.setParameter("bookId", book);
        query.executeUpdate();
    }

    @Override
    public List<Book> listAllBooks() {
        Query query = entityManager.createQuery("FROM Book b");
        return query.getResultList();
    }

    @Override
    public List<Book> search(BookQuery bookQuery) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.where();
        //TODO
        return null;
    }
}
