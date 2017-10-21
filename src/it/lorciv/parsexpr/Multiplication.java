package it.lorciv.parsexpr;

public class Multiplication extends BinaryOperation {

	public Multiplication(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public String symbol() {
		return "*";
	}
	
	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);	
	}

}
