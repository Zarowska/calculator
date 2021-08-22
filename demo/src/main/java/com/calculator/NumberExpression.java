package com.calculator;

public class NumberExpression  implements Expression{

	private String number;

	public NumberExpression(String number) {
		this.number = number;
	}

	@Override
	public double calculate() {
			return Double.parseDouble(number);
	}

}
