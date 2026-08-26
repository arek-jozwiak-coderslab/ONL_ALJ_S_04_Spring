package pl.visa.book;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final BookService bookService;
    private final Validator validator;

    public BookController(BookDao bookDao, PublisherDao publisherDao, BookService bookService, Validator validator) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.bookService = bookService;
        this.validator = validator;
    }

    @GetMapping("/add")
    public String add() {

        Publisher publisher = new Publisher();
        publisher.setName("p");

        Set<ConstraintViolation<Publisher>> validate = validator.validate(publisher);
        if (validate.isEmpty()) {
            publisherDao.save(publisher);

            Book book = new Book();
            book.setTitle("Thinking in Java");
            book.setPublisher(publisher);


            bookService.save(book);

            Book byId = bookDao.findById(1);
            System.out.println(byId.getId());
            byId.setRating(12);
            bookDao.update(byId);
        }else {
            for (ConstraintViolation<Publisher> pcv : validate) {
                log.info("error w: {} , message {}" , pcv.getPropertyPath(), pcv.getMessage() );
            }
        }


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
        return bookService.findAll();
    }

}
