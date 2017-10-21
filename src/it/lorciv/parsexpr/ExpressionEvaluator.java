package it.lorciv.parsexpr;

public class ExpressionEvaluator implements ExpressionVisitor {

	private int result = 0;
	
	public int getResult() {
		return result;
	}
	
	@Override
	public void visit(Number expression) {
		result = expression.getValue();
	}

	@Override
	public void visit(Addition expression) {
		
		expression.left().accept(this);
		int left = getResult();
		expression.right().accept(this);
		int right = getResult();
		
		result = left + right;
	}

	@Override
	public void visit(Subtraction expression) {
		
		expression.left().accept(this);
		int left = getResult();
		expression.right().accept(this);
		int right = getResult();
		
		result = left - right;
	}

	@Override
	public void visit(Multiplication expression) {
		
		expression.left().accept(this);
		int left = getResult();
		expression.right().accept(this);
		int right = getResult();
		
		result = left * right;
	}

	@Override
	public void visit(Division expression) {
		
		expression.left().accept(this);
		int left = getResult();
		expression.right().accept(this);
		int right = getResult();
		
		result = left / right;
	}

}
