package fracCalc;

public class Fraction {
	private int whole;
	private int num;
	private int den;
	public Fraction(int whole, int num, int den) {
		this.whole = whole;
		this.num = num;
		this.den = den;
	}
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
	 public Fraction add(Fraction frac) {
		 int resultNum;
		 int resultDen;
		 if(this.whole < 0) {
				resultNum = (this.whole * this.den - this.num) * frac.den;
			} else {
				resultNum = (this.whole * this.den + this.num) * frac.den;
			}
		 if(frac.whole < 0) {
			 resultNum += (frac.whole * frac.den - frac.num) * this.den;
		 } else {
			 resultNum += (frac.whole * frac.den + frac.num) * this.den;
		 }
		 resultDen = this.den * frac.den;
		 Fraction result = new Fraction(0, resultNum, resultDen);
		 return result;
	 }
	 public Fraction subtract(Fraction frac) {
		 int resultNum;
		 int resultDen;
		 if(this.whole < 0) {
				resultNum = (this.whole * this.den - this.num) * frac.den;
			} else {
				resultNum = (this.whole * this.den + this.num) * frac.den;
			}
		 if(frac.whole < 0) {
			 resultNum -= (frac.whole * frac.den - frac.num) * this.den;
		 } else {
			 resultNum -= (frac.whole * frac.den + frac.num) * this.den;
		 }
		 resultDen = this.den * frac.den;
		 Fraction result = new Fraction(0, resultNum, resultDen);
		 return result;
	 }
	 public Fraction multiply(Fraction frac) {
		 int resultNum;
		 int resultDen;
		 if(this.whole < 0) {
				resultNum = (this.whole * this.den - this.num);
			} else {
				resultNum = (this.whole * this.den + this.num);
			}
		 if(frac.whole < 0) {
			 resultNum *= (frac.whole * frac.den - frac.num);
		 } else {
			 resultNum *= (frac.whole * frac.den + frac.num);
		 }
		 resultDen = this.den * frac.den;
		 Fraction result = new Fraction(0, resultNum, resultDen);
		 return result;
	 }
	 public Fraction divide(Fraction frac) {
		int resultNum;
		int resultDen;
		if(this.whole < 0) {
				resultNum = (this.whole * this.den - this.num) * frac.den;
			} else {
				resultNum = (this.whole * this.den + this.num) * frac.den;
			}
		if(frac.whole < 0) {
			resultDen = this.den * (frac.whole * frac.den - frac.num);
		} else {
			resultDen = this.den * (frac.whole * frac.den + frac.num);
		}
		Fraction result = new Fraction(0, resultNum, resultDen);
		return result;
	 }
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
	    	 * Removes negative sign from numerator
	    	 */

	    	if(whole < 0 && num < 0) {
	    		num *= -1;
	    	}
	 }
}
