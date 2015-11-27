package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;
import store.StoreController;
import view.StaticMessage;
import view.StoreView;
import model.Store;

public class StoreControllerTests {

	@Test (expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentExceptionOnNullInput() 
	{
		new StoreController(null, null);
	}

	@Test
	public void ShouldAssignConstructorArguments()
	{
		StoreController contr = new StoreController(mock(Store.class), mock(StoreView.class));
		
		assertTrue(contr.model != null);
		assertTrue(contr.view != null);
	}
	
	@Test
	public void ShouldPresetWelcomeMessage()
	{
		StoreController sc = MakeStoreController();
		
		sc.Run();
		
		verify(sc.view).Print(StaticMessage.SUPER_DUPER_MART_WELCOME);
	}
	
	@Test
	public void ShouldQuitOnExitCommand()
	{
		StoreController sc = MakeStoreController();
		
		sc.Run();
		
		when(sc.view.NextInt()).thenReturn(0);
		
		assertFalse(sc.IsRunning());
	}
	
	private StoreController MakeStoreController()
	{
		return new StoreController(mock(Store.class), mock(StoreView.class));
	}
}
