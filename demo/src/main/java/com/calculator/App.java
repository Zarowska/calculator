package com.calculator;


/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		//String expression = "1+0*2-1";
		String expression = Reader.read();
		MultiExpression e = new MultiExpression(expression);
		double r = e.calculate();
		System.out.println(r);

	}
}
