/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereservationsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hng
 */
public class Blackboard {
    
    private static Action action;
    
    public Blackboard(Action action){   
        this.action = action;
    }
    
    //special method for supporting the updating process carried out by knowledge sources
    public void update(List<Movie> list){
        // sort the list according to duration
        List<Movie> oriList = new ArrayList<>(list);
        List<Movie> newlist = new ArrayList<>();        
        while(true){
            int min= Integer.MAX_VALUE;
            Movie temp = null;
            for (Movie movie : oriList) {                
                if(min>movie.getStartTime()){
                    min = movie.getStartTime();
                    temp = movie;
                }
            }
            oriList.remove(temp);
            newlist.add(temp);
            if(oriList.isEmpty())
                break;
        }                
        
        //trigger showMovie method
        action.showMovie(newlist);
        
        
    }
}
