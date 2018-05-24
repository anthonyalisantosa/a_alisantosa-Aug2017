/*
 * RealCell is an abstract class that implements class Cell.
 * fullCellText() returns input given.
 * Holds abstract methods used in 
 * PercentCell, FormulaCell, and ValueCell
 */
package textExcel;

public abstract class RealCell implements Cell{

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return input;
	}
	
	private String input;
	
	public RealCell(String input) {
		this.input = input;
	}
	//abstract method inherited to other classes
	//percencell, formulacell, and valuecell
	public abstract double getDoubleValue();

}
