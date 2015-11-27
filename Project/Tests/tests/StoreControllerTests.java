package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import store.StoreController;

public class StoreControllerTests {

	@Test (expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentExceptionOnNullInput() 
	{
		new StoreController(null, null);
	}

}
