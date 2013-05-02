/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

/**
 *
 * @author gerard
 */
public abstract class Player {
    private String name;
    private IStrategy strategy;
    /**
     * 
     * @param name String that represents the player name
     * @param strategy Ths strategy what the player will use
     */
    protected Player(String name, IStrategy strategy){
        this.name = name;
        this.strategy = strategy;
    }
    public abstract int doRoll();
    /**
     * 
     * @return The player name 
     */
    public String getName(){
        return this.name;
    }
    /**
     * 
     * @return The strategy of the player
     */
    public IStrategy getStrategy(){
        return this.strategy;
    }
}
