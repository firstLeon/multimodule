package com.laoli.mqproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling   //开启定时任务
@EnableJms
public class Producer {

    public static void main(String[] args) {
        SpringApplication.run(Producer.class,args);
    }
}
