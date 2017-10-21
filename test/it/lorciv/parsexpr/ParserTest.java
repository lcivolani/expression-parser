package it.lorciv.parsexpr;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import it.lorciv.parsexpr.Expression;
import it.lorciv.parsexpr.ExpressionCompiler;
import it.lorciv.parsexpr.ExpressionEvaluator;
import it.lorciv.parsexpr.ExpressionPrinter;
import it.lorciv.parsexpr.Parser;
import it.lorciv.parsexpr.Scanner;

public class ParserTest {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner("3 + ( 4 + 3 * 3 ) * 2 * ( 3 + 4 ) + 5 / 4 - 2");
		Parser parser = new Parser(scanner);
		
		// Generate the abstract syntax tree
		Expression expression = parser.parseExpression();
		
		// Visit the tree: printing
		ExpressionPrinter printer = new ExpressionPrinter();
		expression.accept(printer);
		System.out.println("Print expression: " + printer.getResult());
		
		// Visit the tree: evaluation
		ExpressionEvaluator evaluator = new ExpressionEvaluator();
		expression.accept(evaluator);
		System.out.println("Evaluate expression: " + evaluator.getResult());
		
		// Visit the tree: compilation for arithmetic stack machine
		PrintWriter output = new PrintWriter(new FileWriter("machine_code.txt"));
		ExpressionCompiler compiler = new ExpressionCompiler(new PrintWriter(output));
		expression.accept(compiler);
		output.close();
		System.out.println("Compilation result in file machine_code.txt");
	}

}
