package shoppingcart;

public class ProductException extends Exception {
String s;

public ProductException(String s) {
	super();
	this.s = s;
}
public ProductException() {
	
	s="******************";
}
public String toString()
{
	return s;
	
}
public String getMessage()

{
	return s;
}
}
