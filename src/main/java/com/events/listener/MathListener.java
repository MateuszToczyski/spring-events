package com.events.listener;

import com.events.event.CalculationRequestedEvent;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MathListener implements ApplicationListener<CalculationRequestedEvent> {

	private static final Logger LOGGER = Logger.getLogger(MathListener.class);

	@Override
	public void onApplicationEvent(final CalculationRequestedEvent event) {
		LOGGER.info("Received calculation request with parameters: " + event.getParameters());
	}
}
