package com.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiExpression implements Expression {
// 1+0*2-10*2/5
	private Expression expression;

	public MultiExpression(Expression parsedExpression) {
		this.expression = parsedExpression;
		
	};

	

	public MultiExpression(String leftPart) {
	}



	public double calculate() {
		return expression.calculate();
	}

}
