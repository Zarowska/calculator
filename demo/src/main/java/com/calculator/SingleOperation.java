package com.calculator;

public class SingleOperation implements Operation {

	private String operator;
	private Operation left;
	private Operation right;

	public SingleOperation(String operator, Operation left, Operation right) {
		this.operator = operator;
		this.left = left;
		this.right = right;

	}

	@Override
	public double calculate() {
		if (operator == "+") {
			return left.calculate() + right.calculate();
		}
		if (operator == "-") {
			return left.calculate() - right.calculate();
		}
		if (operator == "*") {
			return left.calculate() * right.calculate();
		}
		if (operator == "/") {
			return left.calculate() / right.calculate();
		}
		throw new UnsupportedOperationException(operator);
	}

}
