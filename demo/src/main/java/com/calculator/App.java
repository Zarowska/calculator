package com.calculator;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		//String expression = "1+0*2-10*2/5+2";//ok
		//String expression = "1*2+6/2-8/4+2-1";//ok
		String expression = Reader.read();
		Parser parser = new Parser();
		Expression parsedExpression = parser.splitStringByOperation(expression, "+");
		MultiExpression e = new MultiExpression(parsedExpression);
		
		double r = e.calculate();
		System.out.println(r);
	}
}
