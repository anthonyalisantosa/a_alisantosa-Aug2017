//Anthony Alisantosa
//2017 09 06
//This is the runner for the calculate library. It is used to test the methods in Calculate
public class DoMath {
	public static void main(String[] args){

		System.out.println(Calculate.square(5));					//25
		System.out.println(Calculate.cube(5)); 						//125
		System.out.println(Calculate.average(6, 17));				//11.5
		System.out.println(Calculate.average(5,7,12));				//8.0
		System.out.println(Calculate.toDegrees(3.14159));			//180.0
		System.out.println(Calculate.discriminant(4, 15, 8));		//97.0
		System.out.println(Calculate.toImproperFrac(4, 3, 5));		//23/5
		System.out.println(Calculate.toMixedNum(23, 5));			//4_3/5
		System.out.println(Calculate.foil(2, 3, 6, -7, "n"));		//12n^2+4n+-21
		System.out.println(Calculate.isDivisibleBy(4, 2));			//true
		System.out.println(Calculate.absValue(-1234));				//1234.0
		System.out.println(Calculate.max(8,2.4));					//8.0
		System.out.println(Calculate.max(1.4, 8.12314, 5324.34));	//5235.34
		System.out.println(Calculate.min(8,3));						//3
		System.out.println(Calculate.round2(1.998798779));			//2.0
		System.out.println(Calculate.exponent(1.5, 5));				//7.59
		System.out.println();
		System.out.println(Calculate.factorial(4));					//24
		System.out.println(Calculate.isPrime(21));					//false
		System.out.println(Calculate.gcf(27, 36));					//9
		System.out.println(Calculate.sqrt(243));					//15.9
		System.out.println(Calculate.quadForm(2, 4, -6));			//"-6.0 and -2.0"

	
	}
	
}
