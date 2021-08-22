package com.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiExpression implements Expression {

	private Expression expression;

	public MultiExpression(String expression) {
		//String changedMinusSignExpressionc = changeMinusSign(expression); // 1*2+6/2+-8/4+2+-1"
		 this.expression = splitStringByOperation(expression, "+");
		 	}

	// ExpressionBuilder //.build(String expression)
	protected Expression splitStringByOperation(String expression, String operation) {
		Pattern compiledPattern = Pattern.compile("\\"+operation);
		Matcher matcher = compiledPattern.matcher(expression);
		if (matcher.find()) {
			String leftPart = expression.substring(0, matcher.start());
			String rightPart = expression.substring(matcher.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression(operation, left, right);
		}

		Pattern compiledPattern2 = Pattern.compile("\\" + "-");
		Matcher matcher2 = compiledPattern2.matcher(expression);
		if (matcher2.find()) {
			String leftPart = expression.substring(0, matcher2.start());
			String rightPart = expression.substring(matcher2.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression("-", left, right);
		}

		Pattern compiledPattern3 = Pattern.compile("\\" + "*");
		Matcher matcher3 = compiledPattern3.matcher(expression);
		if (matcher3.find()) {
			String leftPart = expression.substring(0, matcher3.start());
			String rightPart = expression.substring(matcher3.end(), expression.length());
			MultiExpression left = new MultiExpression(leftPart);
			MultiExpression right = new MultiExpression(rightPart);
			return new SimpleExpression("*", left, right);
		}
		
		return new NumberExpression(expression);
	}

	public double calculate() {
		return expression.calculate();
	}

}
