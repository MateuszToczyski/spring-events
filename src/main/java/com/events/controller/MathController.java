package com.events.controller;

import com.events.domain.CalculationParameters;
import com.events.event.CalculationRequestedEvent;
import com.events.service.MathService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/math")
public class MathController implements ApplicationEventPublisherAware {
	private final MathService mathService;
	private ApplicationEventPublisher publisher;

	public MathController(final MathService mathService) {
		this.mathService = mathService;
	}

	@PostMapping(path = "calculate")
	public String calculate(@RequestBody CalculationParameters parameters) {
		publisher.publishEvent(new CalculationRequestedEvent(this, parameters));
		return this.mathService.calculate(parameters).toPlainString();
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}
}
