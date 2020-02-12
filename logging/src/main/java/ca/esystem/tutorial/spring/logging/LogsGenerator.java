package ca.esystem.tutorial.spring.logging;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogsGenerator {
	private static final Logger logger = LoggerFactory.getLogger(LogsGenerator.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	
	@Scheduled(fixedRate = 2000)
	public void generateAllLevelsLogs() {
		logger.trace("TRACE ->" + dateFormat.format(Calendar.getInstance().getTime()));
		logger.debug("DEBUG ->" + dateFormat.format(Calendar.getInstance().getTime()));
		logger.info("INFO ->" + dateFormat.format(Calendar.getInstance().getTime()));
		logger.warn("WARN ->" + dateFormat.format(Calendar.getInstance().getTime()));
		logger.error("ERROR ->" + dateFormat.format(Calendar.getInstance().getTime()));
		logger.error("----------------------divider------------------------");
	}
	
}
