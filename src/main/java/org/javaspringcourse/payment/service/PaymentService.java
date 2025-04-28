package org.javaspringcourse.payment.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.javaspringcourse.payment.eventListener.event.PaymentProcessedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static jakarta.transaction.Transactional.TxType.REQUIRES_NEW;

@Log4j2
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final ApplicationEventPublisher eventPublisher;

    @Transactional(value = REQUIRES_NEW, rollbackOn = Exception.class)
    public void processPayment(float money, float need) {
        log.info("Trying to pay for order. Current money: {}", money);
        eventPublisher.publishEvent(new PaymentProcessedEvent());

        log.info("In transaction: {}", TransactionSynchronizationManager.isActualTransactionActive());

        if (money > need) {
            log.info("Payment Working...");
            log.info("Fixing in DB...");
        } else {
            throw new RuntimeException("NO MONEY TO PAY");
        }
    }
}
