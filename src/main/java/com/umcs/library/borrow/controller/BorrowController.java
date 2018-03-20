package com.umcs.library.borrow.controller;

import com.umcs.library.borrow.domain.Borrow;
import com.umcs.library.borrow.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BorrowController {

    private BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    public Borrow findById(int id){
        return borrowService.findById(id);
    }

    public List<Borrow> findAll() {
        return borrowService.findAll();
    }

    public int insert(Borrow borrow) {
        return borrowService.insert(borrow);
    }

    public int deleteById(int id) {
        return borrowService.deleteById(id);
    }

    public int update(Borrow borrow) {
        return borrowService.update(borrow);
    }

    public int count() {
        return borrowService.count();
    }
}
