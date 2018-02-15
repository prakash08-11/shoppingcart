package shoppingcart;

public interface CartOperations {
float getInvoiceAmount();
float addToCart(Product p);
void removeFromCart(Product p) throws ProductException;
}
