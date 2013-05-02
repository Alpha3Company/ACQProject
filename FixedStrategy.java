/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

/**
 *
 * @author gerard
 */

class UnauthorizedValue extends RuntimeException{};

public class FixedStrategy extends SimpleStrategy{
    private int fixed_value;
    /**
     * 
     * @param fixed_value the value that will roll
     */
    public FixedStrategy(int fixed_value){
        if(fixed_value<2 || fixed_value>100){
            throw new UnauthorizedValue();
        }
        this.fixed_value=fixed_value;
    }
    /**
     * 
     * @return the roll of the strategy
     */
    @Override
    public int getRoll(){
        return this.fixed_value;
    }
}
