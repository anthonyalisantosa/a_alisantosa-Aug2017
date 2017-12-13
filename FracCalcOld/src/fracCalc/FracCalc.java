package fracCalc;

import java.util.Scanner;
/**
 * @author Anthony Alisantosa
 * @date 11/30/2017
 * @class APCS 2
 * @description
 * A calculator that supports mathematical operations
 * between fractions and mixed numbers
 * @pseudocode
 * main(){
 * 	create a scanner object
 * 	do while true loop{
 * 		take user input;
 * 		if input is "quit" break loop;
 * 		pass input to produceAnswer() and print;
 * 	}
 * }
 * produceAnswer(){
 * 	create array of terms by splitting at spaces;
 * 	first term is String at first index;
 * 	operator is String at second index;
 * 	second term is String at third index;
 * 	pass first and second terms to parse();
 * 	create return String and result numerator
 * 	and denominator ints;
 * 	switch checks operator String{
 * 		addition
 * 			convert both to improper frac and 
 * 			multiply for common denominator;
 * 			add numerators;
 * 		subtraction
 * 			convert both to improper frac and 
 * 			multiply for common denominator;
 * 			subtract numerators;
 * 		multiplication
 * 			convert both to improper frac; 
 * 			multiply numerators together;
 * 			multiply denominators together;
 * 		division
 * 			convert both to improper frac; 
 * 			multiply first numerator and second denominator;
 * 			multiply second numerator and first denominator;
 * 	}
 * 	pass result String to reduce() and reassign to result;
 * 	pass result String to reformat() and reassign to result;
 * 	return result String;
 * }
 * parse(){
 * 	create and initialize ints for whole, numerator, and
 * 	denominator;
 * 	if input contains "_"
 * 		input is mixed, parse around "_" and "/";
 * 	else if input contains "/" but not "_"
 * 		input is a fraction, parse around "/";
 * 	else
 * 		parse input as whole number;
 * 	create return int[] and initialize with whole, numerator, and
 * 	denominator ints;
 * 	return int[];
 * }
 * reduce(){
 * 	parse String around "/" into numerator and denominator ints;
 * 	if denominator is negative
 * 		make denominator positive and invert numerator;
 * 	int whole is numerator / denominator;
 * 	numerator is reassigned as remainder of numerator / denominator;
 * 	find gcf by passing numerator and denominator to gcf();
 * 	divide both numerator and denominator by gcf and reassign;
 * 	if both whole and numerator are negative
 * 		invert numerator;
 * 	return whole, numerator, and denominator as mixed number;
 * }
 * reformat(){
 * 	if input starts with "0_"
 * 		remove "0_";
 * 	if input contains but does not start with "_0/"
 * 		remove "_0/" and everything following;
 * 	else if starts with "0/"
 * 		reassign input to "0";
 * 	if input ends with "/1"
 * 		remove "/1";
 * 	return input String;
 * }
 * gcf and isDivisibleBy copied from Calculate Library
 */
public class FracCalc {
	
	/*
	 * Runs the FracCalc program and handles user input
	 */
	
    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	
    	
