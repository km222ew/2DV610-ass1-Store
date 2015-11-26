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
		int loop = 1;
		for(Product p : pList)
		{
			cw.printLine(loop + ". Name: " + p.getName() + " | Price: " + p.getPrice());
			
			loop++;
		}
	}

	public int NextInt()
	{
		String t = cw.readInput(System.in);
		
		int te = Integer.parseInt(t);
		
		return te;
	}
}
