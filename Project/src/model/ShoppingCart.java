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
		if (prod == null || amount <= 0)
			throw new IllegalArgumentException();
		
		if (lhs.containsKey(prod))
		{
			int temp = lhs.get(prod).intValue();
			lhs.replace(prod, temp, temp + amount);
		}
		else
			lhs.put(prod, amount);
	}

	public void RemoveProduct(Product prod, int amount) 
	{
		if (prod == null || amount <= 0)
			throw new IllegalArgumentException();
		
		int temp = lhs.get(prod).intValue();
		lhs.replace(prod, temp, temp - amount);
	}
}
