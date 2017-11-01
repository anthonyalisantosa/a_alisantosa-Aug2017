import java.util.Arrays;

/*
 * Author: Anthony Alisantosa
 * Date: 10/30/17
 * 
 * Description: Uses the .split tool to split strings into arrays,
 * and return them as split strings.
 */
public class Split {

	public static void main(String[] args) {
	// Your task Part 0
	//String.split();
	//It's a method that acts on a string, <StringName>.split(<String sp>);
	//Where sp is the string where the string splits
	//And it returns an array
	// Example: "I like apples!".split(" "); 
//		it will split at spaces and return an array of ["I","like","apples!"]
	// Example 2: "I really like really red apples".split("really")
//		it will split at the word "really" and return an array of ["I "," like "," red apples!"]
	//play around with String.split! 
	//What happens if you "I reallyreally likeapples".split("really") ?
		
		
		
		//A series of tests for the code
		
		String mySandwich = "applespineapplesbreadlettustomatobaconmayohambreadcheese";
		System.out.println(splitSandwich(mySandwich));
		
		String BreadonTop = "breadlettustomatobaconmayohambreadcheese";
		System.out.println(splitSandwich(BreadonTop));
		
		String mytomatoBreadBottom = "pineapplecheeselettucebreadbreadtomatotomatotomatobaconmayohambread";
		System.out.println(splitSandwich(mytomatoBreadBottom));
		
		String grilledCheeseSandwich = "breadcheesebread";
		System.out.println(splitSandwich(grilledCheeseSandwich));
		
		String spacedSandwich = "apples pineapples bread lettus lettus bacon bacon tomato bacon mayo ham bread cheese";
		System.out.println(splitSpacedSandwich(spacedSandwich));
		
		String yummySpacedSandwich = "bread tomato bacon bread ham lettus yummy bacon bread";
		System.out.println(splitSpacedSandwich(yummySpacedSandwich));
		
		String wholeLottaBread = "bread bread bread bread bread bread bread";
		System.out.println(splitSpacedSandwich(wholeLottaBread));
	}

	//Your task Part 1:
	/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
	* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
	* What if it's a fancy sandwich with multiple pieces of bread?
	*/
		
	/*
	 * Creates array that splits the given string
	 * by the string "bread"
	 * 
	 * Recreates string by rebuilding it via for loop,
	 * which starts whenever the first bread is found.
	 * The loop stops before the second bread, thus
	 * printing all of the contents within the outside
	 * bread.
	 */
	public static String splitSandwich(String sandwich) {
		String[] nobread = sandwich.split("bread");
		String contents = "";
		int i = 0;
		int end = nobread.length;
		if(!sandwich.startsWith("bread")) {
			i = 1;
		}
		if(!sandwich.endsWith("bread")) {
			end -= 1;
		}
		for(; i < end; i++) {
			contents += nobread[i];
		}
		return contents;
	}


	//Your task Part 2:
	/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
	* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
	* Again, what if it's a fancy sandwich with multiple pieces of bread?
	*/
	
	
	/*
	 * First splits original string by spaces, creating
	 * an array of Strings of the Sandwich.
	 * 
	 * For loop determines where the first bread is
	 * and ends loop once it is found by incrementing 
	 * its position on the array. 
	 */
		  
	public static String splitSpacedSandwich(String sandwich) {
		String[] items = sandwich.split(" ");
		int firstBread = 0;
		for(int i = 0; i < items.length; i++) {
			if(items[i].equals("bread")) {
				firstBread = i;
				break;
			}
		}	
	
	/*
	 * Another for loop determines where the last bread
	 * is by decrementing the length of the array until
	 * the second bread is found, and the loop is stopped.
	 */
		int lastBread = 0;
		for(int i = items.length - 1; i > -1; i--) {
			if(items[i].equals("bread")) {
				lastBread = i;
				break;
			}
		}
		String contents = "";
		for(int i = firstBread + 1; i < lastBread; i++) {
			if(!items[i].equals("bread")) {
				contents += items[i] + " ";
			}
		}
		return contents;
	}
}