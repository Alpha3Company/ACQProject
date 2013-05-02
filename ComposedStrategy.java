/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author gerard
 */
public abstract class ComposedStrategy implements IStrategy{
    private Collection<IStrategy> strategies;
    public ComposedStrategy(){
        this.strategies = new ArrayList();
    }
    /**
     * 
     * @param strategy Strategy to add
     */
    public void addStrategy(IStrategy strategy){
        strategies.add(strategy);
    }
    /**
     * 
     * @return the list of strategies
     */
    public Collection<IStrategy> getStrategies(){
        return this.strategies;
    }
}
