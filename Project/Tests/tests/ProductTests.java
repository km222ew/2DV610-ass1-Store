package tests;

import java.util.ArrayList;

import org.junit.Test;

import model.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProductTests {

	//Writer: Km, Assistance: Hk 
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowExceptionOnNullNameInput() 
	{
		new Product(null, 1);
	}
	
	//Writer: Km, Assistance: Hk 
	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowExceptionOnTooLowPrice()
	{
		new Product("jarge", 0);
	}
	
	@Test
	public void ShouldHaveProductName()
	{
		String productName = "jarge";
		Product jarge = new Product(productName, 1);
		
		assertEquals(productName, jarge.getProductName());
	}
}
