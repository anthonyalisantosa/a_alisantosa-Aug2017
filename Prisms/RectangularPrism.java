/* 
 * Anthony Alisantosa
 * 2/21/18
 * Period 2
 * 
 * Class RectangularPrism extends Prism and inherits Prism's height. Uses
 * given length and width to calculate the area of base sides. Use length and width
 * to calculate base in calcBase(), and calculates the perimeter of the base rectangle.
 * 
 */

public class RectangularPrism extends Prism
{
	private double length;
	private double width;
	
	public RectangularPrism(double length, double width, double height) {
		super(height);
		this.length = length;
		this.width = width;
	}
	
	public double calcBase() {
		return length * width;
	}
	
	public double calcPerimeter() {
		return 2 * (length + width);
	}
}

