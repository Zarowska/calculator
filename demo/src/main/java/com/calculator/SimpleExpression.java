package com.calculator;

public class SimpleExpression implements Expression {

	private String operator;
	private Expression left;
	private Expression right;

	public SimpleExpression(String operator, Expression left, Expression right) {
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
