package org.javaspringcourse.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaspringcourse.service.TransactionService;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AccountBaseLevel {
    private final TransactionService service; // Внедрение через конструктор

    @PostConstruct
    public void create() {
        log.info("Create AccountBaseLevel bean");
    }

    public void someOperation() {
        service.createTransaction();
        service.transaction();
    }

    @PreDestroy
    public void destroy() {
        log.info("Destroy AccountBaseLevel bean");
    }
}
