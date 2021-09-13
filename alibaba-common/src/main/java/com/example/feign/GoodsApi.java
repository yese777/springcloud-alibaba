package com.example.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "alibaba-provider")//value是服务名称
@RequestMapping("/goods")
public interface GoodsApi {
    @GetMapping("/findById/{id}")
    Map findById(@PathVariable Integer id);
}
