/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

/**
 *
 * @author gerard
 */
public interface IPlayerFactory {
    public Player createNormalPlayer(String name, IStrategy strategy);
}
