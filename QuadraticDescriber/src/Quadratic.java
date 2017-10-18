//Anthony Alisantosa
//10/17/17
//Part 5
//2nd Period
//Describing the quadratic equation: the code!

/* 
 * Code Description:
 * First prints out quadratic equation given the typed coefficients by the user
 * Calculates whether parabola opens up or down by checking if coefficient 'a' is positive or negative
 * Calculates Axis of Symmetry by returning the x value of the vertex using -b/2a. Calls method round2 to round AoS to nearest hundredth
 * Calculates Vertex by plugging in the x coordinate derived from -b/2a back into the equation for its y coordinate value
 * Calculates roots by using the Quadratic formula. Calls quadForm method, which employs the discriminant method (which uses the square root method)
 * Calculates intercepts by returning double c as inputed by the user, which replicates plugging in 0 as x into the equation
 * Returns in their respective Strings and order
 */
public class Quadratic {
	public static String quadrDescriber (double a, double b, double c) {
		//Plugs in the coefficients given by the user into the quadratic equation ax^2 + bx + c
		String describer = "Description of the graph of: \n" + "y = " + a + " x^2 + " + b + " x + " + c + "\n\n";
		String updown = "Opens: ";
		if (a > 0) {
			//Positive 'a' indicates the parabola opens upwards
			updown += "Up \n";
		} else {
			//Conversely, negative 'a' indicates the parabola opens down
			updown += "Down \n";
		}
		//-b/2a provides the center x coordinate of the graph
		double xvertex = -b / (2 * a);
		//plugging in the x vertex into the original equation provides the y vertex coordinate
		double yvertex = (a * (xvertex * xvertex)) + (b * xvertex) + c;
		//Vertex is given in coordinate form. Make sure to round to 2 decimal places
		String vertex = "Vertex: (" + round2(xvertex) + ", " + round2(yvertex) + ").\n";
		//Just gives the x coordinate of the vertex. Rounded to 2 decimal places
		String axis = "Axis of Symmetry: " + round2(xvertex) + "\n";
		//Uses quadratic equation to find roots, or x intercepts.
		String roots = "x-intercept(s): " + quadForm(a,b,c) + "\n";
		//No calculations needed for the y intercept. If x is 0, the intercept must be coefficient 'c'
		String intercept = "y-intercept: " + c + "\n";		
		
		//returns entire thing as a mega String
		return describer + updown + axis + vertex + roots + intercept;
	}
	public static double round2(double inputvariable) {
		/*
		 * Calculates the input rounded to the hundredths
		 * place by multiplying by 1000 to expose the thousandths
		 * place and checking if the remainder is greater
		 * or less than 5 using the modular (%) function.
		 * A remainder greater than 5 increments the hundredths 
		 * place and 'removes' the thousandths place, while a remainder
		 * less than 5 only 'removes' the thousandths place,
		 * keeping the hundredths place unchanged.
		 */
		//exposes thousandths place
		if (inputvariable * 1000 % 10 < 5) {
				//Does nothing to hundredths place and removes all decimal values after 2 decimal places
				return ((inputvariable * 1000) - (inputvariable * 1000 % 10))/1000;
		} else {
				//Increments by adding 1 to hundredths place
				return ((inputvariable * 1000) + (10 - (inputvariable * 1000 % 10)))/1000;
		}
	}
	public static double discriminant(double a,double b, double c) {
		/*
		 * The discriminant is defined as (b^2-4ac)
		 * This method simply checks whether b^2 - 4ac
		 * results with a positive, negative, or zero integer.
		 * A positive result indicates 2 roots.
		 * A negative result indicates 0 roots.
		 * A 0 result indicates 1 root.
		 */
		return ((b * b) - 4 * a * c);
	}
	public static double sqrt(double input) {
		/*
		 * Uses Newton's method of calculating the Square root of an integer
		 * up to .005 accuracy. Does not accept negative integers.
		 * Instead throws a new IllegalArgumentException error.
		 */
		if (input < 0) {
			throw new IllegalArgumentException();
		}
			//Start with a tiny number that can be incremented through the while loop
			double j = .001;
					//Checks whether the squared square root is within +- .005 of its original input
					while ( j * j < input - .005 || j * j > input + .005) {
						//j's value changes
						j = .5 * (input / j + j);
					}
			//Makes sure the square root value is rounded to the second decimal place
			return round2(j);
	}
	public static String quadForm(double a, double b,double c) {
		/*
		 * Combines methods discriminant, sqrt, and round2 to return the roots
		 * of the quadratic equation through the full quadratic formula:
		 * x = (-b +- (b^2 - 4ac)^.5)/2a
		 * Returns roots
		 */
		if (discriminant(a,b,c) < 0) {
			//If (b^2 - 4ac) < 0, there are no roots
			return "None";
		}
		else if(discriminant(a,b,c) > 0) {
			//If (b^2 - 4ac) > 0, there are 2 roots. Continue calculating with quadratic formula
			double max = round2((-b + sqrt(discriminant(a,b,c)))/(2 * a));
			double min = round2((-b - sqrt(discriminant(a,b,c)))/(2 * a));
			return min + " and " + max;
		}
		else {
			//If (b^2 - 4ac) is neither positive or negative, it must be 0 and therefore only has 1 root at -b/2a
			return -b / (2 * a) + "";
		}
		
	}
}
