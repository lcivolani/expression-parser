package it.lorciv.parsexpr;

import java.io.PrintWriter;

public class ExpressionCompiler implements ExpressionVisitor {
	
	private PrintWriter output;
	
	public ExpressionCompiler(PrintWriter output) {
		this.output = output;
	}
	
	private void emit(String string) {
		output.println(string);
	}

	@Override
	public void visit(Number expression) {
		emit("PUSH " + expression.getValue());
	}

	@Override
	public void visit(Addition expression) {
		expression.left().accept(this);
		expression.right().accept(this);
		emit("ADD");
	}

	@Override
	public void visit(Subtraction expression) {
		expression.left().accept(this);
		expression.right().accept(this);
		emit("SUB");
	}

	@Override
	public void visit(Multiplication expression) {
		expression.left().accept(this);
		expression.right().accept(this);
		emit("MUL");
	}

	@Override
	public void visit(Division expression) {
		expression.left().accept(this);
		expression.right().accept(this);
		emit("DIV");
	}

}
