/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

/**
 *
 * @author gerard
 */
public class NormalPlayerFactory implements IPlayerFactory{
    /**
     * 
     * @param name The name of the player
     * @param strategy the strategy what the player will use
     * @return the new normal player
     */
    @Override
    public Player createNormalPlayer(String name, IStrategy strategy){
        return new NormalPlayer(name,strategy);
    }
}
