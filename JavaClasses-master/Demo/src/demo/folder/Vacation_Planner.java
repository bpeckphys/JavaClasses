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
public class Vacation_Planner {
    
    public static void main(String[] args){
        
        greeting();
        cost();
        time();
        area();
        
    }
    
    public static void greeting(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String destination = input.nextLine();
        
        System.out.println("Great! " + destination + " sounds like a great trip");
        System.out.println("***********");
        System.out.println("");
    }
    
    public static void cost(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        Integer durationDays = input.nextInt();
        
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        Integer spendingUSD = input.nextInt();
        
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currencySymbol = input.next();
        
        System.out.print("How many " + currencySymbol + " are there in 1 USD? ");
        Double currency = input.nextDouble();
        
        Integer durationHours = durationDays * 24;
        Integer durationMinutes = durationHours * 60;
        Double spendingDaily = spendingUSD * 1.0 / durationDays;
        Double spendingCurrency = spendingUSD * currency;
        Double spendingDailyCurrency = spendingCurrency / durationDays;
        
        
        System.out.println("If you are travelling for " + durationDays + " days that is the same as " + durationHours + " hours or " + durationMinutes + " minutes");
        System.out.println("If you are going to spend $" + spendingUSD + " that means per day you can spend up to $" + spendingDaily + " USD");
        System.out.println("Your total budget in " + currencySymbol + " is " + spendingCurrency + " " + currencySymbol + ", which per day is " + spendingDailyCurrency + " " + currencySymbol);
        System.out.println("***********");
        System.out.println("");
    }
    
    public static void time(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        Integer timeDif = input.nextInt();
        
        Integer timeDestMidnight = timeDif % 24;
        Integer timeDestNoon = (timeDif + 12) % 24;
        
        System.out.println("That means that when it is midnight at home it will be " + timeDestMidnight + ":00 in your travel destination");
        System.out.println("and when it is noon at home it will be " + timeDestNoon + ":00");
        System.out.println("***********");
        System.out.println("");
    }
    
    public static void area(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2? ");
        Integer areaKm = input.nextInt();
        
        double areaMiles = areaKm * 0.621371 * 0.621371;
        
        System.out.println("In miles2 that is " + areaMiles);
        System.out.println("***********");
        System.out.println("");
    }
}
