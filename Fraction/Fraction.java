package Fraction;

/**
 * Created by DHZ_Bill on 9/12/16.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString() {
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }

    public static int gcd(int m, int n){
        if(n==0){
            return m;
        }
        else{
            return gcd(n, m%n);
        }
    }

    public Fraction simplify(){
        int commonDiviser = gcd(this.numerator, this.denominator);
        Fraction simplified = new Fraction(this.numerator/commonDiviser, this.denominator/commonDiviser);
        return simplified;
    }

    public Fraction add(Fraction newFraction){
        int newDenominator = this.denominator * newFraction.denominator;
        int newNumerator = this.numerator * newFraction.denominator + newFraction.numerator * this.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result.simplify();
    }
}
