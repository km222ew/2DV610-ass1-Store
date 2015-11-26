package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Product;
import model.ShoppingCart;
import model.Store;
import view.ConsoleWrapper;
import view.StaticMessage;
import view.StoreView;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

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
	
	//Writer: Hk, Assistance: Km
	@Test
	public void ShouldPrintMessage()
	{
		StoreView view = new StoreView(cw);
		
		view.Print(StaticMessage.SUPER_DUPER_MART_WELCOME);
		verify(cw).printLine(StaticMessage.SUPER_DUPER_MART_WELCOME);
	}
	
	//Writer: Hk, Assistance: Km
	@Test
	public void ShouldPrintAvailableProducts()
	{
		StoreView view = new StoreView(cw);
		ArrayList<Product> al = new ArrayList<>();
		Store store = mock(Store.class);
		when(store.GetReadOnlyProducts()).thenReturn(al);
		
		Product p = mock(Product.class);
		when(p.getName()).thenReturn("Stone");
		when(p.getPrice()).thenReturn(1);
		al.add(p);
		
		p = mock(Product.class);
		when(p.getName()).thenReturn("Mushroom");
		when(p.getPrice()).thenReturn(10);
		al.add(p);
		
		view.PrintAvailableProducts(store.GetReadOnlyProducts());
		
		verify(cw).printLine("1. Name: Stone | Price: 1");
		verify(cw).printLine("2. Name: Mushroom | Price: 10");
	}
	
	//Writer: Hk, Assistance: Km
	@Test(expected = NumberFormatException.class)
	public void ShouldThrowExceptionOnNonIntInput()
	{
		StoreView view = new StoreView(cw);
		when(cw.readInput(System.in)).thenReturn("a");
		int temp = view.NextInt();
	}
	
	//Writer: Hk, Assistance: Km
	@Test
	public void ShouldReturnInt()
	{
		StoreView view = new StoreView(cw);
		when(cw.readInput(System.in)).thenReturn("3");
		assertEquals(3, view.NextInt());
	}
}