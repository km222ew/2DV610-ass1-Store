package tests;
import java.util.ArrayList;

import org.junit.Test;

import model.*;

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
}