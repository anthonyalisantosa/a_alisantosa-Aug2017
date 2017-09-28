//Anthony Alisantosa
//2017 09 06
//Yellow sheet thing
public class Calculate {
	
	public static int square(int inputvariable) {
	
		return inputvariable*inputvariable;
	}
	
	public static int cube(int inputvariable) {
		
		return inputvariable*inputvariable*inputvariable;
	}
	
	public static double average(double inputvariable1, double inputvariable2) {
			
		return (inputvariable1 + inputvariable2) / 2;
	}
	
	public static double average(double inputvariable1, double inputvariable2, double inputvariable3) {
		
		return (inputvariable1 + inputvariable2 + inputvariable3) / 3;
	}
	
	public static double toDegrees(double inputvariable) {
		
		return ((inputvariable / (2*3.14159)) *360);	
	}
	
	public static double discriminant(double a,double b, double c) {
		
		return ((b * b) - 4 * a * c);
	}
	
	public static String toImproperFrac(int wholenum, int numerator, int denominator) {
		
		return (wholenum * denominator) + numerator + "/" + denominator;
	
	}
	
	public static String toMixedNum(int numerator, int denominator) {
		
		return (numerator/denominator) + "_" + numerator%denominator + "/" + denominator;
	}
	public static String foil(int variablea, int variableb, int variablea2, int variableb2, String variable) {
		
		return ((variablea * variablea2) + variable + "^2" + "+" + ((variablea * variableb2) + (variableb * variablea2)) + variable + "+" + (variableb * variableb2));
		
	}	
	
	public static boolean isDivisibleBy(int numerator, int denominator) {
		
		if (numerator % denominator == 0) {
			return (true);
		}
		
		else {
			return (false);
		}
	}
	
	public static double absValue(double inputvariable) {
		
		if ( inputvariable < 0) {
			return (inputvariable * -1);
		}
		
		else {
			return (inputvariable);
		}
	}
	
	public static double max(double inputvariable1, double inputvariable2) {
		
		if ( inputvariable1 < inputvariable2) {
			return (inputvariable2);
		}
		
		else {
			return (inputvariable1);
		}
	}
	
	public static double max( double inputvariable1, double inputvariable2, double inputvariable3) {
		
		if (inputvariable1 < inputvariable2) {
			if (inputvariable2 < inputvariable3) {
				return (inputvariable3);
			}
			
			else {
				return (inputvariable2);
			}
		}
		
		else {
			return (inputvariable1);
		}
	}
	
	public static int min( int inputvariable1, int inputvariable2) {
		
		if (inputvariable1 < inputvariable2) {
			return (inputvariable1);
		}
		
		else {
			return (inputvariable2);
		}
	}
	
	public static double round2(double inputvariable) {
		
		if (inputvariable * 1000 % 10 < 5) {
				return ((inputvariable * 1000) - (inputvariable * 1000 % 10))/1000;
		}
		else {
			return ((inputvariable * 1000) + (10 - (inputvariable * 1000 % 10)))/1000;
		}
	}
	
	public static double exponent(double base, int exponent) {
		if (exponent < 0) {
			throw new IllegalArgumentException();
		}
		int product = 1;
				for (int i = 0; i < exponent; i++) {
					product *= base;
				}
				return product;
	}
	
	public static int factorial(int input) {
		int boop = 1;
		if (input <0) {
			throw new IllegalArgumentException();
		}
		for (int i = input; i > 1; i--) {
			boop *= i;
		}
		return boop;
	}
	public static boolean isPrime(int input) {
		
		if(input < 2) {
			return false;
		}
		
		else if (input == 2) {
			return true;
		}
		
		else {
		for (int i = 2; i < input; i++) {
			if (isDivisibleBy(input, i)) {
				return false;
			}
		}
		
			return true;
		}
	}
		
	public static int gcf(int factor1, int factor2) {
		
		int i;
		for (i = factor2; !(isDivisibleBy(factor2, i) && isDivisibleBy(factor1, i)); i--) {
		}
		return i;
		}
	
	public static double sqrt(double input) {
		if (input < 0) {
			throw new IllegalArgumentException();
		}
			double j = .001;
					while ( j * j < input - .005 || j * j > input + .005) {
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
			return min + " and " + max;
		}
		else {
			return -b / (2 * a) + "";
		}
		
	}
		
}

	


