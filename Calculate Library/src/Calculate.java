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
	
	public static double discriminant(double input1,double input2, double input3) {
		
		return ((input2 * input2)- 4 * input1 * input2);
	}
	
	public static String toImproperFrac(int wholenum, int numerator, int denominator) {
		
		return (wholenum * denominator) + numerator + "/" + denominator;
	
	}
	
	public static String toMixedNum(int numerator, int denominator) {
		
		return (numerator/denominator) + "_" + numerator%denominator + "/" + denominator;
	}
	


}
