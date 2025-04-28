package org.javaspringcourse.payment.eventListener;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.javaspringcourse.payment.eventListener.event.PaymentProcessedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Log4j2
@Component
@RequiredArgsConstructor
public class PaymentEventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handlePaymentSuccessEvent(PaymentProcessedEvent event) {
        log.info("Handle PaymentProcessedEvent (AFTER_COMMIT)...");
        log.info("Payment was successful.");
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handlePaymentFailEvent(PaymentProcessedEvent event) {
        log.info("Handle PaymentProcessedEvent (AFTER_ROLLBACK)...");
        log.info("Payment failed.");
    }
}
