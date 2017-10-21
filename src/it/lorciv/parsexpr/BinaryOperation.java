package it.lorciv.parsexpr;

public abstract class BinaryOperation implements Expression {
	
	protected Expression left, right;
	
	protected BinaryOperation(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	
	public Expression left() {
		return left;
	}
	
	public Expression right() {
		return right;
	}
	
	public abstract String symbol();
	
	@Override
	public String toString() {
		return left + symbol() + right;
	}

}
