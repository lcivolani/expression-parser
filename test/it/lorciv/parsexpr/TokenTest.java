package it.lorciv.parsexpr;

public class TokenTest {
	
	public static void main(String[] args) {
		
		String[] strings = {
			"hello",
			"my",
			"2",
			"name",
			"is",
			"1688"
		};
		
		for (String string : strings) {
			Token t = new Token(string);
			System.out.println("Token " + t + (t.isNumber() ? " is" : " is not") + " number");
		}
	}

}
