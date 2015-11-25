package model;

public class Product {
	
	public Product(String name, int price)
	{
		if (name == null) {
			throw new IllegalArgumentException();
		}
	}

}
