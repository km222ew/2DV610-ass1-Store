package view;

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
}
