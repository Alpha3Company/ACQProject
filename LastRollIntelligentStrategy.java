/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Gerard
 */
public class LastRollIntelligentStrategy extends IntelligentStrategy {

    /**
     * 
     * @return the roll of the strategy
     */
    @Override
    public int getRoll() {
        Iterator<Roll> it = historical.iterator();
        if (Historical.getInstance().isEmpty()) {
            int value = (int) (Math.random() * 100);
            if (value < 2) {
                value = 2;
            }
            return value;
        }
        int total = 0;
        Collection results = it.next().getRollResult();
        while (it.hasNext()) {
            results = it.next().getRollResult();
        }
        Iterator<Integer> it2 = results.iterator();
        while (it2.hasNext()) {
            total = Math.max(it2.next(), total);
        }
        return total;
    }
}
