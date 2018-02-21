/* 
 * Anthony Alisantosa
 * 2/21/18
 * Period 2
 * 
 * Class Cylinder extends Prism so it inherits height. Uses given 
 * radius to calculate the circular base in calcBase(). Uses calcPerimeter to
 * calculate the circumference of the base circle.
 *
 */
public class Cylinder extends Prism
{
	private double radius;
	
	public Cylinder(double radius, double height) {
		super(height);
		this.radius = radius;
	}
	
	public double calcBase() {
		return (radius * radius) * Math.PI;
	}
	
	public double calcPerimeter() {
		return 2 * radius * Math.PI;
	}
	
}
