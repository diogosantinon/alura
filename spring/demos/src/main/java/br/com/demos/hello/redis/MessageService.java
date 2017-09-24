package br.com.demos.hello.redis;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import br.com.demos.hello.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageService {

	@Autowired
	StringRedisTemplate template;
	
	@Autowired
	CountDownLatch latch;
	
	public String saveMessage(MessageDTO message) throws InterruptedException {
		log.info("Receiving message <"+message+">");
		template.convertAndSend("chat", message.getMessage());
		latch.await();
		return "Received";
	}

	
	
}
