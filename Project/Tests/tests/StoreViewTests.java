package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import view.ConsoleWrapper;
import view.StoreView;

public class StoreViewTests {

	@Test (expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentExceptionOnNullInput()
	{
		new StoreView(null);
	}

	@Test
	public void ShouldInitializeConsoleWrapper()
	{
		StoreView view = new StoreView(new ConsoleWrapper());
		
		assertTrue(view.cw != null);
	}
}
