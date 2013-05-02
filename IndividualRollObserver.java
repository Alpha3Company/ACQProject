/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;
import java.util.Iterator;
/**
 * 
 *
 * @author gerard
 */
public class IndividualRollObserver extends Observer{
    /**
     * 
     * @param game the current game
     * @param roll the current roll
     */
    @Override
    public void updateObserver(Game game,Roll roll){
        Iterator<Player> it = game.getPlayerList().iterator();
        Iterator<Integer> it2 = roll.getRollResult().iterator();
        System.out.println(this.getClass().getName()+":");
        System.out.println("-"+it.next().getName() + ": "+ it2.next());
        System.out.println("-"+it.next().getName() + ": "+ it2.next());
    }
}
