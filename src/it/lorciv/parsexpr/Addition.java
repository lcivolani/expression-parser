package it.lorciv.parsexpr;

public class Addition extends BinaryOperation {

	public Addition(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public String symbol() {
		return "+";
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

}
