package com.disaster;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class OperationPlatFromApplication {
    public static void main(String[] args) {
        SpringApplication.run(OperationPlatFromApplication.class, args);
        log.info(SaManager.getConfig().toString());
    }
}