package pl.visa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/add")
    public String add(){
        Book book = new Book();
        book.setTitle("Thinking in Java");
        bookDao.saveBook(book);
        return "ok";
    }

}
