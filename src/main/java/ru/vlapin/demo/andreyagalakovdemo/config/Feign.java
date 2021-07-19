package ru.vlapin.demo.andreyagalakovdemo.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableHypermediaSupport(type = HAL)
@EnableFeignClients("ru.vlapin.demo.andreyagalakovdemo.service")
public class Feign {
}
