package org.javaspringcourse.controller;

import lombok.RequiredArgsConstructor;
import org.javaspringcourse.dto.OrderIn;
import org.javaspringcourse.dto.OrderOut;
import org.javaspringcourse.metric.counter.CounterMetric;
import org.javaspringcourse.metric.timer.TimerMetric;
import org.javaspringcourse.service.ChocolateShopService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChocolateShopController {
    private final ChocolateShopService chocolateShopService;

    @PostMapping("/order")
    @CounterMetric(name = "createOrder")
    @TimerMetric(name = "createOrder")
    public OrderOut createOrder(@RequestBody OrderIn order) {
        return chocolateShopService.createOrder(order);
    }
}
