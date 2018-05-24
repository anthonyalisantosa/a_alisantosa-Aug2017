package textExcel;

public class FormulaCell extends RealCell {
	
	Spreadsheet sheet;
	public FormulaCell(String input, Spreadsheet sheet) {
		super(input);
		this.sheet = sheet;
	}
	

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

	@Override
	public double getDoubleValue() {
		// TODO Auto-generated method stub
		if(fullCellText().toLowerCase().indexOf("sum") >= 0) {
			//Summation test
			return sum(fullCellText().substring(6, fullCellText().length() - 2));
		}else if(fullCellText().toLowerCase().indexOf("avg") >= 0) {
			//Average test
			return sum(fullCellText().substring(6, fullCellText().length() - 2))
					/ count(fullCellText().substring(6, fullCellText().length() - 2));
		}
		return calculate(fullCellText().substring(2, fullCellText().length() - 2));
	}

	public double calculate(String input) {
		String[] array = input.split(" ");
		if(array.length < 2) {
			return Double.parseDouble(array[0]);
		}
		double operand1 = eval(array[0]);
		String operator = array[1];
		double operand2 = eval(array[2]);
		double result = 0;

		boolean multiOp = false;
		if (array.length > 3)
			multiOp = true;
		if(operator.equals("+")) {
			result = operand1 + operand2;
		}
		if(operator.equals("-")) {
			result = operand1 - operand2;

		}
		if(operator.equals("*")) {
			result = operand1 * operand2;

		}
		if (operator.equals("/")) {
			result = operand1 / operand2;

		}
		if (multiOp) {
			String temp = result + "";
			for(int i = 4; i < array.length; i += 2)
				temp += " " + array[i - 1] + " " + array[i];
			return calculate(temp);
		}else {
			return result;
		}
	}
	
	public double eval(String input) {
		int temp = input.toLowerCase().charAt(0) - 'a';
		if((temp >= 0) && (temp <= 'l' - 'a')) {
			SpreadsheetLocation loca = new SpreadsheetLocation(input);
			return ((RealCell)(sheet.getCell(loca))).getDoubleValue();
		}else {
			return Double.parseDouble(input);
		}
	}
	
	public double sum(String input) {
		String[] arr = input.split("-");
		SpreadsheetLocation loc1 = new SpreadsheetLocation(arr[0]);
		SpreadsheetLocation loc2 = new SpreadsheetLocation(arr[1]);
		double sum = 0;
		for(int i = loc1.getRow(); i <= loc2.getRow(); i++) {
			for(int j = loc1.getCol(); j <= loc2.getCol(); j++) {
				Cell cell = sheet.getCell(i, j);
				if(cell instanceof RealCell) {
					sum += ((RealCell)(cell)).getDoubleValue();
				}
			}
		}
		return sum;
	}
			
	public double count(String input) {		
		String[] arr = input.split("-");
		SpreadsheetLocation loc1 = new SpreadsheetLocation(arr[0]);
		SpreadsheetLocation loc2 = new SpreadsheetLocation(arr[1]);
		return (loc2.getCol() - loc1.getCol() + 1) * (loc2.getRow() - loc1.getRow() + 1);
	}
}