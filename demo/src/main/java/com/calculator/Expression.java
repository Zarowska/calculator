package com.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
	// String expression = "1+3*4/2";

	private Operation e3;

	public Expression(String expression) {
		SingleOperation e1 = new SingleOperation("*", new NumberOperation("3"), new NumberOperation("4"));
		SingleOperation e2 = new SingleOperation("/", e1, new NumberOperation("2"));
		e3 = new SingleOperation("+", new NumberOperation("1"), e2);
	}
	// // ExpressionBuilder //.build(String expression)
	// protected SingleOperation shareStringByOperation(String expression, char
	// operation ) {
	// Pattern compiledPattern = Pattern.compile("operation");
	// Matcher matcher = compiledPattern.matcher(expression);
	// if (matcher.find()) {
	// String leftPart = expression.substring(0, matcher.start());
	// new Expression (leftPart)
	// String rightPart = expression.substring(matcher.end(), expression.length());
	// new Expression (rightPart)
	// return SingleOperation("operation", leftPart, rightPart);
	// }

	public double calculate() {
		return e3.calculate();
	}

}
