package it.lorciv.parsexpr;

public interface ExpressionVisitor {
	
	void visit(Number expression);
	
	void visit(Addition expression);
	
	void visit(Subtraction expression);
	
	void visit(Multiplication expression);
	
	void visit(Division expression);
	
}
