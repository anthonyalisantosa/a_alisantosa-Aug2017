import java.util.Scanner;

public class Programmer2scode {
	public static void main(String[] args) {
		System.out.println("Gib input plz");
		Scanner input = new Scanner(System.in);
		int userinput = input.nextInt();
		int min = userinput;
		int max = userinput;
		int evensum = 0;
		int evenmax = 1;
		do {
			System.out.println("Gib input plz");
			int newuserinput = input.nextInt();
				if (newuserinput > max) {
					max = newuserinput;
				}
		}
	}
}
				