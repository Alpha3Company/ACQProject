/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

/**
 *
 * @author gerard
 */
public class RandomStrategy extends SimpleStrategy{
    /**
     * 
     * @return Return random value 
     */
    @Override
    public int getRoll(){
        return getRandomInt();
    }
}
