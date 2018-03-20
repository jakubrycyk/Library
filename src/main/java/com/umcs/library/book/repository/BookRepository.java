package com.umcs.library.book.repository;


import com.umcs.library.book.domain.Book;

import java.util.List;

public interface BookRepository {

    Book findById(int id);

    List<Book> findAll();

    int deleteById(int id);

    int insert(Book book);

    int update(Book book);

    int count();

    int getBorrowedCount();

}
