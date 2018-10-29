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
public class Tiger extends Critter{
    private int moveNumber;
    private int randThree;
    private Color currentColor;
    
    public Tiger(){
        moveNumber = 0;
    }

    public Color getColor() {
        if (moveNumber % 3 == 0){
            randThree = (int) ((Math.random() * 10) % 3);
            if (randThree == 0){
                currentColor = Color.RED;
                return currentColor;
            }else if (randThree == 1){
                currentColor = Color.GREEN;
                return currentColor;
            }else{
                currentColor = Color.BLUE;
                return currentColor;
            }
        }else{
            return currentColor;
        }
    }
    
    public Action getMove(CritterInfo info) {
        moveNumber += 1;
        if (info.frontThreat()){
            return Action.INFECT;
        }else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT;
        }else if (info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        }else{
            return Action.HOP;
        }
    }

    public String toString() {
        return "TGR";
    }
    
}
