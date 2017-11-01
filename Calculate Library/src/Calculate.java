//Anthony Alisantosa
//2017 09 29
//Calculate Library Parts 1 to 4
//2nd period
public class Calculate {
	
	public static int square(int inputvariable) {	//takes an input and returns input squared. 
	
		return inputvariable*inputvariable;
	}
	
	public static int cube(int inputvariable) {
		
		return inputvariable * inputvariable * inputvariable;	//takes an input and returns the input cubed.
	}
	
	public static double average(double inputvariable1, double inputvariable2) {
			
		return (inputvariable1 + inputvariable2) / 2;	//takes the average of 2 inputs
	}
	
	public static double average(double inputvariable1, double inputvariable2, double inputvariable3) {
		
		return (inputvariable1 + inputvariable2 + inputvariable3) / 3;	//takes the average of 3 inputs
	}
	
	public static double toDegrees(double inputvariable) {	//takes input (radians) to degrees
		
		return ((inputvariable / (2*3.14159)) *360);	// pi is rounded to 3.14159. 180 degrees = pi; 2pi = 360 degrees.
	}
	
	public static double discriminant(double a,double b, double c) {	//takes in quadratic equation coefficients
		
		return ((b * b) - 4 * a * c);		// *sung with jack in the box music* x equals negative b, plus or minus the square root, of b squared minus 4 a c, all over 2 a.
	}
	
	public static String toImproperFrac(int wholenum, int numerator, int denominator) {	//takes mixed number and returns improper fraction.
		
		return (wholenum * denominator) + numerator + "/" + denominator;	//multiples whole number by the denominator and adds the numerator.
	
	}
	
	public static String toMixedNum(int numerator, int denominator) {	//takes an improper fraction and returns it in mixed number form
		
		return (numerator/denominator) + "_" + numerator%denominator + "/" + denominator;	//Returns in String form
	}
	public static String foil(int variablea, int variableb, int variablea2, int variableb2, String variable) { //Getting real tired typing these comments- I mean foils a quadratic equation
		
		return ((variablea * variablea2) + variable + "^2" + "+" + ((variablea * variableb2) + (variableb * variablea2)) + variable + "+" + (variableb * variableb2));
		
	}	
	
	public static boolean isDivisibleBy(int numerator, int denominator) {
		
		if (numerator % denominator == 0) {
			return (true);
		} else {
			return (false);
		}
	}
	
	public static double absValue(double inputvariable) {
		
		if ( inputvariable < 0) {				// if inputvariable is negative
			return (inputvariable * -1);		//multiplies by -1
		} else {
			return (inputvariable);
		}
	}
	
	public static double max(double inputvariable1, double inputvariable2) {		//I regret naming my variable inputvariable
		
		if ( inputvariable1 < inputvariable2) {
			return (inputvariable2);
		} else {
			return (inputvariable1);
		}
	}
	
	public static double max( double inputvariable1, double inputvariable2, double inputvariable3) {
		
		if (inputvariable1 < inputvariable2) {
			if (inputvariable2 < inputvariable3) {
				return (inputvariable3);
			} else {
				return (inputvariable2);
			}
		} else {
			return (inputvariable1);
		}
	}
	
	public static int min( int inputvariable1, int inputvariable2) {
		
		if (inputvariable1 < inputvariable2) {
			return (inputvariable1);
		} else {
			return (inputvariable2);
		}
	}
	
	public static double round2(double inputvariable) {
		
		if (inputvariable * 1000 % 10 < 5) {
				return ((inputvariable * 1000) - (inputvariable * 1000 % 10))/1000;		//((1.991 * 1000) - (1.991 * 1000 % 10))/1000 = (1991 - 1)/1000 = 1.99
		} else {
			return ((inputvariable * 1000) + (10 - (inputvariable * 1000 % 10)))/1000;	//((1.999 * 1000) + (10 - (1.999 * 1000 % 10))/1000 = (1999 + (10 - (9))/1000 = 2.0
		}
	}
	
	public static double exponent(double base, int exponent) {
		if (exponent < 0) {
			throw new IllegalArgumentException();										//Part 5 exception
		}
		double product = 1;
				for (int i = 0; i < exponent; i++) {
					product *= base;
				}
				return product;
	}
	
	public static int factorial(int input) {
		int boop = 1;																	//I couldn't decide on a variable name
		if (input <0) {																
			throw new IllegalArgumentException();
		}
		for (int i = input; i > 1; i--) {
			boop *= i;
		}
		return boop;
	}
	public static boolean isPrime(int input) {
		
		if(input < 2) {										//integers 0 and 1 are neither prime or not prime
			return false;
		} else if (input == 2) {							//2 is the only even prime
			return true;
		} else {
		for (int i = 2; i < input; i++) {
			if (isDivisibleBy(input, i)) {					//increments denominators until a divisor is found. returns false (not prime) if found
				return false;
			}
		}
			return true;									//anything else must be prime
		}
	}	
	public static int gcf(int factor1, int factor2) {
		
		int i;
		for (i = factor2; !(isDivisibleBy(factor2, i) && isDivisibleBy(factor1, i)); i--) {		//program waits until isdivisbleby(factor2, i) and isdivisibleby(factor1,i) are true. Then i = gcf
		}
		return i;
		}
	
	public static double sqrt(double input) {
		if (input < 0) {
			throw new IllegalArgumentException();								// Part 5 exceptions. Cannot square root a negative
		}
			double j = .001;
					while ( j * j < input - .005 || j * j > input + .005) {		// Set parameters for within +- .005
						j = .5 * (input / j + j);
					}
			return round2(j);
					}
	public static String quadForm(int a, int b,int c) {
		if (discriminant(a,b,c) < 0) {
			return "no real roots";
		}
		else if(discriminant(a,b,c) > 0) {
			double max = round2((-b + sqrt(discriminant(a,b,c))/(2 * a)));
			double min = round2((-b - sqrt(discriminant(a,b,c))/(2 * a)));
			return min + " and " + max;											// Not sure if she wants in the order of min + max. Doing it just in case :3
		}
		else {
			return -b / (2 * a) + "";
		}
		
	}
		
}

	


