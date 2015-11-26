package model;

import java.util.ArrayList;

public class Store {
	
	private ArrayList<Product> products;
	private ShoppingCart sCart;
	
	public Store(ArrayList<Product> p, ShoppingCart cart)
	{
		if (p == null || p.size() <= 0 || cart == null)
			throw new IllegalArgumentException();
		
		products = p;
		sCart = cart;
	}
	
	public int GetProductCount()
	{
		return products.size();
	}
	
	public ArrayList<Product> GetProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ShoppingCart GetShoppingCart()
	{
		return sCart;
	}

	public void AddProductToCart(Product prod, int amount) 
	{
		sCart.AddProduct(prod, amount);		
	}

	public void RemoveProductFromCart(Product prod, int amount) 
	{
		sCart.RemoveProduct(prod, amount);		
	}

	
}