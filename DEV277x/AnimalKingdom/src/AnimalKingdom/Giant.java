/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;

/**
 *
 * @author bpeck
 */
public class Giant extends Critter{
    private int moveNumber;
    private int foeNumber;
    
    public Giant(){
        moveNumber = 0;
        foeNumber = 0;
    }

    public Color getColor() {
        return Color.GRAY;
    }
    
    public Action getMove(CritterInfo info) {
        moveNumber += 1;
        if (moveNumber % 6 == 0){
            foeNumber += 1;
        }
        if (info.frontThreat()){
            return Action.INFECT;
        }else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }else{
            return Action.RIGHT;
        }
    }

    public String toString() {
        if (foeNumber % 4 == 0){
            return "fee";
        }else if (foeNumber % 4 == 1){
            return "fie";
        }else if (foeNumber % 4 == 2){
            return "foe";
        }else{
            return "fum";
        }
    }
    
}
