/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.folder;
import java.util.*;

/**
 *
 * @author bpeck
 */
public class OddsAndEvens {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        // Asks the user for their name and then greets them
        System.out.println("Let's play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        
        // Propts the user to choose odds or evens
        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String choice = input.next();
        
        // Tells the player their choice and the resulting computer's choice
        if(choice.equalsIgnoreCase("O")){
            System.out.println(name + " has picked odds! The computer will be evens.");
        } else if (choice.equalsIgnoreCase("E")){
            System.out.println(name + " has picked evens! The computer will be odds.");
        } else {
            System.out.println("Please choose either \"E\" or \"O\"");
        }
        System.out.println("------------------------------");
        
        // Prompts the user for their number of fingers
        System.out.print("How many \"fingers\" do you put out? ");
        Integer userNum = input.nextInt();
        
        // Chooses a random number of fingers for the computer
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer plays " + computer + " \"fingers\"");
        System.out.println("------------------------------");
        
        // Calculates and displays the results
        Integer sum = userNum + computer;
        System.out.println(userNum + " + " + computer + " = " + sum);
        boolean oddOrEven = sum % 2 == 0;
        if (oddOrEven){
            System.out.println(sum + " is ...even!");
            if (choice.equalsIgnoreCase("E")){
                System.out.println("That means " + name + " wins!");
            } else {
                System.out.println("That means the computer wins.");
            }
        } else {
            System.out.println(sum + " is ...odd!");
            if (choice.equalsIgnoreCase("O")){
                System.out.println("That means " + name + " wins!");
            } else {
                System.out.println("That means the computer wins.");
            }
        }
        System.out.println("------------------------------");
    }
}
