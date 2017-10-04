import java.util.Scanner;

public class Programmer2scode {
	public static void main(String[] args) {
		System.out.println("Gib input plz");
		Scanner input = new Scanner(System.in);
		int userinput = input.nextInt();
		System.out.println("Gib input plz");
		int userinput2 = input.nextInt();
		int min = userinput;
		int max = 0;
			if(userinput < userinput2) {
				min = userinput;
				int max = userinput2;
			} else {
				int min = userinput2;
				int max = userinput;
			}
		System.out.println("Done? Y/N ");
		String yesno = input.next();
		if (yesno.equals("Y")){
			System.out.println("max: " + max  );
		}
		do {
			System.out.println("Gib input plz");
			int newuserinput = input.nextInt();
				if (newuserinput > ) {
				} else {
					
				}
		}
	}