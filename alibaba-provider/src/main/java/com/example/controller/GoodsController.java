package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.eneity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods")
@RefreshScope
@Slf4j
public class GoodsController {

    @GetMapping("/findById/{id}")
    public Map findById(@PathVariable Integer id) {
        log.info("id:【{}】", id);
        Goods goods = new Goods(id, "小米", 1999D);
        return new HashMap() {{
            put("code", 0);
            put("msg", "success");
            put("data", goods);
        }};
    }

    @GetMapping("/test")
    @SentinelResource(value = "test")
    public Map test(Integer flag) {
        if (flag == null) {
            throw new IllegalArgumentException("参数异常");
        }
        return new HashMap() {{
            put("code", 0);
            put("msg", "success");
            put("data", "test");
        }};
    }


    @Value("${pic.url}")
    private String pic_url;

    @GetMapping("/config")
    public String config() {
        return pic_url;
    }

}
