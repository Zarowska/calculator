package com.calculator;

public class Expression {
	// String expression = "1+3*4/2";

	private Operation e3;

	public Expression(String expression) {
		SingleOperation e1 = new SingleOperation("*", new NumberOperation("3"),new NumberOperation("4"));
		SingleOperation e2 = new SingleOperation("/", e1, new NumberOperation("2"));
		e3 = new SingleOperation("+", new NumberOperation("1"), e2);
		


	}

	public Result calculate() {
		return e3.calculate();
	}

}
