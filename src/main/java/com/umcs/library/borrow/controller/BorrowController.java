package com.umcs.library.borrow.controller;

import com.umcs.library.borrow.domain.Borrow;
import com.umcs.library.borrow.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BorrowController {

    private BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    public Optional<Borrow> findById(int id){
        return borrowService.findById(id);
    }

    public List<Borrow> findAll() {
        return borrowService.findAll();
    }

    public void insert(Borrow borrow) {
        borrowService.insert(borrow);
    }

    public void deleteById(int id) {
        borrowService.deleteById(id);
    }

    public void update(Borrow borrow) {
         borrowService.update(borrow);
    }

    public long count() {
        return borrowService.count();
    }
}
