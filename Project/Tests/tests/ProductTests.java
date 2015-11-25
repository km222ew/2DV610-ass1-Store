package tests;

import java.util.ArrayList;

import org.junit.Test;

import model.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProductTests {

	@Test(expected = IllegalArgumentException.class)
	public void ShouldThrowExceptionOnNullNameInput() 
	{
		new Product(null, 0);
	}

}
