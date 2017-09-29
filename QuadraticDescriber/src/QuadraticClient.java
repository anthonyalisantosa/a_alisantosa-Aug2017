import java.util.Scanner;

//Anthony Alisantosa
//9/28/17
//Part 5
//2nd Period
//Describing the quadratic equation for the client
public class QuadraticClient {
	public static void main(String[] args) {
	//to make scanner Scanner <scannerName> = new Scanner();

	Scanner clientinput = new Scanner(System.in);
	String clientresponse = "";
	do {
	System.out.println("Please input your 3 coefficients:");
	System.out.println("Enter coefficient a:");
	double a = clientinput.nextDouble();
	System.out.println("Enter coefficient b:");
	double b = clientinput.nextDouble();
	System.out.println("Enter coefficient c:");
	double c = clientinput.nextDouble();
	System.out.println(); //A E S T H E T I C S  K E E P  I T  C L E A N
	System.out.println(Quadratic.quadrDescriber(a, b, c));
	System.out.println("Do you wish to continue? Y/N");
	clientresponse = clientinput.next();
	} while(!clientresponse.equals("N"));
		
	}
	
}
