/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

import java.util.Iterator;

/**
 *
 * @author gerard
 */
public class MeanComposedStrategy extends ComposedStrategy {
    /**
     * 
     * @return the roll of the strategy
     */
    @Override
    public int getRoll(){
        Iterator<IStrategy> it = this.getStrategies().iterator();
        int total = 0;
        while(it.hasNext()){
            total+=it.next().getRoll();
        }
        return total/this.getStrategies().size();
    }
}
