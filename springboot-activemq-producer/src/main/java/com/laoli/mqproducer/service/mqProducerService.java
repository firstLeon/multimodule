package com.laoli.mqproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class mqProducerService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //将队列注册进来
    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 5000)
    public void send(){
        String msg=System.currentTimeMillis()+"时的消息";
        jmsMessagingTemplate.convertAndSend(queue,msg);
        System.out.println("发送消息到队列");
    }
}
