package org.javaspringcourse.metric.timer;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class TimerAspect {
    private final MeterRegistry meterRegistry;

    @Around("@annotation(timer)")
    public Object timer(ProceedingJoinPoint jp, TimerMetric timer) {
        return meterRegistry.timer("shop.api-request.timer." + timer.name()).record(() ->
        {
            try {
                return jp.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
    }
}
