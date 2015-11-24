package model;

import java.util.ArrayList;

public class Store {
	ArrayList<Product> products;
	
	public Store(ArrayList<Product> p)
	{
		if (p == null || p.size() <= 0)
			throw new IllegalArgumentException();
		
		products = p;
	}
	
	public int GetProductCount()
	{
		return products.size();
	}
}