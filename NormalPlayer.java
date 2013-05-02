/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

/**
 *
 * @author gerard
 */
public class NormalPlayer extends Player{
    /**
     * 
     * @param name String that represents the player name
     * @param strategy Ths strategy what the player will use
     */
    protected NormalPlayer(String name, IStrategy strategy){
        super(name,strategy);
    }
    /**
     * 
     * @return the roll of the player
     */
    @Override
    public int doRoll(){
        return this.getStrategy().getRoll();
    }
}
