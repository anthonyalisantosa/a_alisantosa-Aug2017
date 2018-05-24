package textExcel;

public class ValueCell extends RealCell {

	@Override
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

	public double getDoubleValue() {
		// TODO Auto-generated method stub
		return Double.parseDouble(fullCellText());
	}
	
	public ValueCell(String input) {
		super(input);
	}

}
