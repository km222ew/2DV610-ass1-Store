package store;

import model.Store;
import view.StoreView;

public class StoreController {
	
	public Store model;
	public StoreView view;
	
	public StoreController(Store model, StoreView view)
	{
		if (model == null || view == null) 
		{
			throw new IllegalArgumentException();
		}

		this.model = model;
		this.view = view;
	}

	public static void main(String[] args)
	{
		
	}
}