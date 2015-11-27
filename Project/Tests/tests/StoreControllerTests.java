package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import store.StoreController;
import view.StaticMessage;
import view.StoreView;
import model.Store;

public class StoreControllerTests {
	
	private StoreController sc;
	
	@Before
	public void Init()
	{
		sc = MakeStoreController();
	}
	
	//Writer: Km
	@Test (expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentExceptionOnNullInput() 
	{
		new StoreController(null, null);
	}

	//Writer: Km
	@Test
	public void ShouldAssignConstructorArguments()
	{
		StoreController contr = new StoreController(mock(Store.class), mock(StoreView.class));
		
		assertTrue(contr.model != null);
		assertTrue(contr.view != null);
	}
	
	//Writer: Hk, Assistance: Km
	@Test
	public void ShouldPresetWelcomeMessage()
	{		
		sc.Run();
		
		verify(sc.view).Print(StaticMessage.SUPER_DUPER_MART_WELCOME);
	}
	
	//Writer: Hk, Assistance: Km
	@Test
	public void ShouldQuitOnExitCommand()
	{
		when(sc.view.NextInt()).thenReturn(0);		
		
		sc.Run();			
		
		assertFalse(sc.IsRunning());
	}
	
	//Writer: Hk, Km
	@Test
	public void ShouldPrintAvailableStoreItems()
	{
		when(sc.view.NextInt()).thenReturn(1).thenReturn(0);
		
		sc.Run();
		
		verify(sc.view, times(2)).Print(any(String.class));
		verify(sc.view).Print(StaticMessage.PRINT_PRODUCTS_TOP);
		verify(sc.view).PrintAvailableProducts(sc.model.GetReadOnlyProducts());
	}
	
	@Test
	public void ShouldPrintProductsInCart()
	{
		when(sc.view.NextInt()).thenReturn(2).thenReturn(0);
		
		sc.Run();
		
		verify(sc.view, times(2)).Print(any(String.class));
		verify(sc.view).Print(StaticMessage.PRINT_CART_TOP);
		verify(sc.view).PrintCartProducts(sc.model.GetReadOnlyCartContent());
	}
	
	private StoreController MakeStoreController()
	{
		return new StoreController(mock(Store.class), mock(StoreView.class));
	}
}
