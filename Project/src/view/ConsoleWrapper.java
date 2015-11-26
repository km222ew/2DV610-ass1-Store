package view;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleWrapper {
	
	

	public void printLine(String string) 
	{
		System.out.println(string);	
	}

	public int readInt(InputStream in) 
	{
		Scanner keyboard = new Scanner(in);
		
		int inputInt = keyboard.nextInt();
		
		return inputInt;
	}

}
