package org.javaspringcourse.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.javaspringcourse.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class AccountPremiumLevel {
    @Autowired
    private TransactionService deposit; // Внедрение через поле

    @Setter(onMethod_ = @Autowired)
    @Qualifier("WithdrawService")
    private TransactionService withdraw; // Внедрение через сеттер

    @PostConstruct
    public void create() {
        log.info("Create AccountPremiumLevel bean");
    }

    public void deposit() {
        deposit.createTransaction();
        deposit.transaction();
    }

    public void withdraw() {
        withdraw.createTransaction();
        withdraw.transaction();
    }

    @PreDestroy
    public void destroy() {
        log.info("Destroy AccountPremiumLevel bean");
    }
}
