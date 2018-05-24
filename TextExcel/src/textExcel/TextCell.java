package textExcel;

public class TextCell implements Cell {

	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String temp = input.substring(1,input.length() - 1);
		//Creates a temporary String variable to hold input
		while(temp.length() < 10){
			//Checks if the input is less than 10
			//While the length of input is less than 10, abbreviatedCellText() pads with 
			//spaces until the length of the String reaches 10.
			temp += " ";
		}
		return temp.substring(0,10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		//returns original input
		return input;
	}
	
	//fields and constructor. Passes input into TextCell
	String input;
	public TextCell(String s) {
		input = s;
	}
	

}
