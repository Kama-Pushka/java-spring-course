package org.javaspringcourse.order.eventListener;

import lombok.extern.log4j.Log4j2;
import org.javaspringcourse.order.eventListener.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class OrderEventListener {

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        log.info("Handle OrderCreatedEvent...");
        log.info("Order was created.");
    }
}
