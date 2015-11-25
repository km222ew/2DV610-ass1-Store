package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Product;
import model.ShoppingCart;
import static org.mockito.Mockito.*;

public class ShoppingCartTests {

	//Writer: Hk, Assistance: Km 
	@Test
	public void ShouldInitializeProductMap()
	{
		assertTrue(new ShoppingCart().GetProducts() != null);
	}
	
	/*
	 * ADD START
	 */
	//Writer: Hk, Assistance: Km 
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentExceptionOnNullInput()
	{
		ShoppingCart sc = new ShoppingCart();
		
		sc.AddProduct(null, 1);
	}
	
	//Writer: Hk, Assistance: Km 
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentExceptionOnLessThanOneProduct()
	{
		ShoppingCart sc = new ShoppingCart();
		
		sc.AddProduct(mock(Product.class), 0);
	}
	
	//Writer: Hk, Assistance: Km 
	@Test
	public void ShouldAddThreeProducts()
	{
		ShoppingCart sc = new ShoppingCart();
		Product p = mock(Product.class);
		sc.AddProduct(p, 3);
		
		assertTrue(sc.GetProducts().containsKey(p));
		assertEquals(3, sc.GetProducts().get(p).intValue());
	}
	
	//Writer: Hk, Assistance: Km 
	@Test
	public void ShouldIncrementAmountWhenAddingSameProduct()
	{
		ShoppingCart sc = new ShoppingCart();
		Product p = mock(Product.class);
		sc.AddProduct(p, 3);
		sc.AddProduct(p, 2);
		
		assertEquals(5, sc.GetProducts().get(p).intValue());
	}
	/*
	 * ADD END
	 */
	
	/*
	 * DELETE START
	 */
	//Writer: Hk, Assistance: Km 
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentExceptionWhenNullInput()
	{
		ShoppingCart sc = new ShoppingCart();
		sc.RemoveProduct(null, 1);
	}
	
	//Writer: Hk, Assistance: Km 
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentExceptionWhenLessThanOneProduct()
	{
		ShoppingCart sc = new ShoppingCart();
		
		sc.RemoveProduct(mock(Product.class), 0);
	}
	
	//Writer: Hk, Assistance: Km 
	@Test
	public void ShouldRemoveFourOfFiveProducts()
	{
		ShoppingCart sc = new ShoppingCart();
		Product p = mock(Product.class);
		sc.AddProduct(p, 5);
		
		sc.RemoveProduct(p, 4);
		
		assertEquals(1, sc.GetProducts().get(p).intValue());
	}
	
	//Writer: Hk, Assistance: Km 
	@Test
	public void ShouldRemoveProductFromMap()
	{
		ShoppingCart sc = new ShoppingCart();
		Product p = mock(Product.class);
		sc.AddProduct(p, 5);
		
		sc.RemoveProduct(p, 5);
		
		assertFalse(sc.GetProducts().containsKey(p));
	}
	/*
	 * DELETE END
	 */
}