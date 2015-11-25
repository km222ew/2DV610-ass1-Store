package model;

import java.util.ArrayList;

public class Store {
	ArrayList<Product> products;
	public ShoppingCart sCart;
	
	public Store(ArrayList<Product> p, ShoppingCart cart)
	{
		if (p == null || p.size() <= 0)
			throw new IllegalArgumentException();
		
		products = p;
		sCart = cart;
	}
	
	public int GetProductCount()
	{
		return products.size();
	}
	
	public ShoppingCart GetShoppingCart()
	{
		return sCart;
	}
}