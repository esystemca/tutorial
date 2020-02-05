package ca.esystem.tutorial.spring.scheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySchedulingTasks {

	private static final Logger logger = LoggerFactory.getLogger(MySchedulingTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	
	@Scheduled(cron="0 * * * * *")
	public void printTimestampEveryMinute() {
		printTimestamp("Task 1",true);
	}
	
	@Scheduled(cron="0/10 * * * * *")
	public void printTimestampEveryThenSeconds() {
		printTimestamp("Task 2",true);
	}
	
	@Scheduled(fixedRate=5000)
	public void printTimestampEveryFiveSeconds() {
		printTimestamp("Task 3",true);
	}
	
	
	
	public void printTimestamp(String taskname, boolean keeprunning) {
		logger.info(taskname + "->" + dateFormat.format(Calendar.getInstance().getTime()));
		if (keeprunning) {
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(2000);
					logger.info(taskname + "-> didn't release this thread after running task");
				} catch (InterruptedException e) {
					e.printStackTrace();
					logger.error(e.getMessage());
				}
			}
		}
	}
	
}
