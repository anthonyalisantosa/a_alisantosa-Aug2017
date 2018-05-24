/*
 * ValueCell inherits abstract methods from
 * interface RealCell. Called when input
 * is a numerical value, which is parsed into 
 * a double.
 */
package textExcel;

public class ValueCell extends RealCell {

	@Override
	//guarantees String that is printed into 
	//textexcel is within the 10 character limit.
	//pads with spaces when input is less than 10 characters.
	//cuts characters off after 10th character.
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String temp1 = getDoubleValue() + "";
		if(temp1.length() >= 10) {
			return temp1.substring(0, 10);
		}else {
			String temp = temp1;
			while(temp.length() < 10) {
				temp += " ";
				
			}
			return temp;
		}
	}
	
	//returns the double value of String fullCellText()
	//and parses it into a String.
	public double getDoubleValue() {
		// TODO Auto-generated method stub
		return Double.parseDouble(fullCellText());
	}
	
	//Constructor and inheritance from superclass
	public ValueCell(String input) {
		super(input);
	}

}
