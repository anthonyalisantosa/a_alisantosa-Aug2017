/*
 * Author: Anthony Alisantosa
 * Date: 11/1/2017
 * APCS2
 * 
 * Code Desc: Array Mini-Lab experiments with what 
 * changes and what doesn't change when a value is changed
 * outside a main. 
 */
public class LotsOfCopies {
	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		
		System.out.println("num is: " + num + " according to main before changeMe");
		System.out.println("strMain is: \"" + strMain + "\" according to main before changeMe");
		System.out.println("First number of the array is: " + arrMain[0] + " according to main before changeMe");
		System.out.println();
		/*
		 * num is: 7 according to main before changeMe
		 * strMain is: "APCS" according to main before changeMe
		 * First number of the array is: 1 according to main before changeMe
		 */
		
		changeMe(num, strMain, arrMain);
		/*
		 * num is: 8 according to changeMe
		 * strMain is: "APCS period 2" according to changeMe
		 * First number of the array is: 6 according to changeMe
		 */
		
		System.out.println("num is: " + num + " according to main after changeMe");
		System.out.println("strMain is: \"" + strMain + "\" according to main after changeMe");
		System.out.println("First number of the array is: " + arrMain[0] + " according to main after changeMe");
		/*
		 * num is: 7 according to main after changeMe
		 * strMain is: "APCS" according to main after changeMe
		 * First number of the array is: 6 according to main after changeMe
		 */
	}
	
	/**
	 * arrMain[] changes after the method changeMe
	 * because the reference of the value in arrMain[]
	 * passes through main, while other variable types
	 * (Strings, int, etc) do not. Also worth noting 
	 * String is an object-like object that cannot store
	 * values outside the method
	 */
	public static void changeMe(int x, String str, int[] arr) {
		//Part 1
		System.out.println("Changing things.");
		
		x++;
		System.out.println("num is: " + x + " according to changeMe");
		
		str += " period 2";
		System.out.println("strMain is: \"" + str + "\" according to changeMe");
		
		arr[0] = 6;
		System.out.println("First number of the array is: " + arr[0] + " according to changeMe");
		System.out.println();
		
		//Part 2
		
		/*
		 * Expected output: "The value of bInt is: 3"
		 * Actual output: "The value of bInt is: 3"
		 */
		x = 3;
		int bInt = x;
		x = 23;
		System.out.println("The value of bInt is: " + bInt);

		/*
		 * Expected output: "hhhhhhh"
		 * Actual output: "hhhhhhh"
		 */
		str = "hhhhhhh";
		String bString = str;
		str = "iiiiiii";
		System.out.println("The value of bString is: \"" + bString + "\"");
		
		/*
		 * Expected output: "The value of the first number of bArr is: 2"
		 * Actual output: "The value of the first number of bArr is: 3"
		 */
		arr[0] = 2;
		int[] bArr = arr;
		arr[0] = 3;
		System.out.println("The value of the first number of bArr is: " + bArr[0]);
		
		System.out.println();
	}
}
