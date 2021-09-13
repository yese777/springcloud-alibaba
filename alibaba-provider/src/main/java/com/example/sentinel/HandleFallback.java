package com.example.sentinel;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

// 熔断降级
@Slf4j
public class HandleFallback {
    public static Map testFallback(Throwable throwable) {
        log.info("throwable", throwable);
        return new HashMap() {{
            put("code", -2);
            put("msg", "出错了");
            put("data", null);
        }};
    }
}