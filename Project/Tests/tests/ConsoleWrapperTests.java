package tests;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.ConsoleWrapper;

public class ConsoleWrapperTests {
	
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private String newLine;
	private ConsoleWrapper cw;
	
	@Before
	public void init() 
	{
		cw = new ConsoleWrapper();
		
	    System.setOut(new PrintStream(out));
	    
	    newLine = System.getProperty("line.separator");
		if (newLine == null) newLine = "\n";	    
	}

	@Test
	public void ShouldPrintProvidedString() 
	{
		cw.printLine("Hello, my name is Tester");
		
		assertEquals("Hello, my name is Tester"+ newLine, out.toString());
	}
	
	@After
	public void resetOutput () 
	{
	    System.setOut(System.out);
	}

}
