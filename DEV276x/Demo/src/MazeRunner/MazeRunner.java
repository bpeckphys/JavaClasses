/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeRunner;
import java.util.*;
/**
 *
 * @author bpeck
 */
public class MazeRunner {
    static Maze myMap = new Maze();
    static Integer moves = 0;
    
    public static void main(String[] args){
        intro();
        
        while(!myMap.didIWin()){
            userMove();
        }
        if(myMap.didIWin()){
            System.out.println("Congratulations, you made it out alive and you did it in " + moves + " moves!");
            System.exit(0);
        }
    }
    
    public static void intro(){
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
    }
    
    public static String userMove(){
        Scanner input = new Scanner(System.in);
        movesMessage(moves);
        String direction = "";
        while (!direction.matches("[RLUD]")){
            System.out.print("Where would you like to move? (R, L, U, D) ");
            direction = input.next();
            
            if(direction.matches("[RLUD]")){
                System.out.println("You chose to move in the " + direction + " direction");
            }else{
                System.out.println("Must be a valid direction (R, L, U, D)");
            }
            
            if(direction.matches("R")){
                if(myMap.canIMoveRight()){
                    myMap.moveRight();
                    ++moves;
                }else if (myMap.isThereAPit("R")){
                    navigatePit(direction);
                }else{
                    System.out.println("Sorry, you've hit a wall.");
                    direction = "";
                }
            }else if (direction.matches("L")){
                if(myMap.canIMoveLeft()){
                    myMap.moveLeft();
                    ++moves;
                }else if (myMap.isThereAPit("L")){
                    navigatePit(direction);
                }else{
                    System.out.println("Sorry, you've hit a wall.");
                    direction = "";
                }
            }else if (direction.matches("U")){
                if(myMap.canIMoveUp()){
                    myMap.moveUp();
                    ++moves;
                }else if (myMap.isThereAPit("U")){
                    navigatePit(direction);
                }else{
                    System.out.println("Sorry, you've hit a wall.");
                    direction = "";
                }
            }else if (direction.matches("D")){
                if(myMap.canIMoveDown()){
                    myMap.moveDown();
                    ++moves;
                }else if (myMap.isThereAPit("D")){
                    navigatePit(direction);
                }else{
                    System.out.println("Sorry, you've hit a wall.");
                    direction = "";
                }
            }
        }
        myMap.printMap();
        
        return direction;
    }
    
    public static void movesMessage(Integer moves){
        if(moves == 50){
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes.");
        }else if(moves == 75){
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        }else if(moves == 90){
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        }else if(moves == 100){
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:/[");
            System.exit(0);
        }
    }
    
    public static void navigatePit(String direction){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Watch out! There's a pit ahead, jump it? ");
        String jump = input.nextLine();
        if (jump.toLowerCase().startsWith("y")){
            try{
                myMap.jumpOverPit(direction);
            }catch(IllegalArgumentException s){
                System.out.println(s.getMessage());
            }
        }else{
            userMove();
        }
    }
}
