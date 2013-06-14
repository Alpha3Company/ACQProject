/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

/**
 *
 * @author gerard
 */
public abstract class SimpleStrategy implements IStrategy{
    /**
     *
     * @return random integer according to the requirements
     */
    public int getRandomInt(){
        int value = (int)(Math.random()*100);
        if(value<2){
            value = 2;
        }
        return value;
    }
}
