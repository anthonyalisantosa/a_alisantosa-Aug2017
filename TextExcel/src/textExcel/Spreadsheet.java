package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell[][] cells;
	public Spreadsheet() {
		cells = new Cell[getRows()][getCols()];
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				cells[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command)
	{
		String[] argz = command.split(" ");
		if(command.equals("")) {
			return "";
		}
		if(command.toLowerCase().startsWith("clear")) {
			if(argz.length > 1) { //clears specific cell
				SpreadsheetLocation loc = new SpreadsheetLocation(argz[1]);
				cells[loc.getRow()][loc.getCol()] = new EmptyCell();
			}else { //clears all
				for(int i = 0; i < 20; i++) {
					for(int j = 0; j < 12; j++) {
						cells[i][j] = new EmptyCell();
					}
				}
			}
			return getGridText();
		}else {
			SpreadsheetLocation locz = new SpreadsheetLocation(argz[0]);
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
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
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

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub\
		String sheet = "";
		for(int i = 0; i <= 20; i++) {
			for(char j = 'A'; j <= 'L';j++) {
				if(i == 0) {
					if(j == 'A') {
						sheet += "   |";
					}

					sheet += String.format("%-10c|",j);
				} else{
					if(j == 'A') {
						sheet += String.format("%-3d|", i);
					}
					sheet += cells[i-1][j-'A'].abbreviatedCellText() + "|"; 
				}
			}
			sheet += "\n";
		}

		return sheet;
	}
}
