package com.calculator;


/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		String expression = "1+3*4/2";
		//String expression = Reader.read();
		Expression e = new Expression(expression);
		double r = e.calculate();
		System.out.println(r);

	}
}
