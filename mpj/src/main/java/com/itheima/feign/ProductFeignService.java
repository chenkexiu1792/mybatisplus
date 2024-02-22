package com.itheima.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Administrator
 * @Version 1.0
 */
@FeignClient(value = "product-service",path = "/product")
public interface ProductFeignService {

    @RequestMapping("/{id}")
    public String get(@PathVariable("id") Integer id) throws InterruptedException ;
}
