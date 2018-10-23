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
        System.out.println("This program is a fraction calculator/n "
                + "It will add, subtract, multiply and divide fractions until you type Q to quit./n"
                + "Please enter your fractions in the form a/b, where a and b are integers."
                + "------------------------------------------------------------------------------");
        getOperation();
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
        
    }
}
