import java.util.Scanner;

//Anthony Alisantosa
//10/17/17
//Part 5
//2nd Period
//Describing the quadratic equation for the client

//Takes the User's responses in the client. 
//Prompts user through a series of Scanners.
//Makes sure prompts are 100% IDENTICAL TO QD.JAR
public class QuadraticClient {
	public static void main(String[] args) {
	//to make scanner Scanner <scannerName> = new Scanner();

	Scanner clientinput = new Scanner(System.in);	//Creates new scanner to search for user input into the Console
	String clientresponse = "";	//default value for string = empty
	do {	//do/while loop (Does code while clientrespons.equals does not equal "quit")
	System.out.println("Provide values for coefficients a, b, and c");
	System.out.println();
	System.out.print("a:");	
	//prompts user for first coefficient
	double a = clientinput.nextDouble();	
	//takes next user input
	System.out.print("b:");	
	//prompts user for second coefficient
	double b = clientinput.nextDouble();	
	//takes next user input
	System.out.print("c:");	
	//prompts user for third coefficient
	double c = clientinput.nextDouble();	
	//takes next user input
	System.out.println(); 		//A E S T H E T I C S  K E E P  I T  C L E A N
	System.out.println(Quadratic.quadrDescriber(a, b, c));
	//Calls quadrDescriber (inside same project)
	System.out.println("Do you want to keep going? (Type \"quit\" to end)");
	//Prompts user to decide to loop/stop
	clientresponse = clientinput.next();
	} while(!clientresponse.equals("quit"));
	//"quit" terminates program
		
	}
	
}
