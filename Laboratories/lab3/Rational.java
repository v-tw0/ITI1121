public class Rational {

    private int numerator;
    private int denominator;

    public Rational(int numerator) {
        this(numerator, 1);	     
    }

    public Rational(int numerator, int denominator) {
		if(denominator < 0){
			denominator = -1*denominator;
			numerator = -1*numerator;
		}
		this.numerator = numerator;
		this.denominator = denominator;
		reduce();
	}

    public int getNumerator() {
	    return numerator;
    }
	
    public int getDenominator() {
	    return denominator;
    }

    public Rational plus(Rational other) {
		int newDenominator = denominator * other.denominator; 
        int newNumerator = numerator * other.denominator;
        int newOtherNumerator = other.numerator * denominator;
        int sum = newNumerator + newOtherNumerator;
        return new Rational(sum, newDenominator); 
    }

    public static Rational plus(Rational a, Rational b) {
    	return a.plus(b); 
    }

    private void reduce() {
        if(numerator ==0){ 
            denominator =1; 
        }
	    
        else{
            int reduced = gcd(Math.abs(numerator), denominator); 
            numerator = numerator/reduced; 
            denominator = denominator/reduced;
        }
    }

    private int gcd(int a, int b) {
    	while (a != b)
    	    if (a > b)
    		     a = a - b;
    	    else
    		     b = b - a;
    	return a;
    }

    public int compareTo(Rational other) {
        int thisNewNum = other.denominator * numerator;
        int otherNewNum = other.numerator * denominator;

        return thisNewNum - otherNewNum;
    }

    public boolean equals(Rational other) {
        if(numerator == other.numerator && denominator == other.denominator){
			return true;
		}
		return false;
    }
 
    public String toString() {
        return numerator + "/" + denominator; 
    }
}
