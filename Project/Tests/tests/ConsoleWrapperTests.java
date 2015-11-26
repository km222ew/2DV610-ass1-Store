package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.ConsoleWrapper;

public class ConsoleWrapperTests {
	
	private String newLine;
	private String inputData = "";
	private final ByteArrayInputStream in = new ByteArrayInputStream(inputData.getBytes());	
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	private ConsoleWrapper cw;
	
	@Before
	public void init() 
	{
		cw = new ConsoleWrapper();
		
	    System.setOut(new PrintStream(out));
	    System.setIn(in);
	    
	    newLine = System.getProperty("line.separator");
		if (newLine == null) newLine = "\n";	    
	}

	//Writer: Km
	@Test
	public void ShouldPrintProvidedString() 
	{
		cw.printLine("Hello, my name is Tester");
		
		assertEquals("Hello, my name is Tester"+ newLine, out.toString());
	}
	
	@Test
	public void ShouldReadAndReturnInteger()
	{
		inputData = "2";
		
		int inputInt = cw.readInt();
	
		assertEquals(Integer.parseInt(inputData), inputInt);
	}
	
	@After
	public void resetOutput () 
	{
	    System.setOut(System.out);
	}

}
