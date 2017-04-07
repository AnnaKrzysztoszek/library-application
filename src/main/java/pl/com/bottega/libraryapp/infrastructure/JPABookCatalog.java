package pl.com.bottega.libraryapp.infrastructure;

import pl.com.bottega.libraryapp.application.BookCatalog;
import pl.com.bottega.libraryapp.application.dto.BookDto;
import pl.com.bottega.libraryapp.application.BookQuery;
import pl.com.bottega.libraryapp.application.BookSearchResult;
import pl.com.bottega.libraryapp.model.Book;
import pl.com.bottega.libraryapp.model.bookid.BookId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class JPABookCatalog implements BookCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BookSearchResult find(BookQuery bookQuery) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        BookSearchResult results = new BookSearchResult();

        List<BookDto> dtos = queryBooks(bookQuery, criteriaBuilder);
        results.setBooks(dtos);
        return results;
    }

    private List<BookDto> queryBooks(BookQuery bookQuery, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        Set<Predicate> predicates = createPredicates(bookQuery, criteriaBuilder, root);
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        Query query = entityManager.createQuery(criteriaQuery);
        // TODO
        return null;
    }

    private Set<Predicate> createPredicates(BookQuery bookQuery, CriteriaBuilder criteriaBuilder, Root<Book> root) {
        return null;
    }

    @Override
    public BookDto get(BookId bookId) {
        Query query = entityManager.createQuery("FROM BookId b WHERE b.bookId = :bookId");
        query.setParameter("bookId", bookId);
        Book book = (Book) query.getResultList().get(0);
        BookDto bookDto = createDocumentDto(book);
        return bookDto;
    }

    private BookDto createDocumentDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setBookId(book.getBookId().getBookId());
        bookDto.setBookTitle(book.getBookTitle());
        bookDto.setBookAuthor(book.getBookAuthor());
        bookDto.setPublishYear(book.getPublishYear());
        bookDto.setBookStatus(book.getBookStatus().name());
        return bookDto;
    }
}
