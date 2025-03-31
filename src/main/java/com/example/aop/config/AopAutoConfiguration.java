package com.example.aop.config;

import com.example.aop.aspect.LogAspectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ComponentScan("com.example.aop")
public class AopAutoConfiguration {
    
    @Bean
    public LogAspectHandler logAspectHandler() {
        return new LogAspectHandler();
    }
} 