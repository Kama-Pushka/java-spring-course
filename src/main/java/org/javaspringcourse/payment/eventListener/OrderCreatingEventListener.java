package org.javaspringcourse.payment.eventListener;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.javaspringcourse.order.eventListener.event.OrderCreatingEvent;
import org.javaspringcourse.payment.service.PaymentService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class OrderCreatingEventListener {
    private final PaymentService paymentService;

    @EventListener
    @Async("threadPoolTaskExecutor")
    public void handleOrderCreatedEvent(OrderCreatingEvent event) throws InterruptedException {
        Thread.sleep(2000);
        try {
            paymentService.processPayment(event.money(), event.cost());
        } catch (Exception e) {
            log.warn(e);
        }
    }
}
