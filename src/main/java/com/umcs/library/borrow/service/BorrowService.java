package com.umcs.library.borrow.service;

import com.umcs.library.borrow.domain.Borrow;
import com.umcs.library.borrow.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {

    private BorrowRepository borrowRepository;

    @Autowired
    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public Borrow findById(int id){
        return borrowRepository.findById(id);
    }

    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    public int insert(Borrow borrow) {
        return borrowRepository.insert(borrow);
    }

    public int deleteById(int id) {
        return borrowRepository.deleteById(id);
    }

    public int update(Borrow borrow) {
        return borrowRepository.update(borrow);
    }

    public int count() {
        return borrowRepository.count();
    }
}
