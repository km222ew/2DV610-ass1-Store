package view;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleWrapper {

	public void printLine(String string) 
	{
		System.out.println(string);	
	}

	public String readInput(InputStream in) 
	{
		Scanner keyboard = new Scanner(in);
		
		String input = keyboard.nextLine();
		
		keyboard.close();
		
		return input;
	}
}
