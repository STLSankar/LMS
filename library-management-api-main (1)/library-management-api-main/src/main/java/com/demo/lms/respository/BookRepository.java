package com.demo.lms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.lms.model.Book;

import java.util.Optional;

/**
 * @author sankar patra
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByISBN(String isbn);
}
