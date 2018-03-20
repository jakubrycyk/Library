package com.umcs.library.book.controller;

import com.umcs.library.book.domain.Book;
import com.umcs.library.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public Optional<Book> findById(int id){
        return bookService.findById(id);
    }

    public List<Book> findAll() {
        return bookService.findAll();
    }

    public void insert(Book book) {
         bookService.insert(book);
    }

    public void deleteById(int id) {
         bookService.deleteById(id);
    }

    public void update(Book book) {
        bookService.update(book);
    }

    public long count() {
        return bookService.count();
    }

    public long getBorrowedCount(){
        return bookService.getBorrowedCount();
    }

    public long getNonBorrowedCount(){
        return bookService.getNonBorrowedCount();
    }
}
