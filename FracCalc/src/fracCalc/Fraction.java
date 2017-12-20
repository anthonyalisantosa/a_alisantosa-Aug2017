package fracCalc;

public class Fraction {
	/*
	 * Creates instances of ints: whole, num, and den
	 * all of which are common "characteristics" of 
	 * fractions that will be taken care of in this 
	 * Fraction object
	 */
	private int whole;
	private int num;
	private int den;
	//constructor Fraction which assigns arguments to fields whole, num, and den
	public Fraction(int whole, int num, int den) {
		this.whole = whole;
		this.num = num;
		this.den = den;
	}
	 /*
	  * Create an instance method that adds, subtracts, multiplies, and divides 2 operands. 
	  * I set the value of "frac" as the second operand. It is also initialized
	  * as Fraction to reference the second operand (in this case frac)'s whole, num, and den.
	  */
	 public Fraction add(Fraction frac) {
		 int resultNum;
		 int resultDen;
		 //checks if first operand's whole num is negative. determines whether to add/sub numerator
		 if(this.whole < 0) {
			/*
			 * resultNum is set to firstOper turned into an improper fraction,
			 *then multiplying the numerator by the denominator of the second
			 *operand
			 */
				resultNum = (this.whole * this.den - this.num) * frac.den;
			} else {
				resultNum = (this.whole * this.den + this.num) * frac.den;
			}
		 //checks if second operand's whole num is negative. adds/sub num from whole
		 if(frac.whole < 0) {
			 /*
			  * resultNum is then set to adding previous resultNum to
			  * the improper fraction'd second operand's numerator.
			  */
			 resultNum += (frac.whole * frac.den - frac.num) * this.den;
		 } else {
			 resultNum += (frac.whole * frac.den + frac.num) * this.den;
		 }
		 //multiply den's together for a common den
		 resultDen = this.den * frac.den;
		 //constructs new object "result" which holds result of adding operators.
		 Fraction result = new Fraction(0, resultNum, resultDen);
		 return result;
	 }
	 public Fraction subtract(Fraction frac) {
		 int resultNum;
		 int resultDen;
		 if(this.whole < 0) {
			 //checks if first operand's whole num is negative. determines whether to add/sub numerator
				resultNum = (this.whole * this.den - this.num) * frac.den;
				/*
				 * resultNum is set to firstOper turned into an improper fraction,
				 *then multiplying the numerator by the denominator of the second
				 *operand
				 */
			} else {
				resultNum = (this.whole * this.den + this.num) * frac.den;
			}
		//checks if second operand's whole num is negative. adds/sub num from whole
		 if(frac.whole < 0) {
			 /*
			  * resultNum is then set to subtracting previous resultNum to
			  * the improper fraction'd second operand's numerator.
			  */
			 resultNum -= (frac.whole * frac.den - frac.num) * this.den;
		 } else {
			 resultNum -= (frac.whole * frac.den + frac.num) * this.den;
		 }
		 resultDen = this.den * frac.den;
		 //constructs new object "result" which holds result of subtracting operators.
		 Fraction result = new Fraction(0, resultNum, resultDen);
		 return result;
	 }
	 public Fraction multiply(Fraction frac) {
		 int resultNum;
		 int resultDen;
		 //checks if first operand whole is pos or neg. adds/subs numer
		 if(this.whole < 0) {
			 /*
			  * resutNum is set to improper fraction of first Operand
			  */
				resultNum = (this.whole * this.den - this.num);
			} else {
				resultNum = (this.whole * this.den + this.num);
			}
		 //checks if second operand whole is pos/neg. adds/subs numer
		 if(frac.whole < 0) {
			 resultNum *= (frac.whole * frac.den - frac.num);
		 } else {
			 resultNum *= (frac.whole * frac.den + frac.num);
		 }
		 resultDen = this.den * frac.den;
		 //constructs new object "result" which holds result of multiplying operators.
		 Fraction result = new Fraction(0, resultNum, resultDen);
		 return result;
	 }
	 public Fraction divide(Fraction frac) {
		int resultNum;
		int resultDen;
		//checks if first operand whole is pos or neg. adds/subs numer
		if(this.whole < 0) {
				resultNum = (this.whole * this.den - this.num) * frac.den;
			} else {
				resultNum = (this.whole * this.den + this.num) * frac.den;
			}
		//checks if second operand whole is pos/neg. adds/subs numer
		if(frac.whole < 0) {
			resultDen = this.den * (frac.whole * frac.den - frac.num);
		} else {
			resultDen = this.den * (frac.whole * frac.den + frac.num);
		}
		 //constructs new object "result" which holds result of dividing operators.
		 Fraction result = new Fraction(0, resultNum, resultDen);
		 return result;
	 }
	 /*
	  * Reduces the resulting improper fraction by dividing
	  * numerator by the denominator, leaving the remainder in
	  * the numerator. Also references the gcf method to reduce
	  * the fraction by the greatest common factor.
	  */
	 public void reduce() {
	    	/*
	    	 * Transfers the negative sign from the
	    	 * denominator to the numerator
	    	 */
	    	if(den < 0) {
	    		num *= -1;
	    		den *= -1;
	    	}
	    	/*
	    	 * Reduces the improper fraction and
	    	 * adds to whole number
	    	 */
	    	whole = num / den;
	    	num = num % den;
	    	/*
	    	 * Finds the greatest common factor
	    	 * to reduce the fraction
	    	 */
	    	int gcf = FracCalc.gcf(num, den);
	    	num /= gcf;
	    	den /= gcf;
	    	/*
	    	 * Removes negative sign from numerator.
	    	 * Just in case.
	    	 */

	    	if(whole < 0 && num < 0) {
	    		num *= -1;
	    	}
	 }
	 /*
	  * Finishing touches. 
	  * Turns Fraction result into a String.
	  * Deletes unnecessary tidbits such as 0 whole numbers,
	  * 0 numerators, and 1 denominators.
	  */
	 public String toString() {
	    	
	    	/*
	    	 * Constructs a String using whole number,
	    	 * numerator, and denominator
	    	 */
	    	String result = whole + "_" + num + "/" + den;
	    	//Delete "0_" if it exists
	    	if(result.startsWith("0_")) {
	    		result = result.substring(2);
	    	}
	    	//Trim off fraction part if numerator is 0
	    	if(result.indexOf("_0/") > 0) {
	    		result = result.substring(0, result.indexOf("_"));
	    	}
	    	/*
	    	 * Entire String should be 0 if number is a fraction
	    	 * and numerator is 0
	    	 */
	    	if(result.startsWith("0/")) {
	    		result = "0";
	    	}
	    	//Trim off /1 if still remaining
	    	if(result.endsWith("/1")) {
	    		result = result.substring(0, result.indexOf("/"));
	    	}
	    	//Return reformatted String
	    	return result;
	    }
}
