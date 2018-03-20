package br.com.demos.rabbitmq.service;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.demos.rabbitmq.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RabbitMQMessageService {

	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	@Autowired
    private RabbitMQReceiver receiver;
    
	
	public String saveMessage(MessageDTO message) throws InterruptedException {
		log.info("Sending message... {}", message.getMessage());
		rabbitTemplate.convertAndSend("spring-boot", message.getMessage());
        receiver.getLatch().await(2000, TimeUnit.MILLISECONDS);
		return "Received";
	}

	
}
