/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FractionCalculator;
import java.util.*;

/**
 *
 * @author bpeck
 */
public class FractionCalculator {
    
    public static void main(String[] args){
        intro();
        getOperation();
        getFraction();
    }
    
    public static void intro(){
        System.out.println("This program is a fraction calculator/n "
                + "It will add, subtract, multiply and divide fractions until you type Q to quit./n"
                + "Please enter your fractions in the form a/b, where a and b are integers."
                + "------------------------------------------------------------------------------");
    }
    
    public static String getOperation(){
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit: ");
        Scanner input = new Scanner(System.in);
        String operation = input.next();
        while (!operation.matches("[+-/*=Q]")){
            System.out.println("Invalid input (+, -, /, *, = or Q to quit: ");
            operation = input.next();
        }
        return operation;
    }
    
    public static boolean validFraction(String input){
        if (input.contains("/")){
            if (input.startsWith("/") || input.endsWith("/")){
                return false;
            }
            int fracLine = input.indexOf("/");
            String numerator = input.substring(0,fracLine);
            String denominator = input.substring(fracLine + 1,input.length());
            if (!isNumber(numerator) || !isNumber(denominator)){
                return false;
            }else if (denominator.matches("0")){
                return false;
            }
            return true;
        }else{
            if (!isNumber(input)){
                return false;
            }
            return true;
        }
    }
    
    public static Fraction getFraction(){
        int numerator;
        int denominator;
        System.out.println("Please enter a fraction (a/b) or integer (a): ");
        Scanner input = new Scanner(System.in);
        String myFraction = input.next();
        while (!validFraction(myFraction)){
            System.out.println("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            myFraction = input.next();
        }
        
        // Parse the numerator and denominator from the string
        if (!myFraction.contains("/")){
            numerator = Integer.parseInt(myFraction);
            return Fraction(numerator);
        }else{
            
        }
    }
    
    public static boolean isNumber(String input){
        if (input.startsWith("-")){
            input = input.substring(1,input.length());
        }else if (input.contains("-")){
            return false;
        }else if (input.isEmpty()){
            return false;
        }
        
        int i;
        for (i = 0; i < input.length(); i++){
            if (!input.contains("[0123456789]")){
                return false;
            }
        }
        return true;
    }
}
