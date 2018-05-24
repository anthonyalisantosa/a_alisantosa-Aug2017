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
	public abstract double getDoubleValue();

}