    	Scanner console = new Scanner(System.in);
    	
    	
    	do {
    		//Prompts user for expression
    		System.out.println("Enter your fraction calculation:");
    		String input = console.nextLine();
    		//Breaks loop when user types "quit"
    		if(input.equals("quit"))
    			break;
    		System.out.println(produceAnswer(input));
    	}
    	while(true);
    }
    
    /**
     * Performs calculations to produce an answer
     * @param input
     * The mathematical expression to be resolved
     * @return
     * The result of the mathematical expression
     */
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input){ 
        // TODO: Implement this function to produce the solution to the input
    	
    	//Splits user input into array
    	String[] array = input.split(" ");
    	String operand1 = array[0];
    	String operator = array[1];
    	String operand2 = array[2];
    	
    	boolean multiOp = false;
          if (array.length > 3)
          	multiOp = true;
          
        int[] answer = {0,0,1};
		int[] firstOper = splitOperand(operand1);
		int[] secOper = splitOperand(operand2);
		int numer1 = 0;
		int numer2 = 0;
		int newnum1 = 0;
		int newnum2 = 0;
		int den = 0;
		if(firstOper[0] < 0) {
			numer1 = (firstOper[0] * firstOper[2] - firstOper[1]);
		} else {
			numer1 = (firstOper[0] * firstOper[2] + firstOper[1]);
		}if(secOper[0] < 0) {
			numer2 = (secOper[0] * secOper[2] - secOper[1]);
		} else {
			numer2= (secOper[0] * secOper[2] + secOper[1]);
		}
		/*
		 * Treats numerator as a negative number if
		 * whole number is negative
		 */
    	if(operator.equals("+")) {
    		newnum1 = numer1 * secOper[2];
    		newnum2 = numer2 * firstOper[2];
    		den = firstOper[2] * secOper[2];
    		int sum = newnum1 + newnum2;
    		answer[1] = sum;
    		answer[2] = den;
    	}
    	if(operator.equals("-")) {
    		newnum1 = numer1 * secOper[2];
    		newnum2 = numer2 * firstOper[2];
    		den = firstOper[2] * secOper[2];
    		int diff = newnum1 - newnum2;
    		answer[1] = diff;
    		answer[2] = den;
    	}
    	if(operator.equals("*")) {
    		int prodnum = numer1 * numer2;
    		int prodden = firstOper[2] * secOper[2];
    		answer[1] = prodnum;
    		answer[2] = prodden;
    	}
    	if (operator.equals("/")) {
    		int quotnum = numer1 * secOper[2];
    		int quotden = firstOper[2] * numer2;
    		answer[1] = quotnum;
    		answer[2] = quotden;
    	}
    	
    	 //Reduces the result of the calculations
    	simplify(answer);
    	 //Reformats the array into a String
    	String resultString = reformat(answer);
        
        /*
         * Appends the rest of the user input
         * and inserts back into produceAnswer()
         * if multiOp check passes
         */
        if (multiOp) {
        	String temp = resultString;
        	for(int i = 4; i < array.length; i += 2)
        		temp += " " + array[i - 1] + " " + array[i];
        	resultString = produceAnswer(temp);
        }
        
        //Returns the final answer
        return resultString;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
    /**
     * Interprets user input into an array of ints
     * @param input
     * The mathematical term to be interpreted
     * @return
     * An array of integers representing the operand
     */
    
    public static int[] splitOperand(String input) {
    	
    	int whole = 0;
    	int num = 0;
    	int den = 1;
    	
    	  //Splits as a mixed number if "_" exists
    	if(input.indexOf("_") > 0) {	
    		whole = Integer.parseInt(input.substring(0, input.indexOf("_")));
    		num = Integer.parseInt(input.substring(input.indexOf("_") + 1, input.indexOf("/")));
    		den = Integer.parseInt(input.substring(input.indexOf("/") + 1));
    	}
    	 /*
         * Splits as a fraction if "/" exists
         * and does not contain "_"
         */
    	else if(input.indexOf("/") > 0) {
    		num = Integer.parseInt(input.substring(0, input.indexOf("/")));
        	den = Integer.parseInt(input.substring(input.indexOf("/") + 1));	
    	} 
    	 /*
         * Splits as a whole number if neither
         * "_" nor "/" exist
         */
    	else {
    		whole = Integer.parseInt(input);
    	}
    	
    	int [] arr = {whole, num, den};
    	return arr; 
    }
    
    /**
     * Manipulates an array to simplify it
     * @param arr
     * The array of ints representing a number
     * to be simplified
     */
    public static void simplify(int[] array) {
    	
    	/*
    	 * Transfers the negative sign from the
    	 * denominator to the numerator
    	 */
    	if(array[2] < 0) {
    		array[1] *= -1;
    		array[2] *= -1;
    	}
    	/*
    	 * Reduces the improper fraction and
    	 * adds to whole number
    	 */
    	array[0] = array[1] / array[2];
    	array[1] = array[1] % array[2];
    	/*
    	 * Finds the greatest common factor
    	 * to reduce the fraction
    	 */
    	int gcf = gcf(array[1], array[2]);
    	array[1] /= gcf;
    	array[2] /= gcf;
    	/*
    	 * Removes negative sign from numerator
    	 */

    	if(array[0] < 0 && array[1] < 0) {
    		array[1] *= -1;
    	}
    }
    
    
    /**
     * Builds a String and trims it for
     * formatting conventions
     * @param arr
     * The array representing a number
     * @return
     * A String representing a number
     */
    public static String reformat(int[] array) {
    	
    	/*
    	 * Constructs a String using whole number,
    	 * numerator, and denominator
    	 */
    	String result = array[0] + "_" + array[1] + "/" + array[2];
    	//Delete "0_" if it exists
    	if(result.startsWith("0_")) {
    		result = result.substring(2);
    	}
    	//Trim off fraction part if numerator is 0
    	if(result.indexOf("_0/") > 0) {
    		result = result.substring(0, result.indexOf("_"));
    	}
    	/*
    	 * Entire String should be 0 if number is a fraction
    	 * and numerator is 0
    	 */
    	if(result.startsWith("0/")) {
    		result = "0";
    	}
    	//Trim off /1 if still remaining
    	if(result.endsWith("/1")) {
    		result = result.substring(0, result.indexOf("/"));
    	}
    	//Return reformatted String
    	return result;
  
    }
    
    public static int gcf(int factor1, int factor2) {
    	/* i is declared before the for loop because
		 * it must be returned after the loop.
		 */
		int i;
		/* i can be initialized as either of
		 * the two inputs because any number
		 * greater than the smaller of the two
		 * is inherently invalid. The for loop
		 * continues while one of the numbers
		 * is not divisible by i.
		 */
		for (i = factor2; !(isDivisibleBy(factor2, i) && isDivisibleBy(factor1, i)); i--) {		//program waits until isdivisbleby(factor2, i) and isdivisibleby(factor1,i) are true. Then i = gcf
		}
		return i;
		}
    public static boolean isDivisibleBy(int numerator, int denom) {
    	/* An IllegalArgumentException will be thrown when the divisor
		 * is 0 because you cannot divide by 0.
		 */
		if(denom == 0) {
			throw new IllegalArgumentException();
		}
		if (numerator % denom == 0) {
			return (true);
		} else {
			return (false);
		}
	}
}

