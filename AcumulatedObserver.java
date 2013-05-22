/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

import java.util.Iterator;

/**
 *
 * @author gerard
 */
 
public class AcumulatedObserver extends Observer {
    private int[] acumulated;
    public AcumulatedObserver(){
        this.acumulated = new int[2];
    }
    /**
     * 
     * @param game the current game
     * @param roll the current roll
     */
    @Override
    public void updateObserver(Game game,Roll roll){
        Iterator<Player> it = game.getPlayerList().iterator();
        Iterator<Integer> it2 = roll.getRollResult().iterator();
        this.acumulated[0]+=it2.next();
        this.acumulated[1]+=it2.next();
        System.out.println(this.getClass().getName()+":");
        System.out.println("-"+it.next().getName() + ": "+ acumulated[0]);
        System.out.println("-"+it.next().getName() + ": "+ acumulated[1]);
    }
}
