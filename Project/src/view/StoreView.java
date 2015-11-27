package view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

	public void PrintCartProducts(Map<Product, Integer> pMap)
	{
		int totalProducts = 0;
		int finalPrice = 0;
		int loop = 1;
		
		for (Map.Entry<Product, Integer> prod : pMap.entrySet()) 
		{
			Product tempProd = prod.getKey();
			int tempAmount = prod.getValue();
			int totalPrice = tempProd.getPrice() * tempAmount;
			
			cw.printLine(loop + ". Name: " + tempProd.getName() + " | Amount: " + tempAmount + " | Price: " + tempProd.getPrice() + " | Total Price: " + totalPrice);
			
			totalProducts += tempAmount;
			finalPrice += totalPrice;
			loop += 1;
		}
		
		cw.printLine("Total Products: " + totalProducts + ", Final Price: " + finalPrice);
	}
}
