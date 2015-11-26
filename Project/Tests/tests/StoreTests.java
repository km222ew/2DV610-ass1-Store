package tests;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import model.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StoreTests {

	//Writer: Hk, Assistance: Km 
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowExceptionOnNullInput()
	{
		new Store(null, mock(ShoppingCart.class));
	}
	
	//Writer: Hk, Assistance: Km 
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowExceptionOnEmptyList()
	{
		new Store(new ArrayList<Product>(), mock(ShoppingCart.class));
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
		
		assertNotEquals(s.GetShoppingCart(), null);
	}
	
	//Writer: Km, Assistance: Hk 
	@Test
	public void ShouldAddProductToCart()
	{
		Store s = MakeStore();
		Product p = mock(Product.class);
		s.AddProductToCart(p, 1);
		
		verify(s.GetShoppingCart(), times(1)).AddProduct(p, 1);
	}
	
	//Writer: Km, Assistance: Hk 
	@Test
	public void ShouldRemoveProductFromCart()
	{
		Store s = MakeStore();
		Product p = mock(Product.class);
		s.RemoveProductFromCart(p, 1);
		
		verify(s.GetShoppingCart(), times(1)).RemoveProduct(p, 1);
	}	
	
	//Writer: Km, Assistance: Hk 
	@Test (expected = UnsupportedOperationException.class)
	public void ShouldReturnUnmodifiableStoreContent()
	{
		Store s = MakeStore();
		
		List<Product> prods = s.GetReadOnlyProducts();		

		prods.add(mock(Product.class));
	}
	
	//Writer: Km, Assistance: Hk 
	@Test (expected = UnsupportedOperationException.class)
	public void ShouldReturnUnmodifiableCartContent()
	{
		Store s = MakeStore();
		
		Map<Product, Integer> cartContent = s.GetReadOnlyCartContent();		
		
		cartContent.put(mock(Product.class), 2);
	}
	
	//Writer: Hk, Assistance: Km
	@Test
	public void ShouldAddNewProductToList()
	{
		Store s = MakeStore();
		
		s.AddAvailableProduct(mock(Product.class));
		assertEquals(2, s.GetProductCount());
	}

	private Store MakeStore()
	{
		ArrayList<Product> al = new ArrayList<Product>();
		al.add(mock(Product.class));
		Store s = new Store(al, mock(ShoppingCart.class));
		return s;
	}
}