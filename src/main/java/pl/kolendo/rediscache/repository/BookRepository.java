package pl.kolendo.rediscache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kolendo.rediscache.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
