package org.javaspringcourse.service.implementation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.javaspringcourse.service.TransactionService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WithdrawService implements TransactionService {

    @PostConstruct
    public void create() {
        log.info("Create WithdrawService bean");
    }

    @Override
    public void createTransaction() {
        System.out.println("Create Withdraw Transaction");
    }

    @Override
    public void transaction() {
        System.out.println("Withdraw transaction...");
    }

    @PreDestroy
    public void destroy() {
        log.info("Destroy WithdrawService bean");
    }
}