package br.com.demos.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.demos.hello.dto.MessageDTO;
import br.com.demos.hello.redis.MessageService;

@RestController
@RequestMapping("/redis")
public class RedisMessageController {

	@Autowired
	private MessageService service;
	
	@PostMapping("/send")
	public String putMessage(@RequestBody final MessageDTO message) throws InterruptedException {
		return service.saveMessage(message);
	}
}
