package it.lorciv.parsexpr;

public class ExpressionPrinter implements ExpressionVisitor {
	
	private String result = "";
	
	public String getResult() {
		return result;
	}

	@Override
	public void visit(Number expression) {
		result = Integer.toString(expression.getValue());
	}

	@Override
	public void visit(Addition expression) {
		visitBinaryOperation(expression);
	}

	@Override
	public void visit(Subtraction expression) {
		visitBinaryOperation(expression);
	}

	@Override
	public void visit(Multiplication expression) {
		visitBinaryOperation(expression);
	}

	@Override
	public void visit(Division expression) {
		visitBinaryOperation(expression);
	}
	
	private void visitBinaryOperation(BinaryOperation operation) {
		
		operation.left().accept(this);
		String left = getResult();
		
		operation.right().accept(this);
		String right = getResult();
		
		result = "(" + left + operation.symbol() + right + ")";
	}

}
