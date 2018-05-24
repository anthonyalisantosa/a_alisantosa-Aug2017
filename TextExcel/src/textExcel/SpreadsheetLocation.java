package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String cellName;
	//constructor
	public SpreadsheetLocation(String cellName) {
		this.cellName = cellName;
	}
	
	//Gets number of rows (second character)
    @Override
    public int getRow()
    {
        return Integer.parseInt(cellName.substring(1)) - 1;
    }

    //Gets number of columns (first character)
    @Override
    public int getCol()
    {
        return cellName.toLowerCase().charAt(0) - 'a';
    }

}