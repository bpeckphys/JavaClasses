/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.lang.Math.*;

/**
 *
 * @author bpeck
 */
public class Bear extends Critter{
    // Makes ~50% polar bears
    private boolean polar = Math.random() < 0.5;;
    private int moveNumber;
    
    // Construct the Bear
    public Bear(){
        moveNumber = 0;
    }
    
    // Overrides the getColor method from Critter to set the Bear's color
    public Color getColor(){
        if (polar){
            return Color.WHITE;
        }else{
            return Color.BLACK;
        }
    }
    
    // Overrides the toString method from Critter to set the Bear's display string
    public String toString(){
        if (moveNumber % 2 == 1){
            return "/";
        }else{
            return "\\";
        }
    }
    
    // Overrides the getMove method from Critter to get the Bear's move
    public Action getMove(CritterInfo info){
        moveNumber += 1;
        if (info.frontThreat()){
            return Action.INFECT;
        }else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }else{
            return Action.LEFT;
        }
    }
}
