package br.com.demos.hello.redis;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Receiver {
	
	private CountDownLatch countDownLatch;
	
	@Autowired
	public Receiver(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	
	
	public void receiveMessage(String message) {
		log.info("Receive <" + message +">");
		countDownLatch.countDown();
	}


}
