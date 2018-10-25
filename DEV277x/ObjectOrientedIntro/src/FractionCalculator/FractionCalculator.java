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
    static Boolean quit = false;
    
    public static void main(String[] args){
        intro();
        
        // Loop until user exits by pressing q
        while (!quit){
            String operation = getOperation();
            Fraction myFirstFraction = getFraction();
            Fraction mySecondFraction = getFraction();
            Fraction myResultFraction;
            Boolean myResult;
            
            // Call relevant Fraction function according to operation input and then output results
            if (operation.toLowerCase().matches("q")){
                quit = true;
            }else if (operation.matches("\\+")){
                myResultFraction = myFirstFraction.add(mySecondFraction);
                System.out.println(myFirstFraction + " + " + mySecondFraction + " = " + myResultFraction);
            }else if (operation.matches("\\-")){
                myResultFraction = myFirstFraction.subtract(mySecondFraction);
                System.out.println(myFirstFraction + " - " + mySecondFraction + " = " + myResultFraction);
            }else if (operation.matches("\\/")){
                myResultFraction = myFirstFraction.divide(mySecondFraction);
                System.out.println(myFirstFraction + " / " + mySecondFraction + " = " + myResultFraction);
            }else if (operation.matches("\\*")){
                myResultFraction = myFirstFraction.multiply(mySecondFraction);
                System.out.println(myFirstFraction + " * " + mySecondFraction + " = " + myResultFraction);
            }else if (operation.matches("\\=")){
                myResult = myFirstFraction.equals(mySecondFraction);
                System.out.println(myFirstFraction + " = " + mySecondFraction + " is " + myResult);
            }
            System.out.println("------------------------------------------------------------------------------");
        }
    }
    
    // Welcome the user
    public static void intro(){
        System.out.println("This program is a fraction calculator/n "
                + "It will add, subtract, multiply and divide fractions until you type Q to quit./n"
                + "Please enter your fractions in the form a/b, where a and b are integers."
                + "------------------------------------------------------------------------------");
    }
    
    
    // Get the operation the user wishes to perform
    public static String getOperation(){
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit): ");
        Scanner input = new Scanner(System.in);
        String operation = input.next();
        while (!operation.toLowerCase().matches("[+-/*=q]")){
            System.out.println("Invalid input (+, -, /, *, = or Q to quit): ");
            operation = input.next();
        }
        if (operation.toLowerCase().matches("q")){
            quit = true;
        }
        return operation;
    }
    
    // Check that the Fraction is a valid fraction
    public static boolean validFraction(String input){
        // If input contains a "/" check that it doesn't start or end with it
        if (input.contains("/")){
            if (input.charAt(0) == '/' || input.endsWith("/")){
                System.out.println("Incorrect input, starts or ends with /");
                return false;
            }
            // Parse the fraction
            int fracLine = input.indexOf("/");
            String numerator = input.substring(0,fracLine);
            //System.out.println("The numerator is " + numerator);
            String denominator = input.substring(fracLine + 1, input.length());
            //System.out.println("The denominator is " + denominator);
            
            // Verify that the numerator and denominator are numbers
            if (!isNumber(numerator) || !isNumber(denominator)){
                System.out.println("Either the numerator or the denominator are not a number");
                return false;
            }else if (denominator.matches("0")){
                System.out.println("Cannot have a denominator of 0");
                return false;
            }
            return true;
        }else{
            // Check if the number is valid
            if (!isNumber(input)){
                System.out.println("String is not a number");
                return false;
            }
            return true;
        }
    }
    
    // Get fraction input from user and gnerate Fraction from the parsed numerator and denominator
    public static Fraction getFraction(){
        int numerator;
        int denominator;
        
        // Get user input fraction
        System.out.println("Please enter a fraction (a/b) or integer (a): ");
        Scanner input = new Scanner(System.in);
        String myFraction = input.next();
        
        // Validate that user input is a valid fraction or a quit call
        while (!validFraction(myFraction)){
            System.out.println("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            myFraction = input.next();
        }
        if (myFraction.toLowerCase().matches("q")){
            quit = true;
        }
        
        // Parse the numerator and denominator from the string and return the Fraction
        if (!myFraction.contains("/")){
            numerator = Integer.parseInt(myFraction);
            return new Fraction(numerator);
        }else{
            int fracLine = myFraction.indexOf("/");
            String numeratorString = myFraction.substring(0,fracLine);
            String denominatorString = myFraction.substring(fracLine + 1, myFraction.length());
            numerator = Integer.parseInt(numeratorString);
            denominator = Integer.parseInt(denominatorString);
            //System.out.println("Numerator = " + numerator);
            //System.out.println("Denominator = " + denominator);
            return new Fraction(numerator, denominator);
        }
    }
    
    // Check if the input is a valid number
    public static boolean isNumber(String input){
        if (input.startsWith("-")){
            input = input.substring(1,input.length());
            //System.out.println("Number starts with a negative"
            //        + "number is now " + input);
        }else if (input.contains("-")){
            //System.out.println("Number did not start with a negative but contains one");
            return false;
        }else if (input.isEmpty()){
            //System.out.println("Number was empty");
            return false;
        }
        
        int i;
        for (i = 0; i < input.length(); i++){
            if (!input.substring(i, i + 1).matches("[0123456789]")){
                return false;
            }
        }
        return true;
    }
}
