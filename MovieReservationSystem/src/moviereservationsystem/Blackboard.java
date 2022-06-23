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
        
        for(Movie movie: oriList){
            ShowTime temp=null;
            List<ShowTime> showTime = new ArrayList<>();
            while(true){
                int min = Integer.MAX_VALUE;
                for (ShowTime st: movie.getShowTime()) {
                    if(min>st.getShowTime()){
                        min = st.getShowTime();
                        temp = st;
                    }
                }                
                movie.getShowTime().remove(temp);
                showTime.add(temp);
                if(movie.getShowTime().isEmpty())
                    break;
            }
            movie.setShowTime(showTime);
        }
        if(list.isEmpty()){
            action.showMovie(oriList);
            action.closeMovie();
        }
        else{
            //trigger showMovie method
            action.showMovie(oriList);            
        }       
        
        
    }
}
