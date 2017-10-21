package it.lorciv.parsexpr;

public class Division extends BinaryOperation {

	public Division(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public String symbol() {
		return "/";
	}
	
	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

}
