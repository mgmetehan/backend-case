package com.mgmetehan.accountAndUser.ratelimit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

@Aspect
@Component
public class RateLimiterAspect {
    private final RateLimitingService rateLimitingService;

    public RateLimiterAspect(RateLimitingService rateLimitingService) {
        this.rateLimitingService = rateLimitingService;
    }

    @Around("@annotation(com.mgmetehan.accountAndUser.ratelimit.RateLimiter)")
    public Object rateLimiting(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        final RateLimiter annotation = methodSignature.getMethod().getAnnotation(RateLimiter.class);

        final int limit = annotation.limit();
        final int time = annotation.time();

        String user = RequestContextHolder.getRequestAttributes().getSessionId();

        if (rateLimitingService.isAllowed(user + ":1", limit, time)) {
            return joinPoint.proceed();
        } else {
            return ResponseEntity.status(429).body("Too many requests");
        }
    }
}
