package com.umcs.library.book.controller;

import com.umcs.library.book.domain.Book;
import com.umcs.library.book.service.BookService;

import java.util.List;

public class BookController {

    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public Book findById(int id){
        return bookService.findById(id);
    }

    public List<Book> findAll() {
        return bookService.findAll();
    }

    public int insert(Book book) {
        return bookService.insert(book);
    }

    public int deleteById(int id) {
        return bookService.deleteById(id);
    }

    public int update(Book book) {
        return bookService.update(book);
    }

    public int count() {
        return bookService.count();
    }

    public int getBorrowedCount(){
        return bookService.getBorrowedCount();
    }

    public int getNonBorrowedCount(){
        return bookService.getNonBorrowedCount();
    }
}
