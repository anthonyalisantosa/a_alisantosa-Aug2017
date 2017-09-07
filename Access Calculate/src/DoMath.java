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

	
	}
	
}
