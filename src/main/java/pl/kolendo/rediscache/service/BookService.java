package pl.kolendo.rediscache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pl.kolendo.rediscache.model.Book;
import pl.kolendo.rediscache.repository.BookRepository;
import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "bc")
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Cacheable
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Cacheable(key = "#id")
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @CachePut(key = "#book.id")
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @CacheEvict(key = "#id")
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
