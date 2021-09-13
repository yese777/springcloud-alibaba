package com.example.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

// 流量控制
@Slf4j
public class CustomerBlockHandler {
    public static Map testBlockHandler(BlockException exception) {
        log.info("exception", exception);
        return new HashMap() {{
            put("code", -1);
            put("msg", "系统繁忙，请稍后重试!!!!");
            put("data", null);
        }};
    }
}
