package com.calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Reader {
	public static String read(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String term = scan.nextLine();
		Pattern pattern = Pattern.compile("^\\d");
		Matcher matcher = pattern.matcher(term);
		while (matcher.find()) {
			System.out.println("There are no numbers to calculate.");
			break;
		}

		// Pattern pattern = Pattern.compile("\Q/0\E");
		// Matcher matcher = pattern.matcher(term);
		// if (matcher.find() is not null) {
		// System.out.println("division by zero.");
		// break;
		// }

		

	}
}