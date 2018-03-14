package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    Scanner console = new Scanner(System.in);
	    Spreadsheet spreadsheet = new Spreadsheet();
	    boolean done = true;
	    while(done) {
	    	String input = console.nextLine();
	    	if(input.equals("quit")) {
	    		done = false;
	    	}else {
	    		System.out.println(spreadsheet.processCommand(input));
	    	}
	    }
	}
}
