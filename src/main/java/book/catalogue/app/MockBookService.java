package book.catalogue.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.*;

import book.catalogue.model.Book;
import org.springframework.stereotype.Component;

@Component
public class MockBookService implements BookService {
    private List<Book> list;
    private static Long nextId = 4L;
    private BookService bookService;

    public static Long getNextId() {
        return nextId;
    }



    public static void setNextId(Long nextId) {
        MockBookService.nextId = nextId;
    }

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Optional<Book> get(Long id) {
        return list.stream().filter(item -> item.getId()==(id)).findFirst();
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        list.add(book);
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            list.remove(this.get(id).get());
        }
    }

    @Override
    public void update(Book book) {
        if (this.get(book.getId()).isPresent()) {
            int indexOf = list.indexOf(this.get(book.getId()).get());
            list.set(indexOf, book);
            }
    }
}
