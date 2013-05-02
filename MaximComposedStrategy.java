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
public class MaximComposedStrategy extends ComposedStrategy{
    /**
     * 
     * @return the roll of the strategy
     */
    @Override
    public int getRoll(){
        Iterator<IStrategy> it = this.getStrategies().iterator();
        int max = 0;
        while(it.hasNext()){
            max = Math.max(it.next().getRoll(), max);
        }
        return max;
    }
}
