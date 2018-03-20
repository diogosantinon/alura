package br.com.demos.hello.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.demos.hello.pojo.Greeting;
import br.com.demos.hello.rest.Quote;

@RestController
public class GreetingController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", required=false, 
								defaultValue="Word 123") String name) {
		logger.info(name);
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
		
	}
	
	@RequestMapping("/rest")
	public Quote rest() {
		Quote quote = restTemplate.getForObject(
				"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		logger.info(quote.toString());
		return quote;
	}
	

	
}
