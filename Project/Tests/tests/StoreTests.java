package tests;
import java.util.ArrayList;

import org.junit.Test;

import model.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class StoreTests {

	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowExceptionOnNullInput()
	{
		new Store(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowExceptionOnEmptyList()
	{
		new Store(new ArrayList<Product>());
	}
	
	@Test
	public void StoreShouldContainProducts()
	{
		ArrayList<Product> al = new ArrayList<Product>();
		al.add(mock(Product.class));
		Store s = new Store(al);
		
		assertEquals(1, s.GetProductCount());
	}
	
	@Test
	public void ShoppingCartShouldNotBeNull()
	{
		ArrayList<Product> al = new ArrayList<Product>();
		al.add(mock(Product.class));
		Store s = new Store(al);
		
		assertNotEquals(s.sCart, null);
	}
}