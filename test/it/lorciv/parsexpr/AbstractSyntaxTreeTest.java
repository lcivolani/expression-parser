package it.lorciv.parsexpr;

public class AbstractSyntaxTreeTest {
	
	public static void main(String[] args) {
		
		// 3 - 5
		Expression e1 = new Subtraction(
			new Number(3),
			new Number(5)
		);
		
		System.out.println(e1);
		
		// 2 + 5 * 4 - 1
		Expression e2 = new Subtraction(
			new Addition(
				new Number(2),
				new Multiplication(
					new Number(5),
					new Number(4)
				)
			),
			new Number(1)
		);
		
		System.out.println(e2);
		
		// 3 - 5 - 1 * 5
		Expression e3 = new Subtraction(
			new Subtraction(
				new Number(3),
				new Number(5)
			),
			new Multiplication(
				new Number(1),
				new Number(5)
			)
		);
		
		System.out.println(e3);
		
		// 5 - ( 3 - 1 )
		Expression e4 = new Subtraction(
				new Number(5), 
				new Subtraction(
						new Number(3),
						new Number(1)));
		
		System.out.println(e4);
		
		// ( 5 - 3 ) - 1
		Expression e5 = new Subtraction(
				new Subtraction(
						new Number(5),
						new Number(3)),
				new Number(1)
				);
		
		System.out.println(e5);
	}

}
