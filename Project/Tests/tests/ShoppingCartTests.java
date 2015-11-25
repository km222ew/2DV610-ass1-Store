package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Product;
import model.ShoppingCart;
import static org.mockito.Mockito.*;

public class ShoppingCartTests {

	@Test
	public void ShouldInitializeProductMap()
	{
		assertTrue(new ShoppingCart().GetProducts() != null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentExceptionOnNullInput()
	{
		ShoppingCart sc = new ShoppingCart();
		
		sc.AddProduct(null, 1);
	}
}