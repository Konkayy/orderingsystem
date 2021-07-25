package com.cwy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-23 23:53:43
 */
@SpringBootApplication
@EnableFeignClients
@ServletComponentScan("com.cwy.filter")
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class);

    }

}
