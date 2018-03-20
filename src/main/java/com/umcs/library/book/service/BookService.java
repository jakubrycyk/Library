package com.umcs.library.book.service;

import com.umcs.library.book.domain.Book;
import com.umcs.library.book.repository.BookRepository;

import java.util.List;


public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(int id){
        return bookRepository.findById(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public int insert(Book book) {
        return bookRepository.insert(book);
    }

    public int deleteById(int id) {
        return bookRepository.deleteById(id);
    }

    public int update(Book book) {
        return bookRepository.update(book);
    }

    public int count() {
        return bookRepository.count();
    }

    public int getBorrowedCount(){
        return bookRepository.getBorrowedCount();
    }

    public int getNonBorrowedCount(){
        return count() - getBorrowedCount();
    }
}
