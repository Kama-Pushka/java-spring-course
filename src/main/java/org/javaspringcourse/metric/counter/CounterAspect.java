package org.javaspringcourse.metric.counter;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class CounterAspect {
    private final MeterRegistry meterRegistry;

    @After("@annotation(counter)")
    public void counterMetric(CounterMetric counter) {
        meterRegistry.counter("shop.api-request.counter.all").increment();
        meterRegistry.counter("shop.api-request.counter." + counter.name()).increment();
    }
}
