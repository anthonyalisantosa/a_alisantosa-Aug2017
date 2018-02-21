/* 
 * Anthony Alisantosa
 * 2/21/18
 * Period 2
 * 
 * Abstract class that holds the Height of all prisms as well as hold abstract methods
 * calcBase() and calcPerimeter(). Also holds methods calcVolume() and calcSA() which return 
 * the volume and surface area of the prism. 
 * 
 * 
 * Write this abstract class called Prism.  It has one private field (height) and a constructor.  
 * It contains the methods calcAreaOfBase, calcPerimeter, calcVolume, and calcSA.
 * None of these methods require parameters.   
 * A couple are abstract - can you tell which ones and why?
 * 
 * Math note:
 * The volume of any prism can be found by multiplying the area of the base by the height.
 * The surface area of any prism can be found by multiplying the perimeter of the base by the height
 *   and then adding on the areas of the 2 bases.
 */


public abstract class Prism extends ThreeDShape
{
	private double height;
	public Prism(double h) {
		height = h;
	}
	
	public abstract double calcBase();
	
	public abstract double calcPerimeter();
	
	public double calcVolume() {
		return calcBase() * height;
	}
	
	public double calcSA() {
		return (calcBase() * 2) + (calcPerimeter() * height);
	}
	
}
	