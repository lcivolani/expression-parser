package it.lorciv.parsexpr;

public class ScannerTest {

	public static void main(String[] args) {
		
		String str = "3 + ( 4 + 3 ) * 2 * ( 3 + 4 )";
		Scanner scanner = new Scanner(str);
		
		Token token;
		
		while ((token = scanner.getNextToken()) != null) {
			System.out.println("Token '" + token + "'");
		}
	}

}
