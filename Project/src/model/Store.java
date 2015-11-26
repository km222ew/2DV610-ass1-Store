package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
	
	public List<Product> GetReadOnlyProducts() 
	{		
		return Collections.unmodifiableList(products);
	}
	
	public Map<Product, Integer> GetReadOnlyCartContent() 
	{
		return Collections.unmodifiableMap(sCart.GetProducts());
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