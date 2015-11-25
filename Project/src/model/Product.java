package model;

public class Product {
	
	private String productName;
	
	public Product(String name, int price)
	{
		if (name == null || price < 1) {
			throw new IllegalArgumentException();
		}
		
		productName = name;
	}
	
	public String getProductName()
	{
		return productName;
	}

}
