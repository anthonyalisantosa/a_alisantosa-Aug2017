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
    public static String produceAnswer(String input){ 
    	//Splits user input into array
    	String[] array = input.split(" ");
    	String operand1 = array[0];
    	String operator = array[1];
    	String operand2 = array[2];
    	//checks for multiple operands by checking if the array has more than 2 operands and 1 operator
    	boolean multiOp = false;
          if (array.length > 3)
          	multiOp = true;
        /*
         * firstOper and secOper are set to operand1 and
         * operand2 after being split by "_" and "/" respectively.
         * Become arguments set to fields of Fraction constructor.
         */
        Fraction firstOper = splitOperand(operand1);
        Fraction secOper = splitOperand(operand2);
        //Constructs new object result with default values of whole, num, and den values of 0, 0, 1 respectively
        Fraction result = new Fraction(0, 0, 1);
        //Adds firstOper to secOper
        if(operator.equals("+")) {
        	result = firstOper.add(secOper);
        }
        //Subtracts firstOper by secOper
        if(operator.equals("-")) {
        	result = firstOper.subtract(secOper);
        }
        //Multiples firstOper by secOper
        if(operator.equals("*")) {
        	result = firstOper.multiply(secOper);
        }
        //Divides firstOper by secOper
        if(operator.equals("/")) {
        	result = firstOper.divide(secOper);
        }
        
    	 //Reduces the result of the calculations
    	result.reduce();
    	 //Reformats the array into a String
    	String resultString = result.toString();
        
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
    /**
     * Interprets user input into an array of ints
     * @param input
     * The mathematical term to be interpreted
     * @return
     * An array of integers representing the operand
     */
    
    public static Fraction splitOperand(String input) {
    	
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
    	
    	Fraction result = new Fraction(whole, num, den);
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

