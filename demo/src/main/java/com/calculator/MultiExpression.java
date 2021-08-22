package com.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiExpression implements Expression {

	private Expression expression;

	public MultiExpression(String expression) {
		this.expression = splitStringByOperation(expression, "+");
	};

	protected Expression splitStringByOperation(String expression, String operation) {
		Pattern compiledPattern = Pattern.compile("\\" + operation);
		Matcher matcher = compiledPattern.matcher(expression);
		if (matcher.find()) {
			String leftPart = expression.substring(0, matcher.start());
			String rightPart = expression.substring(matcher.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression(operation, left, right);
		}

		Pattern compiledPatternPlus = Pattern.compile("\\" + "+");
		Matcher matcherPlus = compiledPatternPlus.matcher(expression);
		if (matcherPlus.find()) {
			String leftPart = expression.substring(0, matcherPlus.start());
			String rightPart = expression.substring(matcherPlus.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression("+", left, right);
		}
		;

		Pattern compiledPatternMinus = Pattern.compile("\\" + "-");
		Matcher matcherMinus = compiledPatternMinus.matcher(expression);
		if (matcherMinus.find()) {
			String leftPart = expression.substring(0, matcherMinus.start());
			String rightPart = expression.substring(matcherMinus.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression("-", left, right);
		}
		;

		Pattern compiledPatternMultiplicationSign = Pattern.compile("\\" + "*");
		Matcher matcherMultiplicationSign = compiledPatternMultiplicationSign.matcher(expression);
		if (matcherMultiplicationSign.find()) {
			String leftPart = expression.substring(0, matcherMultiplicationSign.start());
			String rightPart = expression.substring(matcherMultiplicationSign.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression("*", left, right);
		}

		Pattern compiledPatternDivisionSign = Pattern.compile("\\" + "/");
		Matcher matcherDivisionSign = compiledPatternDivisionSign.matcher(expression);
		if (matcherDivisionSign.find()) {
			String leftPart = expression.substring(0, matcherDivisionSign.start());
			String rightPart = expression.substring(matcherDivisionSign.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression("/", left, right);
		}

		return new NumberExpression(expression);
	}

	public double calculate() {
		return expression.calculate();
	}

}
