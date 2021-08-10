import com.calculator.NumberOperation;
import com.calculator.Operation;
import com.calculator.SingleOperation;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Oxy {

	String expression = "1*2+6/2-8/4+2-1";

	private Operation e3;

	public Oxy(String expression) {
		SingleOperation e1 = new SingleOperation("*", new NumberOperation("3"), new NumberOperation("4"));
		SingleOperation e2 = new SingleOperation("/", e1, new NumberOperation("2"));
		e3 = new SingleOperation("+", new NumberOperation("1"), e2);
	}
	// ExpressionBuilder //.build(String expression)

	protected void mainMethod(String expression) {
		String changedMinusSignExpressionc = changeMinusSign(expression); // 1*2+6/2+-8/4+2+-1"
		
		SingleOperation so1 = new SingleOperation();
		so1 = shareStringByOperation(expression, "+");
		sL1=so1.left;
		sR1= so1.right;
		//sR1.mainMethod();
		SingleOperation so2 = new SingleOperation();
		so2 = shareStringByOperation(expression, "*");
		sL2 = so2.left;
		sR2 = so2.right;
		//sR2.mainMethod();
		SingleOperation so3 = new SingleOperation();
		so3 = shareStringByOperation(expression, "/");
		sL3 = so3.left;
		sR3 = so3.right;
		//sR3.mainMethod();
	};

	protected String changeMinusSign(String expression) {
		// expression = "1*2+6/2-8/4+2-1"
		// result = "1*2+6/2+-8/4+2+-1"
		return expression;
	};

	protected SingleOperation shareStringByOperation(String expression, String operation ) {
		 Pattern compiledPattern = Pattern.compile(operation);
		 Matcher matcher = compiledPattern.matcher(expression);
		 if (matcher.find()) {
	    String leftPart = expression.substring(0, matcher.start());
		 String rightPart = expression.substring(matcher.end(), expression.length());
		 return SingleOperation(operation, leftPart, rightPart);
		 }

	public double calculate() {
		return e3.calculate();
	}

}
