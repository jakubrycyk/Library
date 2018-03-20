package com.umcs.library.borrow.repository;

import com.umcs.library.borrow.domain.Borrow;

import java.util.List;

public interface BorrowRepository {
    Borrow findById(int id);

    List<Borrow> findAll();

    int deleteById(int id);

    int insert(Borrow borrow);

    int update(Borrow borrow);

    int count();
}
