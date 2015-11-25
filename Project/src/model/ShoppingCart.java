package model;

import java.util.LinkedHashMap;

public class ShoppingCart {
	
	private LinkedHashMap<Product, Integer> lhs;
	
	public ShoppingCart()
	{
		lhs = new LinkedHashMap<Product, Integer>();
	}
	
	public LinkedHashMap<Product, Integer> GetProducts()
	{
		return lhs;
	}

	public void AddProduct(Product prod, int amount) 
	{
		if (prod == null)
			throw new IllegalArgumentException();
	}

	public void RemoveProduct(Product prod, int amount) 
	{
		
	}
}
