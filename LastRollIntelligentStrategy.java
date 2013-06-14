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
     * @return the max result of the last roll
     */
    private int getLastRollMaxResult() {
        Iterator<Roll> it = historical.iterator();
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

    /**
     * 
     * @return the roll of the strategy
     */
    @Override
    public int getRoll() {
        if (Historical.getInstance().isEmpty()) {
            return getRandomInt();
        }
        return getLastRollMaxResult();
    }
}
