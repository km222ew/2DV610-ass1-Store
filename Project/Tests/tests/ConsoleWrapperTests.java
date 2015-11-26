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
	public void init() 
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
	public void ShouldReadAndReturnInteger()
	{
		String data = "2";
		ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());	
		System.setIn(in);
		
		int inputInt = cw.readInt(in);
	
		assertEquals(Integer.parseInt(data), inputInt);
	}
	
	@After
	public void resetOutput () 
	{
	    System.setOut(stdOut);
	    System.setIn(stdIn);
	}

}
