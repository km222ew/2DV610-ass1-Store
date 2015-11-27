package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;
import store.StoreController;
import view.StoreView;
import model.Store;

public class StoreControllerTests {

	@Test (expected = IllegalArgumentException.class)
	public void ShouldThrowIllegalArgumentExceptionOnNullInput() 
	{
		new StoreController(null, null);
	}

	@Test
	public void ShouldAssignConstructorArguments()
	{
		StoreController contr = new StoreController(mock(Store.class), mock(StoreView.class));
		
		assertTrue(contr.model != null);
		assertTrue(contr.view != null);
	}
}
