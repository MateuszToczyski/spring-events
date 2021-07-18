package com.events.domain;

import com.events.enums.OperationType;

import java.math.BigDecimal;

public class CalculationParameters {
	private final OperationType operationType;
	private final BigDecimal num1;
	private final BigDecimal num2;

	public CalculationParameters(
			final OperationType operationType, final BigDecimal num1, final BigDecimal num2) {
		this.operationType = operationType;
		this.num1 = num1;
		this.num2 = num2;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public BigDecimal getNum1() {
		return num1;
	}

	public BigDecimal getNum2() {
		return num2;
	}

	@Override
	public String toString() {
		return "CalculationParameters{" + "operationType=" + operationType + ", num1=" + num1 + ", num2="
				+ num2 + '}';
	}
}
