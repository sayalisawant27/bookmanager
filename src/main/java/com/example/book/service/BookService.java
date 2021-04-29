package com.example.book.service;

import com.example.book.exception.UserNotFoundException;
import com.example.book.model.Book;
import com.example.book.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book addBook(Book book){
        return bookRepo.save(book);
    }

    public List<Book> findAllBooks(){
        return bookRepo.findAll();
    }

    public Book updateBook(Book book){
        return bookRepo.save(book);
    }

    public Book findBookById(Long id){
        return bookRepo.findBookById(id).orElseThrow(()-> new UserNotFoundException("Book with id: "+id+" not found."));
    }

    public void deleteBook(Long id){
        bookRepo.deleteBookById(id);
    }

}
