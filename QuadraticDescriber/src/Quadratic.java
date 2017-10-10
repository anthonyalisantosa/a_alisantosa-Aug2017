//Anthony Alisantosa
//9/28/17
//Part 5
//2nd Period
//Describing the quadratic equation: the code!
public class Quadratic {
	public static String quadrDescriber (double a, double b, double c) {
		String describer = "Description of the graph of: \n" + "y = " + a + " x^2 + " + b + " x + " + c + "\n\n";
		String updown = "Opens: ";
		if (a > 0) {
			updown += "Up \n";
		} else {
			updown += "Down \n";
		}
		double xvertex = -b / (2 * a);
		double yvertex = (a * (xvertex * xvertex)) + (b * xvertex) + c;
		String vertex = "Vertex: (" + round2(xvertex) + ", " + round2(yvertex) + ").\n";
		String axis = "Axis of Symmetry: " + round2(xvertex) + "\n";
		String roots = "x-intercept(s): " + quadForm(a,b,c) + "\n";
		String intercept = "y-intercept: " + c + "\n";		
		
		return describer + updown + axis + vertex + roots + intercept;
	}
	public static double round2(double inputvariable) {
		
		if (inputvariable * 1000 % 10 < 5) {
				return ((inputvariable * 1000) - (inputvariable * 1000 % 10))/1000;
		}
		else {
			return ((inputvariable * 1000) + (10 - (inputvariable * 1000 % 10)))/1000;
		}
	}
	public static double discriminant(double a,double b, double c) {
		
		return ((b * b) - 4 * a * c);
	}
	public static double sqrt(double input) {
		if (input < 0) {
			throw new IllegalArgumentException();
		}
			double j = .001;
					while ( j * j < input - .005 || j * j > input + .005) {
						j = .5 * (input / j + j);
					}
			return round2(j);
	}
	public static String quadForm(double a, double b,double c) {
		if (discriminant(a,b,c) < 0) {
			return "None";
		}
		else if(discriminant(a,b,c) > 0) {
			double max = round2((-b + sqrt(discriminant(a,b,c)))/(2 * a));
			double min = round2((-b - sqrt(discriminant(a,b,c)))/(2 * a));
			return min + " and " + max;
		}
		else {
			return -b / (2 * a) + "";
		}
		
	}
}
