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
		return "";
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
		
		return null;
	}

}
