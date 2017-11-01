import java.util.Scanner;
/*
 * Anthony Alisantosa
 * 10/7/17
 * Code Description
 * Takes in user input and outputs the largest and smallest number, 
 * sum of all even numbers, and the largest even number
 * 
 * Special thanks to Eric Xiao for helping me <3
 */
public class ProcessingNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("How many numbers? ");
		/* totalNums is used to determined how many loops the for loop loops.
		 */
		int totalNums = input.nextInt();
		
		/* Accepts the first number the user inputs
		 * and initializes min and max as that
		 * value so it can be used in the for loop.
		 */
		System.out.print("Enter a number: ");
		int firstInput = input.nextInt();
		int min = firstInput;
		int max = firstInput;
		int evenSum = 0;
		int evenMax = 1;
		int userInput;
		
		for(int i = 1; i < totalNums; i++) {
			System.out.print("Enter a number: ");
			userInput = input.nextInt();
			
			/* If the input is less than the current
			 * min, replace min with input.
			 * If the input is greater than the current
			 * max, replace max with input.
			 */
			if(userInput < min) {
				min = userInput;
			}

			if(userInput > max) {
				max = userInput;
			}
			
			/* If the number is even, add it to evenSum.
			 * Also if evenMax has not changed yet (i.e.
			 * for loop has not encountered an even
			 * number yet) replace evenMax with input.
			 * Otherwise (evenMax has changed and
			 * therefore the for loop has encountered an
			 * even number before the current input) if
			 * input is greater than evenMax, replace
			 * evenMax with input.
			 */
			
			if(userInput % 2 == 0) {
				evenSum += userInput;
				if(evenMax == 1) {
					evenMax = userInput;
				} else if(userInput > evenMax) {
					evenMax = userInput;
				}
			}
		}
		/* Output min and max, and output evenMax and evenSum
		 * only if evenMax is still 1 (i.e. the user has not
		 * typed any even numbers, therefore evenMax has
		 * not changed).
		 */
		System.out.println("The smallest number you typed is: " + min);
		System.out.println("The largest number you typed is: " + max);
		if(evenMax == 1) {
			System.out.println("You did not input any even numbers.");
		} else {
			System.out.println("The sum of all the even numbers you typed is: " + evenSum);
			System.out.println("The largest even number you typed is: " + evenMax);
		}
	}
}