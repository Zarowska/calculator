package com.calculator;

public class NumberOperation  implements Operation{

	private String number;

	public NumberOperation(String number) {
		this.number = number;
	}

	@Override
	public double calculate() {
			return Double.parseDouble(number);
	}

}
