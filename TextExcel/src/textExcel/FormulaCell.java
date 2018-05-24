/*
 * Ho boy was this complicated.
 * 
 * FormulaCell takes commands that include references to other cells
 * also holds methods such to calculate SUM and AVG
 */
package textExcel;

public class FormulaCell extends RealCell {
	
	Spreadsheet sheet;
	//Only way for FormulaCell to take in sheet was via constructor
	public FormulaCell(String input, Spreadsheet sheet) {
		super(input);
		this.sheet = sheet;
	}
	

	//Identical abbreviatedCellText() with ValueCell
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

	//Tests for keywords "sum" and "avg" to reference sum methods.
	@Override
	public double getDoubleValue() {
		// TODO Auto-generated method stub
		if(fullCellText().toLowerCase().indexOf("sum") >= 0) {
			//Summation test
			//starts at substring 6 to cut off parentheses, spaces, and SUM
			return sum(fullCellText().substring(6, fullCellText().length() - 2));
		//avg uses sum method to add cells and divide by total number of cells
		}else if(fullCellText().toLowerCase().indexOf("avg") >= 0) {
			//Average test
			//starts at substring 6 to cut off parentheses, spaces, and AVG
			return sum(fullCellText().substring(6, fullCellText().length() - 2))
					/ count(fullCellText().substring(6, fullCellText().length() - 2));
		}
		//Fails past 2 tests, passes fullCellText into calculate (after cutting parentheses and spaces)
		return calculate(fullCellText().substring(2, fullCellText().length() - 2));
	}

	//calculate parses input by spaces and executes necessary operators
	//references recursion in order to accept multiple-operator commands
	public double calculate(String input) {
		String[] array = input.split(" ");
		if(array.length < 2) {
			return Double.parseDouble(array[0]);
		}
		double operand1 = eval(array[0]);
		String operator = array[1];
		double operand2 = eval(array[2]);
		double result = 0;

		//By default, multiOp is false
		boolean multiOp = false;
		//Unless there are more than 3 elements in the array
		if (array.length > 3)
			multiOp = true;
		if(operator.equals("+")) { //addition
			result = operand1 + operand2;
		}
		if(operator.equals("-")) { //subtraction
			result = operand1 - operand2;
		}
		if(operator.equals("*")) { //multiplication
			result = operand1 * operand2;
		}
		if (operator.equals("/")) { //division
			result = operand1 / operand2;

		}
		//operates multiple operators
		if (multiOp) {
			//sets result of first 2 operands as operand 1
			String temp = result + "";
			for(int i = 4; i < array.length; i += 2)
				temp += " " + array[i - 1] + " " + array[i];
			//recursive call to method.
			return calculate(temp);
		//quits loop once there are only 2 operands
		}else {
			return result;
		}
	}
	//tests to recognize whether input holds a reference to another cell
	public double eval(String input) {
		int temp = input.toLowerCase().charAt(0) - 'a';
		if((temp >= 0) && (temp <= 'l' - 'a')) {
			SpreadsheetLocation loca = new SpreadsheetLocation(input);
			return ((RealCell)(sheet.getCell(loca))).getDoubleValue();
		}else {
			return Double.parseDouble(input);
		}
	}
	//sum method adds an area of cells
	public double sum(String input) {
		String[] arr = input.split("-");
		//creates 2 SpreadsheetLocations and adds from up-down, left-right
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
	
	//counts number of cells by multiplying difference in rows and columns
	public double count(String input) {		
		String[] arr = input.split("-");
		SpreadsheetLocation loc1 = new SpreadsheetLocation(arr[0]);
		SpreadsheetLocation loc2 = new SpreadsheetLocation(arr[1]);
		return (loc2.getCol() - loc1.getCol() + 1) * (loc2.getRow() - loc1.getRow() + 1);
	}
}