package textExcel;

public class TextCell implements Cell {

	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String temp = input.substring(1,input.length() - 1);
		while(temp.length() < 10){
			temp += " ";
		}
		return temp.substring(0,10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return input;
	}
	
	String input;
	public TextCell(String s) {
		input = s;
	}
	

}
