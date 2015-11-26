package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import view.ConsoleWrapper;
import view.StaticMessage;
import view.StoreView;
import static org.mockito.Mockito.*;

public class StoreViewTests {
	private ConsoleWrapper cw;
	
	@Before
	public void Init()
	{
		cw = mock(ConsoleWrapper.class);
	}

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
	
	@Test
	public void ShouldPrintMessage()
	{
		StoreView view = new StoreView(cw);
		
		view.Print(StaticMessage.SUPER_DUPER_MART_WELCOME);
		verify(cw).printLine(StaticMessage.SUPER_DUPER_MART_WELCOME);
	}
}