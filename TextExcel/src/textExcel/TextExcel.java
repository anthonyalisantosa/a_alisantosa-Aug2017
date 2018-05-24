/*Anthony Alisantosa
 * APCS 2
 * 24 May 2018
 * 
 * Text Excel is an object-oriented coding project that takes
 * in input from the console and interacts with a spreadsheet 
 * similar to a basic version of Microsoft Excel and Google Sheets.
 * 
 * Text excel recognizes commands of:
 * - Cell assignments
 * - Cell inspection
 * - Cell modification
 * - Basic operations (Addition, Subtraction, Division, Multiplication)
 * - Multiple Operation calculations (Requires recursion)
 * - Percent values
 * - Adding cells
 * - Averaging cells
 * 
 * After processing the commands provided by the console, text excel
 * prints out the entire spreadsheet once again. Each cell is padded or cut
 * to lengths of 10 characters maximum.
 * 
 * 
 */

package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{	
		System.out.println("Welcome to Text Excel! Enter arguments:");
		//creates scanner, console
	    Scanner console = new Scanner(System.in);
	    Spreadsheet spreadsheet = new Spreadsheet();
	    //runs TextExcel until "quit" is passed into console
	    boolean done = true;
	    while(done) {
	    	String input = console.nextLine();
	    	if(input.equals("quit")) {
	    		done = false;
	    	}else {
	    		//when TextExcel runs, processes commands in processCommand
	    		System.out.println(spreadsheet.processCommand(input));
	    	}
	    }
	}
}
