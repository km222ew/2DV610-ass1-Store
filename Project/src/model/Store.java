package model;

import java.util.ArrayList;

public class Store {
	
	public Store(ArrayList<Product> p)
	{
		if (p == null)
			throw new IllegalArgumentException();
	}
}