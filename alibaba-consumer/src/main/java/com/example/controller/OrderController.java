package com.example.controller;

import com.example.feign.GoodsApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private GoodsApi goodsApi;

    @GetMapping("/save")
    public Map save() {
        // 1.远程调用alibaba-goods服务,获取goods信息
        Map result = goodsApi.findById(1);
        log.info("result:【{}】", result);

        // 2.保存订单
        log.info("save order success");

        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("data", "null");
        return map;
    }

}
