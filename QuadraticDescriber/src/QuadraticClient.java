import java.util.Scanner;

//Anthony Alisantosa
//9/28/17
//Part 5
//2nd Period
//Describing the quadratic equation for the client
//
//Takes the User's responses in the client. 
//Prompts user through a series of Scanners.
public class QuadraticClient {
	public static void main(String[] args) {
	//to make scanner Scanner <scannerName> = new Scanner();

	Scanner clientinput = new Scanner(System.in);	//Creates new scanner to search for user input into the Console
	String clientresponse = "";	//default value for string = empty
	do {	//do/while loop (Does code while clientrespons.equals does not equal "quit")
	System.out.println("Provide values for coefficients a, b, and c");
	System.out.println("a:");
	double a = clientinput.nextDouble();
	System.out.println("b:");
	double b = clientinput.nextDouble();
	System.out.println("c:");
	double c = clientinput.nextDouble();
	System.out.println(); //A E S T H E T I C S  K E E P  I T  C L E A N
	System.out.println("Description of the graph of:");
	System.out.println(a + " x^2 " + b + " x " + c);
	System.out.println(Quadratic.quadrDescriber(a, b, c));
	System.out.println("Do you want to keep going? (Type \"quit\" to end)");
	clientresponse = clientinput.next();
	} while(!clientresponse.equals("quit"));
		
	}
	
}
