/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

import java.util.Collection;

/**
 *
 * @author gerard
 */
public abstract class Roll {
    private Collection<Integer> roll_result;
    public abstract void doRound(Game game);
    public abstract void storeResult();
    /**
     * 
     * @return The roll result
     */
    public Collection<Integer> getRollResult(){
        return this.roll_result;
    }
    /**
     * 
     * @param roll_result The result to set
     */
    protected void setRollResult(Collection<Integer> roll_result){
        this.roll_result = roll_result;
    }
}
