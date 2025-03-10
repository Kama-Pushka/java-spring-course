package org.javaspringcourse.service.implementation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.javaspringcourse.service.TransactionService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Primary
public class DepositService implements TransactionService {

    @PostConstruct
    public void create() {
        log.info("Create DepositService bean");
    }

    @Override
    public void createTransaction() {
        System.out.println("Create Deposit Transaction");
    }

    @Override
    public void transaction() {
        System.out.println("Deposit transaction...");
    }

    @PreDestroy
    public void destroy() {
        log.info("Destroy DepositService bean");
    }
}
