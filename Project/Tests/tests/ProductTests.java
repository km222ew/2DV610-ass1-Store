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
	
	//Writer: Km, Assistance: Hk 
	@Test
	public void ShouldHaveName()
	{
		String name = "jarge";
		Product jarge = new Product(name, 1);
		
		assertEquals(name, jarge.getName());
	}
}
