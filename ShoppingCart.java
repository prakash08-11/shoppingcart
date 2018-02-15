package shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;



public class ShoppingCart implements CartOperations {
private float tax_percentage;
private float invoiceAmount;
private ArrayList<Product> items =new ArrayList<Product>();
	@Override
	public float getInvoiceAmount() 
	{ return invoiceAmount;
		}

	@Override
	public float addToCart(Product p) {
		items.add(p);
		float cost=0,temp;
		temp=(p.price*p.quantity);
		cost=temp+(tax_percentage*temp/100);
		invoiceAmount+=cost;
		return cost;
			}

	@Override
	public void removeFromCart(Product p) 
	{
		Iterator<Product> itr= items.iterator();
		try {
		while(itr.hasNext())
		{ 
			
			if(p.equals(itr.next()))
			{
				float cost=0,temp;
				temp=(p.price*p.quantity);
				cost=temp+(tax_percentage*temp/100);
				invoiceAmount-=cost;
					
			itr.remove();
		return;
			}
			
			
		}
		throw new ProductException();
		}
		 catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
		
	}
		
	
	
	public ShoppingCart(float tax_percentage)
	{
		this.tax_percentage=tax_percentage;
	}
public String toString()
{
	String s="";
Iterator<Product>	itr=items.iterator();
while(itr.hasNext())
{
	s=s+itr.next().name;
}
return s;
}
public static void main(String[]  args) 
{
	Product p1 = new Product("keyboard",400,2);
	Product p2 = new Product("pendrive ",300,2);
	Product p3 = new Product("camera",3000,1);
	CartOperations cart=new ShoppingCart(10);
	try {
	cart.removeFromCart(p3);
	}
	catch(ProductException e)
	{
		System.out.println(e.getMessage());
	}
	cart.addToCart(p1);
	cart.addToCart(p2);
	cart.addToCart(p3);
	try {

	
	cart.removeFromCart(p1);
	}
	catch(ProductException e)
	{
		System.out.println(e);
	}
	System.out.println(cart.getInvoiceAmount());
	System.out.println(cart);
}
}



















