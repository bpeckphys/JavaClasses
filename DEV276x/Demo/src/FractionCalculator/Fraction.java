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
    
    private Fraction(int myNumerator, int myDenominator){
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
    
    public Fraction(int myNumerator){
        this(myNumerator, 1);
    }
    
    public Fraction(){
        this(0, 1);
    }
    
    public int getNumerator(){
        return this.numerator;
    }
    
    public int getDenominator(){
        return this.denominator;
    }
    
    public String toString(){
        return numerator + "/" + denominator;
    }
    
    public double toDouble(){
        return ((double) numerator) / ((double) denominator);
    }
    
    private Fraction add(Fraction other){
        if(other.denominator == this.denominator){
            numerator = this.numerator + other.numerator;
            return new Fraction(numerator, denominator);
        }else{
            numerator = this.numerator * other.denominator;
            denominator = this.denominator * other.denominator;
            other.numerator = other.numerator * this.denominator;
            numerator = this.numerator + other.numerator;
            return new Fraction(numerator, denominator);
        }
    }
    
    private Fraction subtract(Fraction other){
        if(other.denominator == this.denominator){
            numerator = this.numerator - other.numerator;
            return new Fraction(numerator, denominator);
        }else{
            numerator = this.numerator * other.denominator;
            denominator = this.denominator * other.denominator;
            other.numerator = other.numerator * this.denominator;
            numerator = this.numerator - other.numerator;
            return new Fraction(numerator, denominator);
        }
    }
    
    private Fraction multiply(Fraction other){
        numerator = this.numerator * other.numerator;
        denominator = this.denominator * other.denominator;
        return new Fraction(numerator, denominator);
    }
    
    private Fraction divide(Fraction other){
        numerator = this.numerator * other.denominator;
        denominator = this.denominator * other.numerator;
        return new Fraction(numerator, denominator);
    }
    
    public boolean equals(Object other){
        if (other instanceof Fraction){
            if(this.toLowestTerms() == ((Fraction) other).toLowestTerms()){
                return true;
            }else{
                return false;
            }
        }else{
            throw new IllegalArgumentException("Must be a fraction!");
        }
    }
    
    public Fraction toLowestTerms(){
        numerator = numerator / gcd(numerator, denominator);
        denominator = denominator / gcd(numerator, denominator);
        return new Fraction(numerator, denominator);
    }
    
    public static int gcd(int numerator, int denominator){
        while (numerator != 0 && denominator != 0){
            int remainder = numerator % denominator;
            numerator = denominator;
            denominator = remainder;
        }
        return numerator;
    }
}