/*
 * Author: Anthony Alisantosa
 * Date: 11/1/2017
 * APCS2
 * 
 * Code Desc: Array Mini-Lab experiments with what 
 * changes and what doesn't change when a value is changed
 * outside a main. 
 */
public class LotsOfCopies {
	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		
		System.out.println("Nothing has changed... yet! Currently 'num' is " + num + "!");
		System.out.println("Nothing has changed... yet! Currently 'strMain' is " + strMain + "!" );
		System.out.println("Nothing has changed... yet! Currently  the fifth number of 'arrrMain'  is " + arrMain[4] + "!");
		System.out.println();
		
		changeMe(num, strMain, arrMain);
		
		System.out.println("Beep-boop. Method changeMe has changed num. num is now " + num + ". Beep boop.");
		System.out.println("Beep-boop. Method changeMe has changed strMain. strMain is now \"" + strMain + "\". Blip blop.");
		System.out.println("Beep-boop. Method changeMe has changed arrMain. The fifth number of arrMain is now " + arrMain[4] + ". Ding dong.");
		
	}
	
	/**
	 * Seems like variable types such as int's and String's 
	 * seem to be unaffected by changing their values outside 
	 * a main by a method in the end. However, Array's seem to
	 * continue storing the changes made by the method.
	 */
	
	public static void changeMe(int x, String str, int[] arr) {
		System.out.println("Commence changing!");
		System.out.println();
	
		//Beep-boop. Method changeMe has changed num. num is now 8. Beep boop.
		x++;
		System.out.println("Beep-boop. Method changeMe has changed num. num is now " + x + ". Beep boop.");
		
		//Beep-boop. Method changeMe has changed strMain. strMain is now "APCS is the best class!" Blip blop.
		str += " is the best class!";
		System.out.println("Beep-boop. Method changeMe has changed strMain. strMain is now \"" + str + "\" Blip blop.");
		
		//Beep-boop. Method changeMe has changed arrMain. The fifth number of arrMain is now 64. Ding dong.
		arr[4] = 64;
		System.out.println("Beep-boop. Method changeMe has changed arrMain. The fifth number of arrMain is now " + arr[4] + ". Ding dong.");
		System.out.println();
	}
}

