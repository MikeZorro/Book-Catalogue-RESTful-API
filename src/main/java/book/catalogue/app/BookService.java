package book.catalogue.app;
import book.catalogue.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface BookService {
    List<Book> getBooks();
    Optional<Book> get(Long id);
    void add(Book book);
    void delete(Long id);
    void update(Book book);

}
