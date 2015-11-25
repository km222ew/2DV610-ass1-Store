package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.ShoppingCart;

public class ShoppingCartTests {

	@Test
	public void ShouldInitializeProductMap()
	{
		assertTrue(new ShoppingCart().GetProducts() != null);
	}
}