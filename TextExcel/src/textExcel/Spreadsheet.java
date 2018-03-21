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
		String[] konfliktz = command.split(" ");
		if(command.toLowerCase().startsWith("clear")) {
			if(konfliktz.length > 1) { //clears specific cell
				SpreadsheetLocation loc = new SpreadsheetLocation(konfliktz[1]);
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
			SpreadsheetLocation locz = new SpreadsheetLocation(konfliktz[0]);
			if(command.indexOf("=") >= 0) {
				cells[locz.getRow()][locz.getCol()] = new TextCell(konfliktz[2]);
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
