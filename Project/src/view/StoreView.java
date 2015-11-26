package view;

import java.util.List;

import model.Product;

public class StoreView {
	
	public ConsoleWrapper cw;
	
	public StoreView(ConsoleWrapper cw)
	{
		if (cw == null) 
		{
			throw new IllegalArgumentException();
		}
		
		this.cw = cw;
	}

	public void Print(String s) 
	{
		cw.printLine(s);
	}

	public void PrintAvailableProducts(List<Product> pList)
	{
		
	}
}
