package it.lorciv.parsexpr;

public interface Expression {
	
	public abstract void accept(ExpressionVisitor visitor);
	
}
