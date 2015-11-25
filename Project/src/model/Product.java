package model;

public class Product {
	
	private String name;
	
	public Product(String ProdName, int price)
	{
		if (ProdName == null || price < 1) {
			throw new IllegalArgumentException();
		}
		
		name = ProdName;
	}
	
	public String getName()
	{
		return name;
	}

}
