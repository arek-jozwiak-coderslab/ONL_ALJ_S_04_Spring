package pl.visa.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/add")
    public String add() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        bookDao.saveBook(book);

        Book byId = bookDao.findById(1);
        System.out.println(byId.getId());
        byId.setRatingBook(12);
        bookDao.update(byId);
        return "ok";
    }

    @GetMapping("/get/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookDao.findById(id);
    }

    @GetMapping("/get-new")
    public Book getNewBook() {
        return new Book();
    }


    @GetMapping("/all")
    public List<Book> allBooks() {
        return bookDao.findAll();
    }

}
