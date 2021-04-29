package com.example.book.repo;

import com.example.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book,String> {

    void deleteBookById(Long id);

    Optional<Book> findBookById(Long id);
}
