package pl.visa.book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    public List<Book> findAll(){
        TypedQuery<Book> selectBFromBookB = entityManager.createQuery("select b from Book b", Book.class);
        return selectBFromBookB.getResultList();
    }

    public List<Book> findAll2(){
        List<Book> books = entityManager.createQuery("select b from Book b", Book.class)
                .getResultList();
        return books;
    }

    public List<Book> findAllByRating(int rating){
        Query selectBFromBookB = entityManager.createQuery("select b from Book b where b.rating = :rat", Book.class);
        selectBFromBookB.setParameter("rat", rating);
        return selectBFromBookB.getResultList();
    }

}
