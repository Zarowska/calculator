package com.calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
	public static String read() {
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		System.out.print("Enter a string: ");
		String str = sc.nextLine(); // reads string before the space
		System.out.print("You have entered: " + str);


		Pattern compiledPattern = Pattern.compile("/0");//
		Matcher matcher = compiledPattern.matcher(str);
		if (matcher.find()) {
			System.out.println("\n" + "Division by zero. Try again.");
			Reader.read();
		}
	
		Pattern compiledPattern2 = Pattern.compile("[\\*\\+\\/\\-][\\*\\+\\/\\-]");
		Matcher matcher2 = compiledPattern2.matcher(str);
		if (matcher2.find()) {
			System.out.println("\n" + "Error. Try again.");
		Reader.read();
		}


		Pattern compiledPattern3 = Pattern.compile("[^\\d\\+\\-\\*\\/]");
		Matcher matcher3 = compiledPattern3.matcher(str);
		if (matcher3.find()) {
			System.out.println("\n" + "Error. Try again.");
			Reader.read();
		}

		return str;
	}
}
