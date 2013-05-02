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
public class WinnerObserver extends Observer {
    /**
     * 
     * @param game the current game
     * @param roll the current roll
     */
    @Override
    public void updateObserver(Game game,Roll roll){
        Iterator<Player> it = game.getPlayerList().iterator();
        Iterator<Integer> it2 = roll.getRollResult().iterator();
        int player1 = it2.next();
        int player2 = it2.next();
        String result=it.next().getName();
        if(player2>player1){
            result = it.next().getName();
        }
        if(player2==player1){
            result = "drawn";
        }
        System.out.println(this.getClass().getName()+":");
        System.out.println("-The winner is: "+result);
    }
}
