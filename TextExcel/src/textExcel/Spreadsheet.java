/*
 * Spreadsheet creates spreadsheet through 2dimensional arrays
 * holds methods process command that differentiates between
 * different commands and executes their respective methods
 */
package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	
	//Create spreadsheet and fill it with EmptyCells
	Cell[][] cells;
	public Spreadsheet() {
		cells = new Cell[getRows()][getCols()];
		//First for loop goes through rows of spreadsheet
		for(int i = 0; i < getRows(); i++) {
			//Second for loop goes through columns of spreadsheet
			for(int j = 0; j < getCols(); j++) {
				//fills spreadsheet with empty cells
				cells[i][j] = new EmptyCell();
			}
		}
	}

	//processCommand tests for commands that are passed
	//through console. 
	@Override
	public String processCommand(String command)
	{
		/*splits command by parsing by spaces
		 * parsed arguments are divided into an array
		 * called argz
		 */
		String[] argz = command.split(" ");
		//when given an empty command, process command returns nothing
		if(command.equals("")) {
			return "";
		}
		/*
		 * when given command "clear," replaces either one cell 
		 * in spreadsheet or all cells in the spreadsheet
		 * with an EmptyCell
		 */
		if(command.toLowerCase().startsWith("clear")) {
			if(argz.length > 1) { //clears specific cell
				SpreadsheetLocation loc = new SpreadsheetLocation(argz[1]);
				cells[loc.getRow()][loc.getCol()] = new EmptyCell();
			}else { //clears all
				//traverses through rows and columns to fill each cell with EmptyCell
				for(int i = 0; i < 20; i++) {
					for(int j = 0; j < 12; j++) {
						cells[i][j] = new EmptyCell();
					}
				}
			}
			//prints grid
			return getGridText();
		}else {
			SpreadsheetLocation locz = new SpreadsheetLocation(argz[0]);
			/*
			 * tests whether the command is an assignment
			 * if this passes, processCommand filters through
			 * the commands to determine whether it is a:
			 * - TextCell (searches for quotations)
			 * - PercentCell (searches for percent signs)
			 * - FormulaCell (searches for parentheses)
			 * - ValueCell (When all tests fail, it can be
			 * assumed the cell is a ValueCell)
			 */
			if(command.indexOf("=") >= 0) {
				String[] args = command.split(" = ", 2);
				if(command.indexOf("\"") >= 0) {
					cells[locz.getRow()][locz.getCol()] = new TextCell(args[1]);
				}else if(args[1].indexOf("%") >= 0) {
					cells[locz.getRow()][locz.getCol()] = new PercentCell(args[1]);
				}else if(command.indexOf("(") >= 0) {
					cells[locz.getRow()][locz.getCol()] = new FormulaCell(args[1], this);

				}else {
					cells[locz.getRow()][locz.getCol()] = new ValueCell(args[1]);
				}

				return getGridText();
			}else if(command.toLowerCase().charAt(0) >= 'a' && command.toLowerCase().charAt(0) <= 'l'){

				return getCell(locz).fullCellText();

			}else {
				return "";
			}
		}
	}

	@Override
	public int getRows()
	{
		return 20; //20 rows
	}

	@Override
	public int getCols()
	{
		return 12; //12 columns (A through L)
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		int row = loc.getRow();
		int col = loc.getCol();
		return cells[row][col];
	}

	public Cell getCell(int row, int col) {
		return cells[row][col];
	}

	//Creates grid via a series of nested for loops to access and create elements in a 2d array
	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub\
		String sheet = "";
		for(int i = 0; i <= 20; i++) { //20 rows
			for(char j = 'A'; j <= 'L';j++) { //A through L
				if(i == 0) { //Creates row headers
					if(j == 'A') { // Creates letter headers
						sheet += "   |"; //pads for headers
					}

					sheet += String.format("%-10c|",j);
				} else{
					if(j == 'A') {
						sheet += String.format("%-3d|", i);
					}
					sheet += cells[i-1][j-'A'].abbreviatedCellText() + "|"; 
				}
			}
			//enters new row
			sheet += "\n";
		}
		//prints sheet
		return sheet;
	}
}
