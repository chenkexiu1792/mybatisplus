package com.itheima;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MPJApplication {
    public static void main(String[] args) {
        SpringApplication.run(MPJApplication.class, args);
    }
}
