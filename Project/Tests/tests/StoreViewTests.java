package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import view.StoreView;

public class StoreViewTests {

	@Test (expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentException()
	{
		new StoreView(null);
	}

}
