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
public class NinjaCat extends Critter{
    private int randThree;
    private int randTwo;
    
    public NinjaCat(){
        
    }

    public Color getColor() {
        return Color.darkGray;
    }
    
    public Action getMove(CritterInfo info) {
        randThree = (int) ((Math.random() * 10) % 3);
        randTwo = (int) ((Math.random() * 10) % 2);
        if (info.frontThreat()){
            return Action.INFECT;
        }else if (info.rightThreat()){
            return Action.RIGHT;
        }else if (info.leftThreat()){
            return Action.LEFT;
        }else if (Neighbor.SAME == info.getFront()){
            return Action.RIGHT;
        }else if (Neighbor.WALL == info.getFront()){
            if (randTwo % 2 == 0){
                return Action.RIGHT;
            }else{
                return Action.LEFT;
            }
        }else{
            if (randThree % 3 == 0){
                return Action.HOP;
            }else if (randThree % 3 == 1){
                return Action.RIGHT;
            }else{
                return Action.LEFT;
            }
        }
    }

    public String toString() {
        return "*";
    }
    
}
