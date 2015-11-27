package store;

import model.Store;
import view.StoreView;

public class StoreController {
	
	public StoreController(Store model, StoreView view)
	{
		if (model == null || view == null) 
		{
			throw new IllegalArgumentException();
		}
	}

	public static void main(String[] args)
	{
		
	}
}