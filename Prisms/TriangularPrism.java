/* 
 * Anthony Alisantosa
 * 2/21/18
 * Period 2
 * 
 * Class TriangularPrism extends Prism and inherits Prism's height.
 * Uses the length of all 3 sides to calculate the height of the 
 * base triangle to calculate the area of the base triangle. Given all
 * three lengths of sides of the triangle, it uses calcPerimeter to calculate
 * perimeter.
 */


public class TriangularPrism extends Prism
{
	private double sideA;
	private double sideB;
	private double sideC;
	
	public TriangularPrism(double A, double B, double C, double height) {
		super(height);
		sideA = A;
		sideB = B;
		sideC = C;
	}
	
	public double calcBase() {
		double halfp = (sideA + sideB + sideC) / 2.0;
		return Math.sqrt(halfp * (halfp - sideA) * (halfp - sideB) * (halfp - sideC));
	}
	
	public double calcPerimeter() {
		return sideA + sideB + sideC;
	}
}
