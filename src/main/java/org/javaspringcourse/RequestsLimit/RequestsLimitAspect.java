package org.javaspringcourse.RequestsLimit;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.javaspringcourse.Exception.TooManyRequestsException;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class RequestsLimitAspect {
    private final RequestsLimitService requestsLimitService;

    @Before(value = "@annotation(RequestsLimit)")
    private void before(JoinPoint joinPoint) {
        if (!requestsLimitService.canHandleRequest(
                joinPoint.getSignature().getName())) {
            throw new TooManyRequestsException("Too many requests.");
        }
    }
}
