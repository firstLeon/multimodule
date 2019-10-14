package com.laoli.mqconsumer.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class mqConsumerService {

    @JmsListener(destination = "${myqueue}")
    public void receiver(String msg){
        System.out.println("消费者获取到的消息："+msg);
    }
}
