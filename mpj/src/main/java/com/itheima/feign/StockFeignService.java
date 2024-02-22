package com.itheima.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Administrator
 * @Version 1.0
 */
@FeignClient(value = "stock-service",path = "/stock")
public interface StockFeignService {

    @RequestMapping("/reduce")
    public String reduce();
}
