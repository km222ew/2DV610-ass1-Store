package model;

public class Product {
	
	private String name;
	private int price;
	
	public Product(String prodName, int prodPrice)
	{
		if (prodName == null || prodPrice < 1) {
			throw new IllegalArgumentException();
		}
		
		name = prodName;
		price = prodPrice;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getPrice()
	{
		return price;
	}

}
