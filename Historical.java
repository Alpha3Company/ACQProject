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
public class Historical {
    private static Collection<Roll> roll_list;
    private Historical(){
    }
    /**
     * 
     * @return the Historical instance
     */
    public static Collection<Roll> getInstance(){
        if(roll_list==null){
            roll_list=new ArrayList();
        }
        return roll_list;
    }
    public static void deleteInstance(){
        roll_list = null;
    }
}
