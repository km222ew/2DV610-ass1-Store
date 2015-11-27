package store;

import java.util.ArrayList;

import model.Product;
import model.ShoppingCart;
import model.Store;
import view.ConsoleWrapper;
import view.StaticMessage;
import view.StoreView;

public class StoreController {
	
	public Store model;
	public StoreView view;
	private boolean isRunning = true;
	
	public StoreController(Store model, StoreView view)
	{
		if (model == null || view == null) 
		{
			throw new IllegalArgumentException();
		}

		this.model = model;
		this.view = view;
	}
	
	public void Run()
	{
		view.Print(StaticMessage.SUPER_DUPER_MART_WELCOME);
		
		while (isRunning)
		{					
			int choice = view.NextInt();
			
			if (choice == StaticMessage.SHOW_PRODUCTS_COMMAND) 
			{
				view.Print(StaticMessage.PRINT_PRODUCTS_TOP);
				view.PrintAvailableProducts(model.GetReadOnlyProducts());
			}
			
			if (choice == StaticMessage.SHOW_CART_COMMAND) 
			{
				view.Print(StaticMessage.PRINT_CART_TOP);
				view.PrintCartProducts(model.GetReadOnlyCartContent());
			}
			
			if (choice == StaticMessage.EXIT_COMMAND)
				isRunning = false;
		}
	}

	public static void main(String[] args)
	{
		ArrayList<Product> al = FindProducts();
		StoreController sc = new StoreController(new Store(al, new ShoppingCart()), new StoreView(new ConsoleWrapper()));
		
		sc.Run();
	}
	
	public boolean IsRunning()
	{
		return isRunning;
	}
	
	private static ArrayList<Product> FindProducts()
	{
		ArrayList<Product> al = new ArrayList<>();
		al.add(new Product("Stone", 50));
		al.add(new Product("Mushroom", 150));
		al.add(new Product("Apple", 5));
		al.add(new Product("Chocolate Bar", 20));
		al.add(new Product("Carp", 2000));
		al.add(new Product("144Hz Monitor", 1999));
		return al;
	}
}