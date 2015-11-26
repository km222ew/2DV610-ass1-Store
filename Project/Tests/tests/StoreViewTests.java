package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import view.ConsoleWrapper;
import view.StoreView;

public class StoreViewTests {

	//Writer: Km, Assistance: Hk 
	@Test (expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentExceptionOnNullInput()
	{
		new StoreView(null);
	}

	//Writer: Km, Assistance: Hk 
	@Test
	public void ShouldInitializeConsoleWrapper()
	{
		StoreView view = new StoreView(new ConsoleWrapper());
		
		assertTrue(view.cw != null);
	}
}
