package org.javaspringcourse.order.controller;

import lombok.RequiredArgsConstructor;
import org.javaspringcourse.order.dto.OrderIn;
import org.javaspringcourse.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public void getOrders(@RequestBody OrderIn order) {
        orderService.createOrder(order.cost(), order.balance());
    }
}
