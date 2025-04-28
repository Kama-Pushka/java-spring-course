package org.javaspringcourse.order.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.javaspringcourse.order.eventListener.event.OrderCreatingEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Log4j2
@Service
@RequiredArgsConstructor
public class OrderService {
    private final ApplicationEventPublisher eventPublisher;

    public void createOrder(float cost, float money) {
        log.info("Creating an order...");
        log.info("Waiting for payment...");

        log.info("Publish OrderCreatingEvent.");
        eventPublisher.publishEvent(new OrderCreatingEvent(cost, money));
    }
}
