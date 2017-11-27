package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	
    	
    	Scanner console = new Scanner(System.in);
    	
    	
    	do {
    		System.out.println("gib numbr pls");
    		String input = console.nextLine();
    		if(input.equals("quit"))
    			break;
    		System.out.println(produceAnswer(input));
    	}
    	while(true);
    }
    
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
    	
    	String[] array = input.split(" ");
    	String operand1 = array[0];
    	String operator = array[1];
    	String operand2 = array[2];
        String answer = "";
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
    	if(operator.equals("+")) {
    		newnum1 = numer1 * secOper[2];
    		newnum2 = numer2 * firstOper[2];
    		den = firstOper[2] * secOper[2];
    		int sum = newnum1 + newnum2;
    		answer = sum + "/" + den;
    	}
    	if(operator.equals("-")) {
    		newnum1 = numer1 * secOper[2];
    		newnum2 = numer2 * firstOper[2];
    		den = firstOper[2] * secOper[2];
    		int difference = newnum1 - newnum2;
    		answer = difference + "/" + den;
    	}
    	if(operator.equals("*")) {
    		int prodnum = numer1 * numer2;
    		int prodden = firstOper[2] * secOper[2];
    		answer = prodnum + "/" + prodden;
    	}
    	if (operator.equals("/")) {
    		int quotnum = numer1 * secOper[2];
    		int quotden = firstOper[2] * numer2;
    		answer = quotnum + "/" + quotden;
    	}
        return answer ;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static int[] splitOperand(String input) {
    	
    	int whole = 0;
    	int num = 0;
    	int den = 1;
    	
    	if(input.indexOf("_") > 0) {	
    		whole = Integer.parseInt(input.substring(0, input.indexOf("_")));
    		num = Integer.parseInt(input.substring(input.indexOf("_") + 1, input.indexOf("/")));
    		den = Integer.parseInt(input.substring(input.indexOf("/") + 1));
    	}
    	else if(input.indexOf("/") > 0) {
    		num = Integer.parseInt(input.substring(0, input.indexOf("/")));
        	den = Integer.parseInt(input.substring(input.indexOf("/") + 1));	
    	} else {
    		whole = Integer.parseInt(input);
    	}
    	
    	int [] arr = {whole, num, den};
    	return arr; 
    }
    
    public static void simplify(int[] array) {
    	if(array[2] < 0) {
    		array[1] *= -1;
    		array[2] *= -1;
    	}
    	array[0] = array[1] / array[2];
    	array[1] = array[1] % array[2];
    	array[1] /= gcf(array[1], array[2]);
    	array[2] /= gcf(array[1], array[2]);
    	if(array[0] < 0 && array[2] < 0) {
    		array[2] *= -1;
    	}
    }
    
    public static String reformat(int[] array) {
    	String result = array[0] + "_" + array[1] + "/" + array[2];
    	if(result.startsWith("0_")) {
    		result = result.substring(2);
    	}
    	if(result.indexOf("_0/") > 0) {
    		result = result.substring(0, result.indexOf("_"));
    	}
    	if
    }
    
    public static int gcf(int factor1, int factor2) {
		
		int i;
		for (i = factor2; !(isDivisibleBy(factor2, i) && isDivisibleBy(factor1, i)); i--) {		//program waits until isdivisbleby(factor2, i) and isdivisibleby(factor1,i) are true. Then i = gcf
		}
		return i;
		}
    public static boolean isDivisibleBy(int numerator, int denominator) {
		
		if (numerator % denominator == 0) {
			return (true);
		} else {
			return (false);
		}
	}
}

