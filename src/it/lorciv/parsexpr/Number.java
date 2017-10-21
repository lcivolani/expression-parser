package it.lorciv.parsexpr;

public class Number implements Expression {
	
	private int value;
	
	public Number(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}
	
	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);	
	}

}
