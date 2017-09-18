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
		System.out.println(Calculate.isDivisibleBy(4, 2));
		System.out.println(Calculate.absValue(-1234));
		System.out.println(Calculate.max(8,2.4));
		System.out.println(Calculate.max(1.4, 8.12314, 5324.34));
		System.out.println(Calculate.min(8,3));
		System.out.println(Calculate.round2(24.125666));
		System.out.println(Calculate.isPrime(21));
		System.out.println(Calculate.gcf(27, 36));
		System.out.println(Calculate.sqrt(243));
		

	
	}
	
}
