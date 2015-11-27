package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.ConsoleWrapper;

public class ConsoleWrapperTests {
	
	private String newLine;
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();	
	private ConsoleWrapper cw;
	
	private PrintStream stdOut = System.out;
	private InputStream stdIn = System.in;
	
	@Before
	public void Init() 
	{
		cw = new ConsoleWrapper();
		
	    System.setOut(new PrintStream(out));	    
	    
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
	
	//Writer: Km
	@Test
	public void ShouldReadAndReturnInput()
	{
		String data = "hello there";
		ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());	
		System.setIn(in);
		
		String input = cw.readInput(in);
	
		assertEquals(data, input);
	}
	
	@After
	public void ResetOutput () 
	{
	    System.setOut(stdOut);
	    System.setIn(stdIn);
	}

}
