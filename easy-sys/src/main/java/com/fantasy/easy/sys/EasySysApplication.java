package com.fantasy.easy.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.fantasy.easy")
@ComponentScan("com.fantasy.easy")
public class EasySysApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasySysApplication.class,args) ;
    }
}
