package com.tr.springboot.controller;

import com.tr.springboot.service.TransactionService;
import com.tr.springboot.dao.jpa.TransactionRepository;
import com.tr.springboot.dao.mybatis.TransactionMapper;
import com.tr.springboot.entity.Transaction;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Transaction", description = "事务")
@RestController
public class TransactionController {

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionRepository transactionRepository;

//    @PostMapping("/transactions")
//    public void create(@RequestBody Transaction transaction) {
//        transactionRepository.save(transaction);
//    }
//
//    @GetMapping("/transactions/{id}")
//    public Transaction retrieve(@PathVariable Integer id) {
//        return transactionRepository.findById(id).get();
//    }
//    @GetMapping("/transactions")
//    public List<Transaction> retrieve() {
//        return transactionRepository.findAll();
//    }
//
//    @PutMapping("/transactions")
//    public void update(@RequestBody Transaction transaction) {
//        transactionRepository.save(transaction);
//    }
//    @PatchMapping("/transactions")
//    public void updatePatch(@RequestBody Transaction transaction) {
//        transactionMapper.updateById(transaction);
//    }
//
//    @DeleteMapping("/transactions/{id}")
//    public void delete(@PathVariable Integer id) {
//        transactionRepository.deleteById(id);
//    }


    @Autowired
    private TransactionService transactionService;

    @GetMapping("/test-transaction")
    public void testTransaction() {
        transactionService.transactionUpdate();
    }

    @GetMapping("/test-transaction-before")
    public void beforeTransactionUpdate() {
        transactionService.beforeTransactionUpdate();
    }

    @GetMapping("/reset-data")
    public void resetData() {
        Transaction t = new Transaction(2,0,0,0,0,0);
        transactionRepository.save(t);
    }

}
