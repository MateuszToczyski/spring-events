package com.events.event;

import com.events.domain.CalculationParameters;
import org.springframework.context.ApplicationEvent;

public class CalculationRequestedEvent extends ApplicationEvent {

	private final CalculationParameters parameters;

	public CalculationRequestedEvent(final Object source, final CalculationParameters parameters) {
		super(source);
		this.parameters = parameters;
	}

	public CalculationParameters getParameters() {
		return parameters;
	}
}
