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
        int value = (int)(Math.random()*100);
        if(value<2){
            value = 2;
        }
        return value;
    }
}
