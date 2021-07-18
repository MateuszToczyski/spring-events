package com.events.service;

import com.events.domain.CalculationParameters;
import com.events.enums.OperationType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.Function;

@Component
public class MathService {

	public BigDecimal calculate(final CalculationParameters parameters) {
		final OperationType operationType = parameters.getOperationType();
		final BigDecimal num1 = parameters.getNum1();
		final BigDecimal num2 = parameters.getNum2();

		final Function<BigDecimal, BigDecimal> operation;

		switch (operationType) {
			case ADD:
				operation = num1::add;
				break;
			case SUBTRACT:
				operation = num1::subtract;
				break;
			case MULTIPLY:
				operation = num1::multiply;
				break;
			case DIVIDE:
				operation = num1::divide;
				break;
			default:
				throw new UnsupportedOperationException("Operation: " + operationType + " is not supported");
		}

		return operation.apply(num2);
	}
}
