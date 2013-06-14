/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;
import java.util.Collection;
import java.util.Iterator;
/**
 *
 * @author gerard
 */
public class MediumIntelligentStrategy extends IntelligentStrategy {
    /**
     *
     * @return the medium historic result
     */
    private int getMediumHistoricResult(){
        Iterator<Roll> it = historical.iterator();
        int total=0;
        while(it.hasNext()){
            Collection results = it.next().getRollResult();
            Iterator<Integer> it2 = results.iterator();
            int subtotal=0;
            while(it2.hasNext()){
                subtotal += it2.next();
            }
            total+=subtotal/results.size();
        }
        return total/Historical.getInstance().size();
    }
    /**
     * 
     * @return the roll of the strategy
     */
    @Override
    public int getRoll(){
        if(Historical.getInstance().isEmpty()){
            return getRandomInt();
        }
        return getMediumHistoricResult();
    }
}
