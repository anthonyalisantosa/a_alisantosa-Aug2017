/*
 * PercentCell handles percent commands given by the console
 * inspected cells reveal percentCells as a double
 * Percents are rounded to the nearest one's place
 */
package textExcel;

public class PercentCell extends RealCell {

	double percent;
	
	//rounds to the nearest one's place and adds a percent value
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		//Parses double value into an int
		int round = (int)(getDoubleValue() * 100) ;
		//adds the percent symbol
		String perc = round + "%";
		//cuts and pads according to maximum length, 10
		if(perc.length() >= 10) {
			return perc.substring(0, 10);
		}else {
			String temp = perc;
			while(temp.length() < 10) {
				temp += " ";
				
			}
			return temp;
		}
	}
	//Cuts off percent sign, parses input into a double, and divides by 100
	public PercentCell(String input) {
		super(input);
		percent = Double.parseDouble(input.substring(0, input.length() - 1)) / 100;
	}
	
	@Override
	public String fullCellText() {
		return percent + "";
	}

	@Override
	public double getDoubleValue() {
		// TODO Auto-generated method stub
		
		return percent;
	}

}
