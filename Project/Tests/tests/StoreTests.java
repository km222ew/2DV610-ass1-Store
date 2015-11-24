package tests;
import org.junit.Test;

import model.Store;

public class StoreTests {

	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowExceptionOnNullInput()
	{
		new Store(null);
	}
}