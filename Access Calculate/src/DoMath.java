//Anthony Alisantosa
//2017 09 06
//This is the runner for the calculate library. It is used to test the methods in Calculate
public class DoMath {
	public static void main(String[] args){

		System.out.println(Calculate.square(5));
		System.out.println(Calculate.cube(5));
		System.out.println(Calculate.average(6, 17));
		System.out.println(Calculate.average(5,7,12));
		System.out.println(Calculate.toDegrees(3.14159));
		System.out.println(Calculate.discriminant(4, 15, 8));
		System.out.println(Calculate.toImproperFrac(4, 3, 5));
		System.out.println(Calculate.toMixedNum(23, 5));
		System.out.println(Calculate.foil(2, 3, 6, -7, "n"));
		System.out.println(Calculate.isDivisibleBy(10, 3));
		System.out.println(Calculate.absValue(-8));
		System.out.println(Calculate.max(4, 198087.23112));
		System.out.println(Calculate.max(7000, 98, 3));
		System.out.println(Calculate.min(7, 123));
		

	
	}
	
}
