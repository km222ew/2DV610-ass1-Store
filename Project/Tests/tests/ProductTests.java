package tests;

import org.junit.Test;
import model.*;
import static org.junit.Assert.*;

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
	
	//Writer: Km, Assistance: Hk 
	@Test
	public void ShouldHaveName()
	{
		String name = "jarge";
		Product jarge = new Product(name, 1);
		
		assertEquals(name, jarge.getName());
	}
	
	//Writer: Km, Assistance: Hk 
	@Test
	public void ShouldHavePrice()
	{
		int price = 5;
		Product apple = new Product("apple", price);
		
		assertEquals(price, apple.getPrice());
	}
}
