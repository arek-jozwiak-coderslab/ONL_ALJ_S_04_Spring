package pl.visa.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByPublisherId(Long id);

    @Query("select b from Book b where b.title=?1")
    List<Book> findWithQueryByTitle(String title);

    @Query("select b from Book b where b.category=?1")
    List<Book> findWithQueryByCategory(Category category);
}
