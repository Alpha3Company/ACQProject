/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author gerard
 */
public class NormalRoll extends Roll {
    protected NormalRoll(){
        this.setRollResult(new ArrayList());
    }
    /**
     * 
     * @param game the game 
     */
    @Override
    public void doRound(Game game){
        Iterator<Player> it = game.getPlayerList().iterator();
        Player player1 = it.next();
        Player player2 = it.next();
        int roll1 = player1.doRoll();
        int roll2 = player2.doRoll();
        if(roll1>roll2){
            roll1=roll2-2;
            roll2=roll2+2;
        }else if(roll2>roll1){
            roll2=roll1-2;
            roll1=roll1+2;
        }
        this.getRollResult().add(roll1);
        this.getRollResult().add(roll2);
        storeResult();
    }
    @Override
    public void storeResult(){
        Historical.getInstance().add(this);
    }
}
