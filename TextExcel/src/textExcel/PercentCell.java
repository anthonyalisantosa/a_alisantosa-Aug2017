package textExcel;

public class PercentCell extends RealCell {

	double percent;
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		int round = (int)(getDoubleValue() * 100) ;
		String perc = round + "%";
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
