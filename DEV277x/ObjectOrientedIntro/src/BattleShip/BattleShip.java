/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleShip;
import java.util.*;
/**
 *
 * @author bpeck
 */
public class BattleShip {
    public static String[][] ocean;
    public static String[][] compOcean;
    
    public static void main(String[] args){
        ocean = new String[10][10];
        compOcean = new String[10][10];
        intro();
        printOcean();
        placeShips();
        gamePlay();
    }
    
    public static void intro(){
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println("");
        System.out.println("Right now, the sea is empty.");
        System.out.println("");
    }
    
    public static void printOcean(){
        System.out.println("   0123456789   ");
        for (int i = 0; i < ocean.length; i++){
            System.out.print(i + " |");
            for (int j = 0; j < ocean[i].length; j++){
                if (ocean[i][j] == null || ocean[i][j].matches("[*2]")){
                    System.out.print(" ");
                }else if(ocean[i][j].matches("1")){
                    System.out.print("@");
                }else{
                    System.out.print(ocean[i][j]);
                }
            }
            System.out.println("| " + i);
        }
        System.out.println("   0123456789   ");
    }
    
    public static void placeShips(){
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            boolean valid = false;
            while (!valid){
                System.out.print("Enter X coordinate for your ship number " + (i+1) + ": ");
                int x = input.nextInt();
                if(x < 0 || x > 9){
                    valid = false;
                }else{
                    System.out.print("Enter Y coordinate for your ship number " + (i+1) + ": ");
                    int y = input.nextInt();
                    if(y < 0 || y > 9){
                        valid = false;
                    }else if (ocean[x][y] == null){
                        ocean[x][y] = "1";
                        compOcean[x][y] = "1";
                        valid = true;
                    }else{
                        valid = false;
                    }
                }
            }
        }
        System.out.println("");
        System.out.println("");
        printOcean();
        for (int i = 0; i < 5; i++){
            boolean valid = false;
            while (!valid){
               Random rand = new Random();
                int x = rand.nextInt(10);
                if(x < 0 || x > 9){
                    valid = false;
                }else{
                    int y = rand.nextInt(10);
                    if(y < 0 || y > 9){
                        valid = false;
                    }else if (ocean[x][y] == null){
                        ocean[x][y] = "2";
                        compOcean[x][y] = "2";
                        valid = true;
                    }else{
                        valid = false;
                    }
                }
            }
        }
    }
    
    public static String[][] gamePlay(){
        int myShips = 5;
        int compShips = 5;
        Scanner input = new Scanner(System.in);
        while (!gameOver(myShips,compShips)){
            System.out.println("YOUR TURN");
            boolean valid = false;
            while (!valid){
                System.out.print("Enter X coordinate: ");
                int x = input.nextInt();
                if(x < 0 || x > 9){
                    valid = false;
                }else{
                    System.out.print("Enter Y coordinate: ");
                    int y = input.nextInt();
                    if(y < 0 || y > 9){
                        valid = false;
                    }else if (ocean[x][y] == null){
                        System.out.println("Sorry, you missed");
                        ocean[x][y] = "-";
                        valid = true;
                    }else{
                        //System.out.println("Valid guess");
                        if(ocean[x][y].matches("2")){
                            System.out.println("Boom! You sunk the ship!");
                            ocean[x][y] = "!";
                            compOcean[x][y] = "!";
                            compShips -= 1;
                        }else if (ocean[x][y].matches("1")){
                            System.out.println("Oh no, you sunk your own ship :(");
                            ocean[x][y] = "x";
                            compOcean[x][y] = "x";
                            myShips -= 1;
                        }else{
                            System.out.println("Sorry, you missed");
                            ocean[x][y] = "-";
                        }
                        valid = true;
                    }
                }
            }
            gameOver(myShips,compShips);
            System.out.println("");

            System.out.println("COMPUTER'S TURN");
            Random rand = new Random();
            valid = false;
            while (!valid){
                int x = rand.nextInt(10);
                if(x < 0 || x > 9){
                    valid = false;
                }else{
                    int y = rand.nextInt(10);
                    if(y < 0 || y > 9){
                        valid = false;
                    }else if (compOcean[x][y] == null){
                        compOcean[x][y] = "*";
                        System.out.println("Computer missed");
                        valid = true;
                    }else if (compOcean[x][y].matches("[!x*]")){
                        valid = false;
                    }else{
                        if(compOcean[x][y].matches("1")){
                            System.out.println("The Computer sunk one of your ships!");
                            ocean[x][y] = "x";
                            compOcean[x][y] = "x";
                            myShips -= 1;
                        }else if (ocean[x][y].matches("2")){
                            System.out.println("The Computer sunk one of its own ships");
                            ocean[x][y] = "!";
                            compOcean[x][y] = "!";
                            compShips -= 1;
                        }else{
                            System.out.println("Computer missed");
                            compOcean[x][y] = "*";
                        }
                        valid = true;
                    }
                }
            }
            gameOver(myShips,compShips);
            System.out.println("");
            printOcean();
            System.out.println("");
            System.out.println("Your ships: " + myShips + " | Computer ships: " + compShips);
            System.out.println("-------------------------------------------------------");
            System.out.println("");
        }
        return ocean;
    }
    
    public static boolean gameOver(int myShips, int compShips){
        if (myShips == 0){
            System.out.println("Hooray! You win the battle :)");
            System.exit(0);
        }else if (compShips == 0){
            System.out.println("Oh no! You lose the battle :(");
            System.exit(0);
        }
        return false;
    }
}
