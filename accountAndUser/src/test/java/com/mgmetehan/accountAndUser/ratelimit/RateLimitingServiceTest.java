package com.mgmetehan.accountAndUser.ratelimit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.time.Clock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RateLimitingServiceTest {

    private RateLimitingService rateLimitingService;
    private Clock clock;

    @BeforeEach
    public void setup() {
        rateLimitingService = new RateLimitingService();
        clock = Mockito.mock(Clock.class);
        Mockito.when(clock.millis()).thenReturn(System.currentTimeMillis());
    }

    @Test
    public void testIsAllowed_noRequestsMadeYet() {
        String key = "client1";
        int limit = 10;
        int time = 1000;
        boolean result = rateLimitingService.isAllowed(key, limit, time);
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsAllowed_lessThanAllowedRequestsMade() {
        String key = "client1";
        int limit = 10;
        int time = 1000;

        rateLimitingService.increment(key, clock.millis());

        boolean result = rateLimitingService.isAllowed(key, limit, time);
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsAllowed_maximumAllowedRequestsMade() {
        String key = "client1";
        int limit = 10;
        int time = 1000;

        for (int i = 0; i < limit; i++) {
            rateLimitingService.increment(key, clock.millis());
        }

        boolean result = rateLimitingService.isAllowed(key, limit, time);
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsAllowed_timeSinceLastRequestExpired() {
        String key = "client1";
        int limit = 10;
        int time = 1000;

        rateLimitingService.increment(key, clock.millis() - time - 1);

        boolean result = rateLimitingService.isAllowed(key, limit, time);
        Assertions.assertTrue(result);
    }
}
