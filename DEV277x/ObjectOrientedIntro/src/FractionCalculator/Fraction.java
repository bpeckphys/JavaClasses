/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FractionCalculator;

/**
 *
 * @author bpeck
 */
public class Fraction {
    private int numerator;
    private int denominator;
    
    // Returns a Fraction object
    public Fraction(int myNumerator, int myDenominator){
        if (myDenominator == 0){
            throw new IllegalArgumentException("Cannot have \"0\" as a denominator!");
        }else if (myDenominator < 0){
            denominator = - myDenominator;
            numerator = - myNumerator;
        }else{
            denominator = myDenominator;
            numerator = myNumerator;
        }
    }
    
    // Overloaded Fraction object to handle whole numbers
    public Fraction(int myNumerator){
        this(myNumerator, 1);
    }
    
    // Overloaded Fraction object to handle 0
    public Fraction(){
        this(0, 1);
    }
    
    // Returns the numerator from the Fraction object
    public int getNumerator(){
        return this.numerator;
    }
    
    // Returns the denominator from the Fraction object
    public int getDenominator(){
        return this.denominator;
    }
    
    // Returns the Fraction object as a string
    public String toString(){
        return numerator + "/" + denominator;
    }
    
    // Returns the Fraction object as a double value
    public double toDouble(){
        return ((double) numerator) / ((double) denominator);
    }
    
    // Returns the sum of two Fraction objects
    public Fraction add(Fraction other){
        if(other.denominator == this.denominator){
            int myNum = this.numerator + other.numerator;
            return new Fraction(myNum, denominator).toLowestTerms();
        }else{
            int myNum = this.numerator * other.denominator;
            int otherNum = other.numerator * this.denominator;
            int myDen = this.denominator * other.denominator;
            myNum = myNum + otherNum;
            return new Fraction(myNum, myDen).toLowestTerms();
        }
    }
    
    // Returns the difference of two Fraction objects
    public Fraction subtract(Fraction other){
        int myNum;
        if(other.denominator == this.denominator){
            myNum = this.numerator - other.numerator;
            return new Fraction(myNum, denominator).toLowestTerms();
        }else{
            myNum = this.numerator * other.denominator;
            int otherNum = other.numerator * this.denominator;
            int myDen = this.denominator * other.denominator;
            myNum = myNum - otherNum;
            return new Fraction(myNum, myDen).toLowestTerms();
        }
    }
    
    // Returns the product of two Fraction objects
    public Fraction multiply(Fraction other){
        int myNum = this.numerator * other.numerator;
        int myDen = this.denominator * other.denominator;
        return new Fraction(myNum, myDen).toLowestTerms();
    }
    
    // Returns the quotient of two Fraction objects
    public Fraction divide(Fraction other){
        int myNum = this.numerator * other.denominator;
        int myDen = this.denominator * other.numerator;
        return new Fraction(myNum, myDen).toLowestTerms();
    }
    
    // Returns a boolean of two Fraction objects are equal in reduced form
    public boolean equals(Object other){
        if (other instanceof Fraction){
            System.out.println("This is an instance of Fraction");
            if(this.toLowestTerms() == ((Fraction) other).toLowestTerms()){
                System.out.println("The reduced forms are equal"
                        + "Reduced form of fraction 1 is: " + this.toLowestTerms() 
                        + "Reduced form of fraction 2 is: " + ((Fraction) other).toLowestTerms());
                return true;
            }else{
                System.out.println("The reduced forms are NOT equal");
                return false;
            }
        }else{
            throw new IllegalArgumentException("Must be a fraction!");
        }
    }
    
    // Returns the reduced Fraction object
    public Fraction toLowestTerms(){
        int myGcd = gcd(numerator, denominator);
        int myNum = numerator / myGcd;
        int myDen = denominator / myGcd;
        return new Fraction(myNum, myDen);
    }
    
    // Returns the greatest common divisor of two integers
    public static int gcd(int numerator, int denominator){
        int gcdNum = numerator;
        int gcdDen = denominator;
        while (gcdNum != 0 && gcdDen != 0){
            int remainder = gcdNum % gcdDen;
            gcdNum = gcdDen;
            gcdDen = remainder;
        }
        return gcdNum;
    }
}
