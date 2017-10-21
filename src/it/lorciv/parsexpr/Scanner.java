package it.lorciv.parsexpr;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Scanner extends StringTokenizer {

	public Scanner(String txt) {
		super(txt);
	}
	
	public Token getNextToken() {
		
		Token result;
		
		try {
			result = new Token(nextToken().trim());
		} catch (NoSuchElementException e) {
			result = null;
		}
		
		return result;
	}
	
}
