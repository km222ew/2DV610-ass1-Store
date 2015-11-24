package tests;
import java.util.ArrayList;

import org.junit.Test;

import model.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class StoreTests {

	//Writer: Hk, Assistance: Km 
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowExceptionOnNullInput()
	{
		new Store(null);
	}
	
	//Writer: Hk, Assistance: Km 
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowExceptionOnEmptyList()
	{
		new Store(new ArrayList<Product>());
	}
	
	//Writer: Hk, Assistance: Km 
	@Test
	public void StoreShouldContainProducts()
	{
		Store s = MakeStore();
		
		assertEquals(1, s.GetProductCount());
	}
	
	//Writer: Hk, Assistance: Km 
	@Test
	public void ShoppingCartShouldNotBeNull()
	{
		Store s = MakeStore();
		
		assertNotEquals(s.sCart, null);
	}
	
	private Store MakeStore()
	{
		ArrayList<Product> al = new ArrayList<Product>();
		al.add(mock(Product.class));
		Store s = new Store(al);
		return s;
	}
}