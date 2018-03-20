package br.com.demos.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.demos.rabbitmq.dto.MessageDTO;
import br.com.demos.rabbitmq.service.RabbitMQMessageService;


@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQMessageController {

	@Autowired
	private RabbitMQMessageService service;
	
	@PostMapping("/send")
	public String putMessage(@RequestBody final MessageDTO message) throws InterruptedException {
		return service.saveMessage(message);
	}
}
