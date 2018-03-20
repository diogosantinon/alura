package br.com.demos.rabbitmq.service;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RabbitMQReceiver {

	private CountDownLatch latch = new CountDownLatch(1);
	
    public void receiveMQMessage(String message) {
    	log.info("Received <" + message + ">");
        latch.countDown();
    }
    
    public CountDownLatch getLatch() {
        return latch;
    }

}