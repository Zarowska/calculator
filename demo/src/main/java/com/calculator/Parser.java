package com.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


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

		String operationPlus = "+";
		Pattern compiledPatternPlus = Pattern.compile("\\" + operationPlus);
		Matcher matcherPlus = compiledPatternPlus.matcher(expression);
		if (matcherPlus.find()) {
			String leftPart = expression.substring(0, matcherPlus.start());
			String rightPart = expression.substring(matcherPlus.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression(operationPlus, left, right);
		}

		String operationMinus = "-";
		Pattern compiledPatternMinus = Pattern.compile("\\" + operationMinus);
		Matcher matcherMinus = compiledPatternMinus.matcher(expression);
		if (matcherMinus.find()) {
			String leftPart = expression.substring(0, matcherMinus.start());
			String rightPart = expression.substring(matcherMinus.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression(operationMinus, left, right);
		}

		String operationMultiplicat = "*";
		Pattern compiledPatternMultiplicationSign = Pattern.compile("\\" + operationMultiplicat);
		Matcher matcherMultiplicationSign = compiledPatternMultiplicationSign.matcher(expression);
		if (matcherMultiplicationSign.find()) {
			String leftPart = expression.substring(0, matcherMultiplicationSign.start());
			String rightPart = expression.substring(matcherMultiplicationSign.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression(operationMultiplicat, left, right);
		}

		String string = "/";
		Pattern compiledPatternDivisionSign = Pattern.compile("\\" + string);
		Matcher matcherDivisionSign = compiledPatternDivisionSign.matcher(expression);
		if (matcherDivisionSign.find()) {
			String leftPart = expression.substring(0, matcherDivisionSign.start());
			String rightPart = expression.substring(matcherDivisionSign.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression(string, left, right);
		}

		return new NumberExpression(expression);
	}
	
}
