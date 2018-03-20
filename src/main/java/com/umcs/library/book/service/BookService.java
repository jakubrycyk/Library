package com.umcs.library.book.service;

import com.umcs.library.book.domain.Book;
import com.umcs.library.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findById(int id){
        return bookRepository.findById(id);
    }

    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    public void insert(Book book) {
        bookRepository.save(book);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(int id) {
       bookRepository.deleteById(id);
    }

    public long count() {
        return bookRepository.count();
    }

    public long getBorrowedCount(){
        List<Book> books = (List<Book>) bookRepository.findAll();
        books = books.stream().filter(book -> !book.getIsLost()).collect(Collectors.toList());
        return books.size();
    }

    public long getNonBorrowedCount(){
        return count() - getBorrowedCount();
    }
}
