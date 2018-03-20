package br.com.demos.hello.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 50000)
	public void reportCurrentTimeWithRate() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		logger.info("(Rate) The time is now {}", dateFormat.format(new Date()));
		System.out.println("(Rate) The time is now " +  dateFormat.format(new Date()));
	}

	@Scheduled(fixedDelay = 50000)
	public void reportCurrentTimeWithDelay() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		logger.info("(Delay) The time is now {}", dateFormat.format(new Date()));
		System.out.println("(Delay) The time is now " + dateFormat.format(new Date()));
	}
	
	@Scheduled(cron="*/10 * * * * *")
	public void reportCurrentTimeCron() throws InterruptedException{
		logger.info("(Cron) The time is now {}", dateFormat.format(new Date()));
		System.out.println("(Cron) The time is now " + dateFormat.format(new Date()));
		TimeUnit.SECONDS.sleep(10);
		logger.info("(Cron) The time is now {} after sleep", dateFormat.format(new Date()));
	}
	
}
