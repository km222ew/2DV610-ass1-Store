package model;

public class Product {
	
	public Product(String name, int price)
	{
		if (name == null || price < 1) {
			throw new IllegalArgumentException();
		}
	}

}
