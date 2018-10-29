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
public class WhiteTiger extends Critter{
    private boolean hasInfected = false;

    public Color getColor() {
        return Color.WHITE;
    }
    
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()){
            hasInfected = true;
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
        if (!hasInfected){
            return "tgr";
        }else{
            return "TGR";
        }
    }
    
}
