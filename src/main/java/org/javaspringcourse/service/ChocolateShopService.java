package org.javaspringcourse.service;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.javaspringcourse.dto.OrderIn;
import org.javaspringcourse.dto.OrderOut;
import org.javaspringcourse.model.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChocolateShopService {
    private final List<OrderEntity> orders = new ArrayList<OrderEntity>();
    private final MeterRegistry meterRegistry;

    public OrderOut createOrder(OrderIn orderIn) {
        var order = OrderEntity.builder()
                .orderId(orders.size())
                .chocolateType(orderIn.chocolate())
                .count(orderIn.count())
                .build();
        orders.add(order);

        meterRegistry.counter("shop.order.counter." + orderIn.chocolate()).increment(orderIn.count()); // TODO стоит выделить в ивент

        return toDto(order);
    }

    private OrderOut toDto(OrderEntity order) {
        return new OrderOut(order.getOrderId(), order.getChocolateType(), order.getCount());
    }
}
