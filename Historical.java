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
public enum Historical {
    Instance;
    private static Collection<Roll> roll_list;
    /**
     * 
     * @return the Historical instance
     */
    public static Collection<Roll> getInstance(){
        if(roll_list==null){
            roll_list=new ArrayList<Roll>();
        }
        return roll_list;
    }
    public static void deleteInstance(){
        roll_list = null;
    }
}
