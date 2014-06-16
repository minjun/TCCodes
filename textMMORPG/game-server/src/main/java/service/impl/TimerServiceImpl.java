package service.impl;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("timerService")
public class TimerServiceImpl {
	private static final Logger logger = LoggerFactory.getLogger(TimerServiceImpl.class);

	@Value("${heartbeat}")
	public int heartbeat = 2000;

	@Value("${refreshinterval}")
	public int refreshInterval = 15 * 60 * 1000;

	private void heartBeat() {
		logger.debug("hearbeat running");
	}
	private void refresh() {
		logger.debug("refreshing...");
	}

	@PostConstruct
	private void init() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				heartBeat();
			}
		}, 0, heartbeat);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				refresh();
			}
		}, 0, refreshInterval);
	}
}
