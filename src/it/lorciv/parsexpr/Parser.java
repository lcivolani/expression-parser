package it.lorciv.parsexpr;

public class Parser {

	private Scanner scanner;
	private Token currentToken;
	
	public Parser(Scanner scanner) {
		this.scanner = scanner;
		currentToken = scanner.getNextToken();
	}
	
	public Expression parseExpression() {
		
//		System.out.println("parseExpression:\tcurrent token is " + currentToken);
		
		Expression leftTerm = parseTerm();
		
		while (currentToken != null) {
			
//			System.out.println("parseExpression:\tcurrent token is " + currentToken);
			
			if (currentToken.equals("+")) {
				currentToken = scanner.getNextToken();
				Expression rightTerm = parseTerm();
				leftTerm = new Addition(leftTerm, rightTerm);
			} else if (currentToken.equals("-")) {
				currentToken = scanner.getNextToken();
				Expression rightTerm = parseTerm();
				leftTerm = new Subtraction(leftTerm, rightTerm);
			} else {
				break;
			}
		}
		
//		System.out.println("parseExpression:\tcurrent token is " + currentToken);
		
		return leftTerm;
	}
	
	public Expression parseTerm() {
		
//		System.out.println("parseTerm:\tcurrent token is " + currentToken);
		
		Expression leftFactor = parseFactor();
		
		while (currentToken != null) {
			
//			System.out.println("parseTerm:\tcurrent token is " + currentToken);
			
			if (currentToken.equals("*")) {
				currentToken = scanner.getNextToken();
				Expression rightFactor = parseFactor();
				leftFactor = new Multiplication(leftFactor, rightFactor);
			} else if (currentToken.equals("/")) {
				currentToken = scanner.getNextToken();
				Expression rightFactor = parseFactor();
				leftFactor = new Division(leftFactor, rightFactor);
			} else {
				break;
			}
		}
		
//		System.out.println("parseTerm:\tcurrent token is " + currentToken);
		
		return leftFactor;
	}
	
	public Expression parseFactor() {
		
//		System.out.println("parseFact:\tcurrent token is " + currentToken);
		
		if (currentToken.isNumber()) {
			int value = currentToken.getAsInt();
			currentToken = scanner.getNextToken();
			return new Number(value);
		} else if (currentToken.equals("(")) {
			currentToken = scanner.getNextToken();
			Expression innerExpression = parseExpression();
			if (currentToken.equals(")")) {
				currentToken = scanner.getNextToken();
				return innerExpression;
			} else {
				throw new IllegalArgumentException("missing )");
			}
		}
		
		throw new IllegalArgumentException("unrecognized");
	}
}
