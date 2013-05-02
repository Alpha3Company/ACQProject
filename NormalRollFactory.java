/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

/**
 *
 * @author gerard
 */
public class NormalRollFactory implements IRollFactory{
    /**
     * 
     * @return Normal Roll
     */
    @Override
    public Roll createNormalRoll(){
        return new NormalRoll();
    }
}
