package com.umcs.library.borrow.service;

import com.umcs.library.borrow.domain.Borrow;
import com.umcs.library.borrow.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    private BorrowRepository borrowRepository;

    @Autowired
    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public Optional<Borrow> findById(int id){
        return borrowRepository.findById(id);
    }

    public List<Borrow> findAll() {
        return (List<Borrow>) borrowRepository.findAll();
    }

    public void insert(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    public void deleteById(int id) {
        borrowRepository.deleteById(id);
    }

    public void update(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    public long count() {
        return borrowRepository.count();
    }
}
